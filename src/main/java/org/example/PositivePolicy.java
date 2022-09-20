package org.example;

import java.util.HashSet;
import java.util.Set;

public class PositivePolicy {
    private Set<String> shipAttributes = new HashSet<>();
    private Set<String> shipAggregates = new HashSet<>();
    private String fromTable;
    private Set<String> shipLocations = new HashSet<>();
    private String shipWhereClause;
    private Set<String> shipGroupAttributes = new HashSet<>();

    //Get Methods
    public Set<String> getShipAttributes() {return this.shipAttributes;}
    public Set<String> getShipAggregates() {return this.shipAggregates;}
    public String getFromTable() {return this.fromTable;}
    public Set<String> getShipLocations() {return shipLocations;}
    public String getShipWhereClause() {return shipWhereClause;}
    public Set<String> getShipGroupAttributes() {return shipGroupAttributes;}

    //Set Methods
    public void setShipAttributes(String shipAttribute) {
        shipAttributes.add(shipAttribute);
    }
    public void setShipAggregates(String shipAggregate) {shipAggregates.add(shipAggregate);}
    public void setFromTable(String fromTable) {
        this.fromTable = fromTable;
    }
    public void setShipLocations(String shipLocation) {shipLocations.add(shipLocation);}
    public void setShipWhereClause(String shipWhereClause) {this.shipWhereClause = shipWhereClause;}
    public void setShipGroupAttributes(String shipGroupAttribute) {shipGroupAttributes.add(shipGroupAttribute); }
 }
