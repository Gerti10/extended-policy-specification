package org.example;

import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.tools.ValidationException;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ValidationException, SqlParseException, SQLException {

        PolicyEvaluator evaluator = new PolicyEvaluator();
        SqlParser queryParser = new SqlParser();
        ParserFactory parserFactory = new ParserFactory();
        ArrayList<String> queries = new ArrayList<>(); //TPC-H queries for evaluation
        ArrayList<String> allowAllPolicies = new ArrayList<>(); //Positive policies that allow every attribute to be shipped to all locations
        ArrayList<String> denyAttributesPolicies = new ArrayList<>();  //Policies with 10 negative clauses each that deny attributes to be shipped
        ArrayList<String> positiveOnlyAttrPolicies = new ArrayList<>(); //Policies from "denyAttributes" expressed with possitive policies only
        ArrayList<String> denyAggrExprPolicies = new ArrayList<>(); //Aggregate expressions with negative policies for table lineitem
        ArrayList<String> denyBasicExprPolicies = new ArrayList<>(); //Basic policies denying the same attributes as the aggregate expressions
        ArrayList<String> allowAggrExprPolicies = new ArrayList<>(); //Aggregate expressions with only positive policies for table lineitem


        String q1 = "select " +
                "l_returnflag, " +
                "l_linestatus, " +
                "l_shipmode, " +
                "sum(l_quantity) as sum_qty, " +
                "sum(l_extendedprice) as sum_base_price, " +
                "avg(l_quantity) as avg_qty, " +
                "avg(l_extendedprice) as avg_price, " +
                "avg(l_discount) as avg_disc, " +
                "count(l_linenumber) as count_order, " +
                "sum(l_tax) as sum_tax " +
                "from " +
                "public.lineitem " +
                "group by " +
                "l_returnflag, " +
                "l_linestatus, " +
                "l_shipmode " +
                "order by " +
                "l_returnflag, " +
                "l_linestatus";


        String q2 = "select " +
                "s_acctbal, s_name, n_name, p_partkey, p_mfgr, s_address, s_phone, s_comment " +
                "from " +
                "public.part, public.supplier, public.partsupp, public.nation, public.region " +
                "where " +
                "p_partkey = ps_partkey " +
                "and s_suppkey = ps_suppkey " +
                "and s_nationkey = n_nationkey " +
                "and n_regionkey = r_regionkey ";

        //Same as query 2 but modified to retrieve all attributes (total: 28 attributes)
        String q2All = "select *" +
                "from " +
                "public.part, public.supplier, public.partsupp, public.nation, public.region " +
                "where " +
                "p_partkey = ps_partkey " +
                "and s_suppkey = ps_suppkey " +
                "and s_nationkey = n_nationkey " +
                "and n_regionkey = r_regionkey ";

        String q3 = "select " +
                "l_orderkey, " +
                "sum(l_extendedprice) as revenue, " +
                "o_orderdate, " +
                "o_shippriority " +
                "from " +
                "public.customer, public.orders, public.lineitem " +
                "where " +
                "c_custkey = o_custkey " +
                "and l_orderkey = o_orderkey " +
                "group by " +
                "l_orderkey, " +
                "o_orderdate, " +
                "o_shippriority ";


        String q4 = "select " +
                "o_orderpriority, " +
                "count(o_orderkey) as order_count " +
                "from " +
                "public.orders " +
                "group by " +
                "o_orderpriority ";

        String q5 = "select " +
                "n_name " +
                "from " +
                "public.customer, public.orders, public.lineitem, public.supplier, public.nation, public.region " +
                "where " +
                "c_custkey = o_custkey " +
                "and l_orderkey = o_orderkey " +
                "and l_suppkey = s_suppkey " +
                "and c_nationkey = s_nationkey " +
                "and s_nationkey = n_nationkey " +
                "and n_regionkey = r_regionkey ";

        //same as query 5 but modified to retrieve all attributes (total: 47 Attributes)
        String q5All = "select *" +
                "from " +
                "public.customer, public.orders, public.lineitem, public.supplier, public.nation, public.region " +
                "where " +
                "c_custkey = o_custkey " +
                "and l_orderkey = o_orderkey " +
                "and l_suppkey = s_suppkey " +
                "and c_nationkey = s_nationkey " +
                "and s_nationkey = n_nationkey " +
                "and n_regionkey = r_regionkey ";

        //same as query 5 but doesn't perform joins
        String q5J = "select n_name " +
                "from " +
                "public.nation ";


        String q10 = "select " +
                "c_custkey, " +
                "c_name, " +
                "l_extendedprice, " +
                "l_quantity, " +
                "l_tax, " +
                "l_discount, " +
                "o_totalprice, " +
                "o_orderkey, " +
                "c_acctbal, " +
                "n_name, " +
                "c_address, " +
                "c_phone, " +
                "c_comment " +
                "l_returnflag, " +
                "l_linestatus, " +
                "l_shipmode, " +
                "c_mktsegment " +
                "from " +
                "public.customer, public.orders, public.lineitem, public.nation " +
                "where " +
                "c_custkey = o_custkey " +
                "and l_orderkey = o_orderkey " +
                "and c_nationkey = n_nationkey ";

        //same as query 10 but modified to retrieve 10 aggregations and 10 grouping attributes
        String q10Aggr = "select " +
                "c_custkey, " +
                "c_name, " +
                "sum(l_extendedprice) as revenue, " +
                "sum(l_quantity) as sum_qty, " +
                "max(l_tax) as max_tax, " +
                "min(l_tax) as min_tax, " +
                "avg(l_extendedprice) as avg_revenue, " +
                "avg(l_quantity) as avg_qty, " +
                "avg(l_discount) as avg_discount, " +
                "sum(c_acctbal) as sum_acctbal, " +
                "sum(o_totalprice) as sum_totalprice, " +
                "count(o_orderkey) as count_orders, " +
                "n_name, " +
                "c_address, " +
                "c_phone, " +
                "c_comment, " +
                "l_returnflag, " +
                "l_linestatus, " +
                "l_shipmode, " +
                "c_mktsegment " +
                "from " +
                "public.customer, public.orders, public.lineitem, public.nation " +
                "where " +
                "c_custkey = o_custkey " +
                "and l_orderkey = o_orderkey " +
                "and c_nationkey = n_nationkey " +
                "group by " +
                "c_custkey, " +
                "c_name, " +
                "c_phone, " +
                "n_name, " +
                "c_address, " +
                "c_comment, " +
                "l_returnflag, " +
                "l_linestatus, " +
                "l_shipmode, " +
                "c_mktsegment ";

        queries.add(q1);
        queries.add(q2);
        queries.add(q2All);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);
        queries.add(q5All);
        queries.add(q5J);
        queries.add(q10);
        queries.add(q10Aggr);


        //loop to measure the overhead when parsing queries
        /*
        for (String q : queries){
            for (int i = 0; i < 30; i++){
                long evalTimeStart = System.nanoTime();
                queryParser.sqlQueryParser(q);
                long evalTimeStop = System.nanoTime();
                double runtime = (double) (evalTimeStop - evalTimeStart)/1000000;
                System.out.println(runtime);
            }
            System.out.println("-------------------------");
        }*/


        /**
         * Policies that allow all data to be transferred to every locations. Used to evaluate the overhead caused when
         * no restrictions should apply to the database
         */
        String policyOrders = "SHIP o_orderkey, o_custkey, o_orderstatus, o_totalprice, o_orderdate, o_orderpriority, " +
                "o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allows all attributes of table Lineitem to be shipped
        String policyLineitem = "SHIP l_orderkey, l_partkey, l_suppkey, l_linenumber, l_quantity, l_extendedprice, l_discount, " +
                "l_tax, l_returnflag, l_linestatus, l_shipdate, l_comitdate, l_receiptdate, l_shipinstruct, l_shipmode" +
                "l_comment " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allows all attributes of table customer to be shipped
        String policyCustomer = "SHIP c_custkey, c_name, c_address, c_nationskey, c_phone, c_acctbal, c_mktsegment, c_comment " +
                "FROM customer " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allows all atibutes of supplier to be shipped
        String policySupplier = "SHIP s_suppkey, s_name, s_address, s_nationskey, s_phone, s_acctbal, s_comment " +
                "FROM supplier " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allows all attributes of Nation to be shipped
        String policyNation = "SHIP n_nationskey, n_name, n_regionskey, n_comment " +
                "FROM nation " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allow all attributes of Part to be shipped
        String policyPart = "SHIP p_partkey, p_name, p_mfgr, p_brand, p_type, p_size, p_container, p_retailprice, p_comment " +
                "FROM part " +
                "TO locations";

        //Allow all attributes of Partsupp to be shipped
        String policyPartsupp = "SHIP ps_partkey, ps_suppkey, ps_availqty, ps_supplycost, ps_comment " +
                "FROM partsupp " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan ";

        //Allow all attributes of Region to be shipped
        String policyRegion = "SHIP r_regionkey, r_regionname, r_comment " +
                "FROM region " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan";

        allowAllPolicies.add(policyCustomer);
        allowAllPolicies.add(policyLineitem);
        allowAllPolicies.add(policyNation);
        allowAllPolicies.add(policyPartsupp);
        allowAllPolicies.add(policyRegion);
        allowAllPolicies.add(policyOrders);
        allowAllPolicies.add(policyPart);
        allowAllPolicies.add(policySupplier);


        //loop to parse every policy expression in allowAllPolicies list.
        /*for (String p : allowAllPolicies){
            parserFactory.createParser(p);
        }*/


        /**
         * Expressions to measure the overhead caused by negative policies
         */
        String negAttrOrders = "SHIP o_orderkey, o_custkey, o_orderstatus, o_totalprice, o_orderdate, o_orderpriority, " +
                "o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT o_orderkey, o_custkey, o_totalprice, o_orderdate TO Germany " +
                "EXCEPT o_orderdate, o_totalprice, o_orderpriority TO UK " +
                "EXCEPT o_orderpriority, o_totalprice, o_comment TO Russia " +
                "EXCEPT o_shippriority, o_totalprice, o_clerk TO USA " +
                "EXCEPT o_totalprice, o_shippriority TO Canada " +
                "EXCEPT o_comment, o_orderkey, o_totalprice, o_orderdate TO Brasil " +
                "EXCEPT o_clerk, o_totalprice, o_orderpriority, o_custkey TO Argentina " +
                "EXCEPT o_custkey, o_totalprice, o_orderstatus TO China " +
                "EXCEPT o_orderstatus, o_totalprice, o_custkey, o_orderkey, o_orderdate TO India " +
                "Except o_orderpriority, o_totalprice TO Japan";

        String negAttrLineitem = "SHIP l_orderkey, l_partkey, l_suppkey, l_linenumber, l_quantity, l_extendedprice, l_discount, " +
                "l_tax, l_returnflag, l_linestatus, l_shipdate, l_commitdate, l_receiptdate, l_shipinstruct, l_shipmode, " +
                "l_comment " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT l_partkey, l_linenumber, l_quantity, l_extendedprice, l_discount, l_tax TO Germany " +
                "EXCEPT l_partkey, l_quantity, l_discount, l_returnflag, l_extendedprice, l_linenumber, l_comment, l_tax TO UK " +
                "EXCEPT l_linestatus, l_returnflag, l_shipdate, l_discount, l_extendedprice, l_quantity, l_linenumber, l_commitdate, l_tax TO Russia " +
                "EXCEPT l_receiptdate, l_extendedprice, l_discount, l_linenumber, l_quantity, l_tax TO USA " +
                "EXCEPT l_partkey, l_linestatus, l_quantity, l_linenumber, l_extendedprice, l_discount, l_tax TO Canada " +
                "EXCEPT l_shipmode, l_tax, l_linenumber, l_quantity, l_discount, l_extendedprice, l_returnflag, l_tax TO Brasil " +
                "EXCEPT l_partkey, l_suppkey, l_quantity, l_discount, l_linenumber, l_extendedprice, l_tax TO Argentina " +
                "EXCEPT l_linestatus, l_shipinstruct, l_linenumber, l_discount, l_quantity, l_extendedprice, l_comment, l_tax TO China " +
                "EXCEPT l_linenumber, l_returnflag, l_extendedprice, l_discount, l_quantity, l_shipdate, l_receiptdate, l_tax TO India " +
                "EXCEPT l_receiptdate, l_returnflag, l_partkey, l_discount, l_linenumber, l_extendedprice, l_quantity, l_tax TO Japan ";

        String negAttrCustomer = "SHIP c_custkey, c_name, c_address, c_nationskey, c_phone, c_acctbal, c_mktsegment, c_comment " +
                "FROM customer " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT c_custkey, c_name, c_phone, c_address, c_acctbal TO Germany " +
                "EXCEPT c_phone, c_address, c_acctbal, c_mktsegment, c_comment TO UK " +
                "EXCEPT c_custkey, c_name, c_acctbal, c_mktsegment TO Russia " +
                "EXCEPT c_custkey, c_acctbal, c_comment TO Canada " +
                "EXCEPT c_acctbal, c_address, c_mktsegment TO Brasil " +
                "EXCEPT c_acctbal, c_comment TO Argentina " +
                "EXCEPT c_custkey, c_name, c_mktsegment, c_acctbal, c_comment, c_address TO China " +
                "EXCEPT c_name, c_comment, c_address, c_acctbal TO India " +
                "EXCEPT c_name, c_acctbal, c_mktsegment TO Japan " +
                "EXCEPT c_name, c_address, c_phone, c_acctbal, c_mktsegment TO USA";

        String negAttrSupplier = "SHIP s_suppkey, s_name, s_address, s_nationskey, s_phone, s_acctbal, s_comment " +
                "FROM supplier " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT s_suppkey, s_name, s_acctbal, s_address TO Germany " +
                "EXCEPT s_address, s_acctbal TO UK " +
                "EXCEPT s_suppkey, s_name , s_acctbal, s_comment TO Russia " +
                "EXCEPT s_address, s_acctbal TO USA " +
                "EXCEPT s_suppkey, s_name, s_acctbal TO Canada " +
                "EXCEPT s_phone, s_acctbal TO Brasil " +
                "EXCEPT s_suppkey, s_name, s_acctbal, s_phone TO Argentina " +
                "EXCEPT s_address, s_acctbal, s_comment TO China " +
                "EXCEPT s_suppkey, s_acctbal, s_name, s_phone TO India " +
                "EXCEPT s_phone, s_acctbal, s_comment TO Japan ";

        String negAttrNation = "SHIP n_nationskey, n_name, n_regionskey, n_comment " +
                "FROM nation " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT n_name TO Germany " +
                "EXCEPT n_comment TO UK " +
                "EXCEPT n_nationskey TO Russia " +
                "EXCEPT n_name, n_comment TO USA " +
                "EXCEPT n_nationskey, n_name TO Canada " +
                "EXCEPT n_name, n_regionskey TO Brasil " +
                "EXCEPT n_nationskey, n_name TO Argentina " +
                "EXCEPT n_nationskey, n_regionskey TO China " +
                "EXCEPT n_nationskey, n_name, n_comment TO India " +
                "EXCEPT n_nationskey, n_regionskey TO Japan ";

        String negAttrPart = "SHIP p_partkey, p_name, p_mfgr, p_brand, p_type, p_size, p_container, p_retailprice, p_comment " +
                "FROM part " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan  " +
                "EXCEPT p_type, p_mfgr, p_size, p_retailprice TO Germany " +
                "EXCEPT p_partkey, p_brand, p_size, p_retailprice, p_container TO UK " +
                "EXCEPT p_retailprice, p_mfgr TO Russia " +
                "EXCEPT p_type, p_mfgr, p_retailprice, p_container TO USA " +
                "EXCEPT p_partkey, p_size, p_comment, p_retailprice, p_container TO Canada " +
                "EXCEPT p_type, p_mfgr, p_comment TO Brasil " +
                "EXCEPT p_partkey, p_brand, p_retailprice TO Argentina " +
                "EXCEPT p_type, p_mfgr, p_container TO China " +
                "EXCEPT p_retailprice, p_mfgr, p_comment TO India " +
                "EXCEPT p_retailprice, p_mfgr, p_size TO Japan ";

        String negAttrPartsupp = "SHIP ps_partkey, ps_suppkey, ps_availqty, ps_supplycost, ps_comment " +
                "FROM partsupp " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT ps_partkey, ps_suppkey, ps_availqty, ps_comment TO UK " +
                "EXCEPT ps_supplycost TO Russia " +
                "EXCEPT ps_partkey, ps_availqty, ps_supplycost TO USA " +
                "EXCEPT ps_partkey, ps_suppkey, ps_comment TO Canada " +
                "EXCEPT ps_supplycost TO Brasil " +
                "EXCEPT ps_partkey, ps_suppkey TO Argentina " +
                "EXCEPT ps_availqty, ps_comment TO China " +
                "EXCEPT ps_partkey, ps_suppkey, ps_supplycost TO India " +
                "EXCEPT ps_supplycost, ps_availqty TO Japan " +
                "EXCEPT ps_partkey, ps_comment TO Germany " ;



        denyAttributesPolicies.add(negAttrCustomer);
        denyAttributesPolicies.add(negAttrLineitem);
        denyAttributesPolicies.add(negAttrOrders);
        denyAttributesPolicies.add(negAttrNation);
        denyAttributesPolicies.add(negAttrPart);
        denyAttributesPolicies.add(negAttrSupplier);
        denyAttributesPolicies.add(negAttrPartsupp);

        /*for (String p: denyAttributesPolicies){
            parserFactory.createParser(p);
        }*/

        /**
         * Policies to measure the overhead caused by using only positive policiey to express the same constraints as
         * the negative policies above
         */
        String posAttrOrderGER = "SHIP o_orderstatus, o_orderpriority, o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO Germany";
        String posAttrOrderUK = "SHIP o_orderkey, o_custkey, o_orderstatus, o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO UK";
        String posAttrOrderRUS = "SHIP o_orderkey, o_custkey, o_orderstatus, o_orderdate, o_clerk, o_shippriority " +
                "FROM orders " +
                "TO Russia";
        String posAttrOrderUSA = "SHIP o_orderkey, o_custkey, o_orderstatus, o_orderdate, o_orderpriority, o_comment " +
                "FROM orders " +
                "TO USA";
        String posAttrOrderCAN = "SHIP o_orderkey, o_custkey, o_orderstatus, o_orderdate, o_orderpriority, o_clerk, o_comment " +
                "FROM orders " +
                "TO Canada";
        String posAttrOrderBRA = "SHIP o_custkey, o_orderstatus, o_orderpriority, o_clerk, o_shippriority " +
                "FROM orders " +
                "TO Brasil";
        String posAttrOrderARG = "SHIP o_orderkey, o_orderstatus, o_orderdate, o_shippriority, o_comment " +
                "FROM orders " +
                "TO Argentina";
        String posAttrOrderCHI = "SHIP o_orderkey, o_orderdate, o_orderpriority, o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO China";
        String posAttrOrderIND = "SHIP o_orderpriority, o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO India";
        String posAttrOrderJAP = "SHIP o_orderkey, o_custkey, o_orderstatus, o_orderdate, o_clerk, o_shippriority, o_comment " +
                "FROM orders " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrOrderARG);
        positiveOnlyAttrPolicies.add(posAttrOrderBRA);
        positiveOnlyAttrPolicies.add(posAttrOrderCAN);
        positiveOnlyAttrPolicies.add(posAttrOrderCHI);
        positiveOnlyAttrPolicies.add(posAttrOrderGER);
        positiveOnlyAttrPolicies.add(posAttrOrderIND);
        positiveOnlyAttrPolicies.add(posAttrOrderJAP);
        positiveOnlyAttrPolicies.add(posAttrOrderRUS);
        positiveOnlyAttrPolicies.add(posAttrOrderUK);
        positiveOnlyAttrPolicies.add(posAttrOrderUSA);

        String posAttrLineitemGER = "SHIP l_orderkey, l_suppkey, l_returnflag, l_linestatus, l_shipdate, l_commitdate, " +
                "l_receiptdate, l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Germany";

        String posAttrLineitemUK = "SHIP l_orderkey, l_suppkey, l_linestatus, l_shipdate, l_commitdate, l_receiptdate, " +
                "l_shipinstruct, l_shipmode " +
                "FROM lineitem " +
                "TO UK";

        String posAttrLineitemRUS = "SHIP l_orderkey, l_partkey, l_suppkey, l_receiptdate, l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Russia";

        String posAttrLineitemUSA = "SHIP l_orderkey, l_partkey, l_suppkey, l_returnflag, l_linestatus, l_shipdate, " +
                "l_commitdate, l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO USA";

        String posAttrLineitemCAN = "SHIP l_orderkey, l_suppkey, l_returnflag, l_shipdate, l_commitdate, l_receiptdate, " +
                "l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Canada";

        String posAttrLineitemBRA = "SHIP l_orderkey, l_returnflag, l_linestatus, l_shipdate, " +
                "l_commitdate, l_receiptdate, l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Brasil";

        String posAttrLineitemARG = "SHIP  l_orderkey, l_returnflag, l_linestatus, l_shipdate, l_commitdate, l_receiptdate, " +
                "l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Argentina";

        String posAttrLineitemCHI = "SHIP l_orderkey, l_partkey, l_suppkey, l_returnflag, l_shipdate, l_commitdate, " +
                "l_receiptdate, l_shipmode " +
                "FROM lineitem " +
                "TO China";

        String posAttrLineitemIND = "SHIP l_orderkey, l_partkey, l_suppkey, l_linestatus, l_commitdate, " +
                "l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO India";

        String posAttrLineitemJAP = "SHIP l_orderkey, l_suppkey, l_linestatus, l_shipdate, l_commitdate, " +
                "l_shipinstruct, l_shipmode, l_comment " +
                "FROM lineitem " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrLineitemARG);
        positiveOnlyAttrPolicies.add(posAttrLineitemBRA);
        positiveOnlyAttrPolicies.add(posAttrLineitemCAN);
        positiveOnlyAttrPolicies.add(posAttrLineitemCHI);
        positiveOnlyAttrPolicies.add(posAttrLineitemGER);
        positiveOnlyAttrPolicies.add(posAttrLineitemIND);
        positiveOnlyAttrPolicies.add(posAttrLineitemJAP);
        positiveOnlyAttrPolicies.add(posAttrLineitemRUS);
        positiveOnlyAttrPolicies.add(posAttrLineitemUK);
        positiveOnlyAttrPolicies.add(posAttrLineitemUSA);

        String posAttrCustGER = "SHIP c_nationskey, c_mktsegment, c_comment " +
                "FROM customer " +
                "TO Germany";

        String posAttrCustUK = "SHIP c_custkey, c_name, c_nationskey " +
                "FROM customer " +
                "TO UK";

        String posAttrCustRUS = "SHIP c_address, c_nationskey, c_phone, c_comment " +
                "FROM customer " +
                "TO Russia";

        String posAttrCustCAN = "SHIP c_name, c_address, c_nationskey, c_phone, c_mktsegment " +
                "FROM customer " +
                "TO Canada";

        String posAttrCustBRA = "SHIP c_custkey, c_name, c_nationskey, c_phone, c_comment " +
                "FROM customer " +
                "TO Brasil";

        String posAttrCustARG = "SHIP c_custkey, c_name, c_address, c_nationskey, c_phone, c_mktsegment " +
                "FROM customer " +
                "TO Argentina";

        String posAttrCustCHI = "SHIP c_nationskey, c_phone " +
                "FROM customer " +
                "TO China";

        String posAttrCustIND = "SHIP c_custkey, c_nationskey, c_phone, c_mktsegment " +
                "FROM customer " +
                "TO India";

        String posAttrCustJAP = "SHIP c_custkey, c_address, c_nationskey, c_phone, c_comment " +
                "FROM customer " +
                "TO Japan";

        String posAttrCustUSA = "SHIP c_custkey, c_nationskey, c_comment " +
                "FROM customer " +
                "TO USA";

        positiveOnlyAttrPolicies.add(posAttrCustARG);
        positiveOnlyAttrPolicies.add(posAttrCustBRA);
        positiveOnlyAttrPolicies.add(posAttrCustCAN);
        positiveOnlyAttrPolicies.add(posAttrCustCHI);
        positiveOnlyAttrPolicies.add(posAttrCustGER);
        positiveOnlyAttrPolicies.add(posAttrCustIND);
        positiveOnlyAttrPolicies.add(posAttrCustJAP);
        positiveOnlyAttrPolicies.add(posAttrCustRUS);
        positiveOnlyAttrPolicies.add(posAttrCustUK);
        positiveOnlyAttrPolicies.add(posAttrCustUSA);

        String posAttrSupplierGER = "SHIP s_nationskey, s_phone, s_comment " +
                "FROM supplier " +
                "TO Germany";

        String posAttrSupplierUK = "SHIP s_suppkey, s_name, s_nationskey, s_phone, s_comment " +
                "FROM supplier " +
                "TO UK";

        String posAttrSupplierRUS = "SHIP s_address, s_nationskey, s_phone " +
                "FROM supplier " +
                "TO Russia";

        String posAttrSupplierUSA = "SHIP s_suppkey, s_name, s_nationskey, s_phone, s_comment " +
                "FROM supplier " +
                "TO USA";

        String posAttrSupplierCAN = "SHIP s_address, s_nationskey, s_phone, s_comment " +
                "FROM supplier " +
                "TO Canada";

        String posAttrSupplierBRA = "SHIP s_suppkey, s_name, s_address, s_nationskey, s_comment " +
                "FROM supplier " +
                "TO Brasil";

        String posAttrSupplierARG = "SHIP s_address, s_nationskey, s_comment " +
                "FROM supplier " +
                "TO Argentina";

        String posAttrSupplierCHI = "SHIP s_suppkey, s_name, s_nationskey, s_phone " +
                "FROM supplier " +
                "TO China";

        String posAttrSupplierIND = "SHIP s_address, s_nationskey, s_comment " +
                "FROM supplier " +
                "TO India";

        String posAttrSupplierJAP = "SHIP s_suppkey, s_name, s_address, s_nationskey " +
                "FROM supplier " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrSupplierARG);
        positiveOnlyAttrPolicies.add(posAttrSupplierBRA);
        positiveOnlyAttrPolicies.add(posAttrSupplierCAN);
        positiveOnlyAttrPolicies.add(posAttrSupplierCHI);
        positiveOnlyAttrPolicies.add(posAttrSupplierGER);
        positiveOnlyAttrPolicies.add(posAttrSupplierIND);
        positiveOnlyAttrPolicies.add(posAttrSupplierJAP);
        positiveOnlyAttrPolicies.add(posAttrSupplierRUS);
        positiveOnlyAttrPolicies.add(posAttrSupplierUK);
        positiveOnlyAttrPolicies.add(posAttrSupplierUSA);

        String posAttrNationGER = "SHIP n_nationskey, n_regionskey, n_comment " +
                "FROM nation " +
                "TO Germany";

        String posAttrNationUK = "SHIP n_nationskey, n_regionskey " +
                "FROM nation " +
                "TO UK";

        String posAttrNationRUS = "SHIP n_name, n_regionskey " +
                "FROM nation " +
                "TO Russia";

        String posAttrNationUSA = "SHIP n_nationskey, n_regionskey " +
                "FROM nation " +
                "TO USA";

        String posAttrNationCAN = "SHIP n_regionskey, n_comment " +
                "FROM nation " +
                "TO Canada";

        String posAttrNationBRA = "SHIP n_nationskey, n_comment " +
                "FROM nation " +
                "TO Brasil";

        String posAttrNationARG = "SHIP n_regionskey, n_comment " +
                "FROM nation " +
                "TO Argentina";

        String posAttrNationCHI = "SHIP n_name, n_comment " +
                "FROM nation " +
                "TO China";

        String posAttrNationIND = "SHIP n_regionskey " +
                "FROM nation " +
                "TO India";

        String posAttrNationJAP = "SHIP n_name, n_comment " +
                "FROM nation " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrNationARG);
        positiveOnlyAttrPolicies.add(posAttrNationBRA);
        positiveOnlyAttrPolicies.add(posAttrNationCAN);
        positiveOnlyAttrPolicies.add(posAttrNationCHI);
        positiveOnlyAttrPolicies.add(posAttrNationGER);
        positiveOnlyAttrPolicies.add(posAttrNationIND);
        positiveOnlyAttrPolicies.add(posAttrNationJAP);
        positiveOnlyAttrPolicies.add(posAttrNationRUS);
        positiveOnlyAttrPolicies.add(posAttrNationUK);
        positiveOnlyAttrPolicies.add(posAttrNationUSA);

        String posAttrPartGER = "SHIP p_partkey, p_name, p_brand, p_container, p_comment " +
                "FROM part " +
                "TO Germany";

        String posAttrPartUK = "SHIP p_name, p_mfgr, p_type, p_container, p_comment, p_container " +
                "FROM part " +
                "TO UK";

        String posAttrPartRUS = "SHIP p_partkey, p_name, p_brand, p_type, p_size, p_container, p_comment " +
                "FROM part " +
                "TO Russia";

        String posAttrPartUSA = "SHIP p_partkey, p_name, p_brand, p_size, p_container, p_comment, p_container " +
                "FROM part " +
                "TO USA";

        String posAttrPartCAN = "SHIP p_name, p_mfgr, p_brand, p_type, p_container " +
                "FROM part " +
                "TO Canada";

        String posAttrPartBRA = "SHIP p_partkey, p_name, p_brand, p_size, p_container, p_retailprice " +
                "FROM part " +
                "TO Brasil";

        String posAttrPartARG = "SHIP p_name, p_mfgr, p_type, p_size, p_container, p_comment " +
                "FROM part " +
                "TO Argentina";

        String posAttrPartCHI = "SHIP p_partkey, p_name, p_brand, p_size, p_retailprice, p_comment, p_container " +
                "FROM part " +
                "TO China";

        String posAttrPartIND = "SHIP p_partkey, p_name, p_brand, p_type, p_size, p_container " +
                "FROM part " +
                "TO India";

        String posAttrPartJAP = "SHIP p_partkey, p_name, p_brand, p_type, p_container, p_comment " +
                "FROM part " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrPartARG);
        positiveOnlyAttrPolicies.add(posAttrPartBRA);
        positiveOnlyAttrPolicies.add(posAttrPartCAN);
        positiveOnlyAttrPolicies.add(posAttrPartCHI);
        positiveOnlyAttrPolicies.add(posAttrPartGER);
        positiveOnlyAttrPolicies.add(posAttrPartIND);
        positiveOnlyAttrPolicies.add(posAttrPartJAP);
        positiveOnlyAttrPolicies.add(posAttrPartRUS);
        positiveOnlyAttrPolicies.add(posAttrPartUK);
        positiveOnlyAttrPolicies.add(posAttrPartUSA);

        String posAttrPartSuppGER = "SHIP ps_suppkey, ps_availqty, ps_supplycost " +
                "FROM partsupp " +
                "TO Germany";

        String posAttrPartSuppUK = "SHIP ps_supplycost " +
                "FROM partsupp " +
                "TO UK";

        String posAttrPartSuppRUS = "SHIP ps_partkey, ps_suppkey, ps_availqty, ps_comment " +
                "FROM partsupp " +
                "TO Russia";

        String posAttrPartSuppUSA = "SHIP ps_suppkey, ps_comment " +
                "FROM partsupp " +
                "TO USA";

        String posAttrPartSuppCAN = "SHIP ps_availqty, ps_supplycost " +
                "FROM partsupp " +
                "TO Canada";

        String posAttrPartSuppBRA = "SHIP ps_partkey, ps_suppkey, ps_availqty, ps_comment " +
                "FROM partsupp " +
                "TO Brasil";

        String posAttrPartSuppARG = "SHIP ps_availqty, ps_supplycost, ps_comment " +
                "FROM partsupp " +
                "TO Argentina";

        String posAttrPartSuppCHI = "SHIP ps_partkey, ps_suppkey, ps_supplycost " +
                "FROM partsupp " +
                "TO China";

        String posAttrPartSuppIND = "SHIP ps_availqty, ps_comment " +
                "FROM partsupp " +
                "TO India";

        String posAttrPartSuppJAP = "SHIP ps_partkey, ps_suppkey, ps_comment " +
                "FROM partsupp " +
                "TO Japan";

        positiveOnlyAttrPolicies.add(posAttrPartSuppARG);
        positiveOnlyAttrPolicies.add(posAttrPartSuppBRA);
        positiveOnlyAttrPolicies.add(posAttrPartSuppCAN);
        positiveOnlyAttrPolicies.add(posAttrPartSuppCHI);
        positiveOnlyAttrPolicies.add(posAttrPartSuppGER);
        positiveOnlyAttrPolicies.add(posAttrPartSuppIND);
        positiveOnlyAttrPolicies.add(posAttrPartSuppJAP);
        positiveOnlyAttrPolicies.add(posAttrPartSuppRUS);
        positiveOnlyAttrPolicies.add(posAttrPartSuppUK);
        positiveOnlyAttrPolicies.add(posAttrPartSuppUSA);


        /*for (String p: positiveOnlyAttrPolicies){
            parserFactory.createParser(p);
        }*/


        /**
         * Expression to measure the overhead caused by negative policies in aggregate expressions
         */
        String negAggrLineitem = "SHIP l_linenumber, l_quantity, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES count, sum, avg, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag " +
                "EXCEPT l_linenumber AS AGGREGATES count, min, max TO Germany GROUP BY l_shipdate, l_linestatus " +
                "EXCEPT l_linenumber AS AGGREGATES count, sum, avg TO UK GROUP BY l_shipmode, l_returnflag " +
                "EXCEPT l_quantity AS AGGREGATES count, sum TO Russia GROUP BY l_linestatus " +
                "EXCEPT l_extendedprice AS AGGREGATES count, sum, max TO USA GROUP BY l_returnflag " +
                "EXCEPT l_extendedprice AS AGGREGATES sum TO Germany, Canada GROUP BY l_shipdate, l_shipmode, l_returnflag " +
                "EXCEPT l_quantity AS AGGREGATES count, min, max TO Brasil GROUP BY l_shipdate " +
                "EXCEPT l_discount AS AGGREGATES avg, min, max TO Argentina GROUP BY l_linestatus " +
                "EXCEPT l_quantity, l_discount AS AGGREGATES avg, sum, count TO China GROUP BY l_receiptdate " +
                "EXCEPT l_tax AS AGGREGATES avg, sum TO Japan GROUP BY l_shipinstruct " +
                "EXCEPT l_tax AS AGGREGATES min, max, count TO Brasil " +
                "EXCEPT l_quantity AS AGGREGATES sum, avg TO Canada " +
                "EXCEPT l_discount, l_extendedprice AS AGGREGATES avg, count TO Brasil " +
                "EXCEPT l_linenumber AS AGGREGATES count, sum, max, avg TO USA, Canada GROUP BY l_shipinstruct, l_linestatus";
        denyAggrExprPolicies.add(negAggrLineitem);

        /*for (String p: denyAggrExprPolicies){
            parserFactory.createParser(p);
        }*/

        /**
         * Policies to compare the overhead of basic expressions with aggregate expressions
         */
        String negBasicLineitem = "SHIP l_linenumber, l_quantity, l_extendedprice, l_discount, l_tax, " +
                "l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "EXCEPT l_linenumber, l_shipdate, l_linestatus TO Germany " +
                "EXCEPT l_linenumber, l_shipmode, l_returnflag TO UK " +
                "EXCEPT l_quantity, l_linestatus TO Russia " +
                "EXCEPT l_extendedprice, l_returnflag TO USA " +
                "EXCEPT l_extendedprice, l_shipdate, l_shipmode, l_returnflag TO Germany, Canada " +
                "EXCEPT l_quantity, l_shipdate TO Brasil " +
                "EXCEPT l_discount, l_linestatus TO Argentina " +
                "EXCEPT l_quantity, l_discount, l_receiptdate TO China " +
                "EXCEPT l_tax, l_shipinstruct TO Japan " +
                "EXCEPT l_tax TO Brasil " +
                "EXCEPT l_quantity TO Canada " +
                "EXCEPT l_discount, l_extendedprice TO Brasil " +
                "EXCEPT l_linenumber, l_shipinstruct, l_linestatus TO USA, Canada";

        denyBasicExprPolicies.add(negBasicLineitem);

       /*for (String p: denyBasicExprPolicies){
            parserFactory.createParser(p);
        }*/

        /**
         * Policies to measure the overhead caused by positive aggregate expressions.
         */
        String posAggrLineitem1 = "SHIP l_quantity, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES sum, avg " +
                "FROM lineitem " +
                "TO UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY l_shipinstruct, l_receiptdate, l_shipmode, l_returnflag ";

        String posAggrLineitem2 = "SHIP l_quantity, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES min, max " +
                "FROM lineitem " +
                "TO Germany, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_linestatus ";

        String posAggrLineitem3 = "SHIP l_linenumber, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES avg, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_returnflag ";

        String posAggrLineitem4 = "SHIP l_linenumber, l_quantity, l_discount, l_tax " +
                "AS AGGREGATES avg, min " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus ";

        String posAggrLineitem5 =  "SHIP l_linenumber, l_quantity, l_discount, l_tax " +
                "AS AGGREGATES count, avg, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipinstruct, l_receiptdate, l_linestatus ";

        String posAggrLineitem6 =  "SHIP l_linenumber, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES sum, avg " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Argentina, China, India, Japan " +
                "GROUP BY  l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem7 =  "SHIP l_linenumber, l_quantity, l_extendedprice, l_tax " +
                "AS AGGREGATES count, sum " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_returnflag ";

        String posAggrLineitem8 =  "SHIP l_linenumber, l_extendedprice, l_tax " +
                "AS AGGREGATES min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem9 =  "SHIP l_linenumber, l_quantity, l_extendedprice, l_discount " +
                "AS AGGREGATES count, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India " +
                "GROUP BY  l_shipdate, l_receiptdate, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem10 =  "SHIP l_linenumber, l_quantity, l_extendedprice, l_discount " +
                "AS AGGREGATES sum, avg " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem11 =  "SHIP l_linenumber, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES count, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem12 =  "SHIP l_linenumber, l_quantity, l_tax " +
                "AS AGGREGATES sum, min, max " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_shipinstruct, l_receiptdate, l_shipmode, l_linestatus, l_returnflag ";

        String posAggrLineitem13 =  "SHIP l_quantity, l_extendedprice, l_discount, l_tax " +
                "AS AGGREGATES min " +
                "FROM lineitem " +
                "TO Germany, UK, Russia, USA, Canada, Brasil, Argentina, China, India, Japan " +
                "GROUP BY  l_shipdate, l_receiptdate, l_shipmode, l_returnflag ";

        allowAggrExprPolicies.add(posAggrLineitem1);
        allowAggrExprPolicies.add(posAggrLineitem2);
        allowAggrExprPolicies.add(posAggrLineitem3);
        allowAggrExprPolicies.add(posAggrLineitem4);
        allowAggrExprPolicies.add(posAggrLineitem5);
        allowAggrExprPolicies.add(posAggrLineitem6);
        allowAggrExprPolicies.add(posAggrLineitem7);
        allowAggrExprPolicies.add(posAggrLineitem8);
        allowAggrExprPolicies.add(posAggrLineitem9);
        allowAggrExprPolicies.add(posAggrLineitem10);
        allowAggrExprPolicies.add(posAggrLineitem11);
        allowAggrExprPolicies.add(posAggrLineitem12);
        allowAggrExprPolicies.add(posAggrLineitem13);

        /*for (String p: allowAggrExprPolicies){
            parserFactory.createParser(p);
        }*/

        String locations25 = "location1, location2, location3, location4, location5, location6, location7, location8, location9, location10, " +
                "location11, location12, location13, location14, location15, location16, location17, location18, location19, location20, " +
                "location21, location22, location23, location24, location25";

        String locations50 = locations25 + ", location26, location27, location28, location29, location30, location31, location32, location33, location34, location35, " +
                "location36, location37, location38, location39, location40, location41, location42, location43, location44, location45, " +
                "location46, location47, location48, location49, location50";

        String locations75 = locations50 + ", location51, location52, location53, location54, location55, location56, location57, location58, location59, location60, " +
                "location61, location62, location63, location64, location65, location66, location67, location68, location69, location70, " +
                "location71, location72, location73, location74, location75";

        String locations100 = locations75 + ", location76, location77, location78, location79, location80, location81, location82, location83, location84, location85, " +
                "location86, location87, location88, location89, location90, location91, location92, location93, location94, location95, " +
                "location96, location97, location98, location99, location100";

        /**
         * Policies to measure the overhead of locations in positive policy expressions
         */

        String posLoc25Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations25;

        String posLoc50Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations50;

        String posLoc75Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations75;

        String posLoc100Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations100;

        //parserFactory.createParser(posLoc25Orders);
        //parserFactory.createParser(posLoc50Orders);
        //parserFactory.createParser(posLoc75Orders);
        //parserFactory.createParser(posLoc100Orders);

        /**
         * Policies to measure the overhead of locations in negative policy expressions
         */
        String negLoc25Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations100 +
                "EXCEPT o_orderpriority " +
                "TO " + locations25;

        String negLoc50Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations100 +
                "EXCEPT o_orderpriority " +
                "TO " + locations50;

        String negLoc75Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations100 +
                "EXCEPT o_orderpriority " +
                "TO " + locations75;

        String negLoc100Orders = "SHIP o_orderkey, o_orderpriority " +
                "FROM orders " +
                "TO " + locations100 +
                "EXCEPT o_orderpriority " +
                "TO " + locations100;

        //parserFactory.createParser(negLoc25Orders);
        //parserFactory.createParser(negLoc50Orders);
        //parserFactory.createParser(negLoc75Orders);
        //parserFactory.createParser(negLoc100Orders);

        /**
         * loop to execute the policy evaluation algorithm and print the run time
         */
        /*
        for (String q : queries){
            Query parsedQuery = queryParser.sqlQueryParser(q);
            for (int i = 0; i < 30; i++){
                long evalTimeStart = System.nanoTime();
                evaluator.policyEvaluation(parserFactory.policies, parsedQuery);
                long evalTimeStop = System.nanoTime();
                double runtime = (double) (evalTimeStop - evalTimeStart)/1000000;
                System.out.println(runtime);
            }
            System.out.println("-------------------------");
        }
         */



        /**
         * To test if the query is parsed correctly
         */
        /*System.out.println("Selected Attributes and Functions: " + testQuery.getSelectAggregate());
        System.out.println("Query Tables: " + testQuery.getTables());
        System.out.println("Query Where Clause: " + testQuery.getWhereClause());
        System.out.println("Query Grouping Attributes: " + testQuery.getGroupingAttributes());
*/
        /**
         * To test if the policy is parsed correctly
         */
       /* System.out.println("------------------------------------------------------------------------------------------------");

        for (Policy p: parserFactory.policies){
            System.out.println("Positive policy");
            System.out.println("ship attributes: " + p.getPositivePolicy().getShipAttributes());
            System.out.println("ship aggregate functions: " + p.getPositivePolicy().getShipAggregates());
            System.out.println("from : " + p.getPositivePolicy().getFromTable());
            System.out.println("ship locations: " + p.getPositivePolicy().getShipLocations());
            System.out.println("ship where condition: " + p.getPositivePolicy().getShipWhereClause());
            System.out.println(("ship group attributes: " + p.getPositivePolicy().getShipGroupAttributes()));

            System.out.println("------------------------------------------------------------------------------------------------");

            for (NegativePolicy ne: p.getNegativePolicies()){
                System.out.println("Negative policies");
                System.out.println("except attributes: " + ne.getExceptAttributes());
                System.out.println("except locations: " + ne.getExceptLocations());
                System.out.println("except aggregate functions: " + ne.getExceptAggregates());
                System.out.println("except where clause: " + ne.getExceptWhereClause());
                System.out.println("except group attributes: " + ne.getExceptGroupAttributes());
                System.out.println("------------------------------------------------------------------------------------------------");
            }
        }*/
    }
}