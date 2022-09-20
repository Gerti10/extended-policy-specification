package org.example;

import java.util.HashSet;
import java.util.Set;

public class NegativePolicy {
    private final Set<String> exceptAttributes = new HashSet<>();
    private final Set<String> exceptAggregates = new HashSet<>();
    private final Set<String> exceptLocations = new HashSet<>();
    private String exceptWhereClause;
    private final Set<String> exceptGroupAttributes = new HashSet<>();


    //Get Methods
    public Set<String> getExceptAttributes() {return exceptAttributes;}
    public Set<String> getExceptAggregates() {return exceptAggregates;}
    public Set<String> getExceptLocations() {return exceptLocations;}
    public String getExceptWhereClause() {return exceptWhereClause;}
    public Set<String> getExceptGroupAttributes() {return exceptGroupAttributes;}

    public void setExceptAttributes(String exceptAttribute) {exceptAttributes.add(exceptAttribute);}
    public void setExceptAggregates(String exceptAggregate) {exceptAggregates.add(exceptAggregate);}
    public void setExceptLocations(String exceptLocation) {exceptLocations.add(exceptLocation);}
    public void setExceptWhereClause(String exceptWhereClause) {this.exceptWhereClause = exceptWhereClause;}
    public void setExceptGroupAttributes(String exceptGroupAttribute) {exceptGroupAttributes.add(exceptGroupAttribute); }
}
