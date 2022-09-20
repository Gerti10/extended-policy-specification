package org.example;

import org.apache.calcite.adapter.jdbc.JdbcSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.plan.Contexts;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;
import org.apache.calcite.tools.ValidationException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class SqlParser {

    private static final String POSTGRESQL_SCHEMA = "public";

    public Query sqlQueryParser(String sqlQuery) throws ValidationException, SqlParseException, SQLException {

        SqlNode node = parseAndValidate(sqlQuery);

        //Create a new query
        Query query = new Query(new HashMap<>(), new HashSet<>(), null, new HashSet<>(), sqlQuery);


        if(SqlKind.SELECT.equals(node.getKind())){
            SqlSelect sqlSelect = (SqlSelect) node;
            SqlNode from = sqlSelect.getFrom();
            SqlNode where = sqlSelect.getWhere();
            SqlNodeList selectList = sqlSelect.getSelectList();
            SqlNodeList groupByAttributes = sqlSelect.getGroup();
            processSelectAggregate(selectList, query);
            if (groupByAttributes != null)processGroupingAttributes(groupByAttributes, query);
            if (from != null)processFromClause(from, query);
            if (where != null)processWhere(where, query);
        }
        return query;
    }

    private SqlNode parseAndValidate(String sqlQuery) throws ValidationException, SqlParseException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:calcite:");
        // Unwrap our connection using the CalciteConnection
        CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);

        // Define our parser Configuration
        org.apache.calcite.sql.parser.SqlParser.Config parserConfig = org.apache.calcite.sql.parser.SqlParser.config()
                                                                                        .withCaseSensitive(false);

        // Get a pointer to our root schema for our Calcite Connection
        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        DataSource postgresDataSource = JdbcSchema.dataSource(
                "jdbc:postgresql://localhost:5433/tpc-h-db",
                "org.postgresql.Driver",
                "postgres", // username
                "qwer1994"   // password
        );
        // Attach our Postgres Jdbc Datasource to our Root Schema
        rootSchema.add(POSTGRESQL_SCHEMA, JdbcSchema.create(rootSchema, POSTGRESQL_SCHEMA,
                postgresDataSource, null, null));

        Frameworks.ConfigBuilder config = Frameworks.newConfigBuilder()
                .defaultSchema(rootSchema)
                .parserConfig(parserConfig)
                .context(Contexts.of(calciteConnection.config()));

        Planner planner = Frameworks.getPlanner(config.build());
        SqlNode node = planner.parse(sqlQuery);
        return planner.validate(node) ;
    }

    private String processAliases(String col){
        String[] tmp = col.split("\\.");
        return tmp[1].replaceAll("[(`)]", "");
    }
    private void processSelectAggregate(SqlNodeList nodeList, Query query){
        Map<String, Set<String>> selectAggregate = new HashMap<>();
        //initialize a set for every attribute in the query output to the associated aggregate functions
        for (SqlNode s: nodeList){
            if (SqlKind.AS.equals(s.getKind())){
                selectAggregate.put(processAliases(((SqlBasicCall) s).operand(0).toString()), new HashSet<>());
            }
        }

        for (SqlNode s: nodeList){
           if (SqlKind.IDENTIFIER.equals(s.getKind())) {
                selectAggregate.put(processAliases(s.toString()), null);
            }
            if (SqlKind.AS.equals(s.getKind())) {
                if (((SqlBasicCall) s).operand(0).getKind().belongsTo(SqlKind.AGGREGATE)){
                    if (((SqlBasicCall) s).operand(0).getKind().equals(SqlKind.SUM)){
                        selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add("sum");
                    }
                    if (((SqlBasicCall) s).operand(0).getKind().equals(SqlKind.COUNT)){
                        selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add("count");
                    }
                    if (((SqlBasicCall) s).operand(0).getKind().equals(SqlKind.AVG)){
                        selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add("avg");
                    }
                    if (((SqlBasicCall) s).operand(0).getKind().equals(SqlKind.MIN)){
                        selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add("min");
                    }
                    if (((SqlBasicCall) s).operand(0).getKind().equals(SqlKind.MAX)){
                        selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add("max");
                    }
                }else {
                    selectAggregate.get(processAliases(((SqlBasicCall) s).operand(0).toString())).add(null);
                }
            }
        }
        query.setSelectAggregate(selectAggregate);
    }

    private void processGroupingAttributes(SqlNodeList nodeList, Query query){
        Set<String> groupingAttributes = new HashSet<>();
        for (SqlNode s : nodeList){
            groupingAttributes.add(processAliases(s.toString()));
        }
        query.setGroupingAttributes(groupingAttributes);
    }

    private void processFromClause(SqlNode from, Query query){
        Set<String> tables = new HashSet<>();
        if (from.getKind().equals(SqlKind.AS)){
            tables.add(processAliases(((SqlBasicCall) from).operand(0).toString()));
        }else if (from.getKind().equals(SqlKind.JOIN)){
            final SqlJoin fromJoin = (SqlJoin) from;
            if (fromJoin.getLeft().getKind().equals(SqlKind.AS)){
                tables.add(processAliases(((SqlBasicCall) fromJoin.getLeft()).operand(0).toString()));
            }else {
                SqlJoin leftJoin = (SqlJoin) fromJoin.getLeft();
                while (!leftJoin.getLeft().getKind().equals(SqlKind.AS)){
                    tables.add(processAliases(((SqlBasicCall) leftJoin.getRight()).operand(0).toString()));
                    leftJoin = (SqlJoin) leftJoin.getLeft();
                }
                tables.add(processAliases(((SqlBasicCall) leftJoin.getLeft()).operand(0).toString()));
                tables.add(processAliases(((SqlBasicCall) leftJoin.getRight()).operand(0).toString()));
            }
            tables.add(processAliases(((SqlBasicCall) fromJoin.getRight()).operand(0).toString()));
        }
        query.setTables(tables);
    }

    //we should process the where clause with calcite. translate the query to select * from where ...
    private void processWhere(SqlNode whereClause, Query query) {
        query.setWhereClause(whereClause.toString());
    }
}
