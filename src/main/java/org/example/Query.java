package org.example;

import java.util.Map;
import java.util.Set;

public class Query {
    private Map<String, Set<String>> selectAggregate;
    private Set<String> tables; //With joins there can be more than one table
    private String whereClause;
    private Set<String> groupingAttributes;
    private String unparsedQuery;


    public Query(Map<String, Set<String>> selectAggregate, Set<String> tables, String whereClause, Set<String> groupingAttributes, String unparsedQuery){
        this.selectAggregate = selectAggregate;
        this.tables = tables;
        this.whereClause = whereClause;
        this.groupingAttributes = groupingAttributes;
        this.unparsedQuery = unparsedQuery;
    }

    //Get Methods
    public Map<String, Set<String>> getSelectAggregate(){return this.selectAggregate;}

    public Set<String> getTables(){return this.tables;}
    public String getWhereClause(){return this.whereClause;}
    public Set<String> getGroupingAttributes(){return this.groupingAttributes;}

    public String getUnparsedQuery(){return this.unparsedQuery;}

    //Set Methods
    public void setGroupingAttributes(Set<String> groupingAttributes) {
        this.groupingAttributes = groupingAttributes;
    }
    public void setTables(Set<String> tables) {
        this.tables = tables;
    }
    public void setSelectAggregate(Map<String, Set<String>> selectAggregate) {
        this.selectAggregate = selectAggregate;
    }
    public void setWhereClause(String whereClause){
        this.whereClause = whereClause;
    }
    public void setUnparsedQuery(String unparsedQuery) {this.unparsedQuery = unparsedQuery; }
}
