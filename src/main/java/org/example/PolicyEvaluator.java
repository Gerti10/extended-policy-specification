package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PolicyEvaluator {
    public Set<String> policyEvaluation(List<Policy> policies, Query q) {

        Map<String, Set<String>> allowedLocations = initAllowedLocationsMap(q); //default policy

        for (Policy p : policies) {
            //check if the policy is defined for a table in the query from clause
            if (q.getTables().contains(p.getPositivePolicy().getFromTable())){
                //check if intersection of query attributes and positive policy not empty
                if (checkIntersectionEmpty(q.getSelectAggregate().keySet(), p.getPositivePolicy().getShipAttributes())) {
                    //placeholder for the implication test of positive policy
                    if (true) {
                        //check if it's a basic policy
                        if (p.getPositivePolicy().getShipAggregates().isEmpty()) {
                            //add locations of positive policy
                            Set<String> attributeIntersection = setIntersection(q.getSelectAggregate().keySet(), p.getPositivePolicy().getShipAttributes());
                            for (String attribute : attributeIntersection) {
                                allowedLocations.get(attribute).addAll(p.getPositivePolicy().getShipLocations());
                                //for every negative policy drop the locations from the map
                                for (NegativePolicy ne : p.getNegativePolicies()) {
                                    //placeholder for the implication test of negative policy
                                    if (true) {
                                        //check if attribute is in the negative policy
                                        if (ne.getExceptAttributes().contains(attribute)) {
                                            allowedLocations.get(attribute).removeAll(ne.getExceptLocations());
                                        }
                                    }
                                }
                            }
                        }
                        else if (!isAllNulls(q.getSelectAggregate().values())){ //if q is an aggregate query
                            //check if grouping attributes are allowed from the positive policy
                            if (p.getPositivePolicy().getShipGroupAttributes().containsAll(q.getGroupingAttributes())){
                                //Union of positive policy ship and Group By attributes
                                Set<String> unionShipGroupBy = setUnion(p.getPositivePolicy().getShipAttributes(), p.getPositivePolicy().getShipGroupAttributes());
                                Set<String> intersectQueryGrouping = setIntersection(q.getSelectAggregate().keySet(), unionShipGroupBy);
                                for (String attribute: intersectQueryGrouping){
                                    if (p.getPositivePolicy().getShipGroupAttributes().contains(attribute) || (p.getPositivePolicy().getShipAttributes().contains(attribute) && p.getPositivePolicy().getShipAggregates().containsAll(q.getSelectAggregate().get(attribute)))){
                                        if (allowedLocations.containsKey(attribute)){
                                            allowedLocations.get(attribute).addAll(p.getPositivePolicy().getShipLocations());
                                        }else {
                                            allowedLocations.put(attribute, p.getPositivePolicy().getShipLocations());
                                        }
                                    }
                                    for (NegativePolicy ne : p.getNegativePolicies()){
                                        //Placeholder for the implication test of negative policy
                                        if (true){
                                            //case when no grouping attributes are specified in the negative policy
                                            if (ne.getExceptGroupAttributes().isEmpty()){
                                                if (ne.getExceptAttributes().contains(attribute)){
                                                    for(String aggrFunc : ne.getExceptAggregates()){
                                                        //check if the query attribute is aggregated with any denied aggregate function
                                                        if (q.getSelectAggregate().get(attribute).contains(aggrFunc)){
                                                            allowedLocations.get(attribute).removeAll(ne.getExceptLocations());
                                                        }
                                                    }
                                                }
                                            }//case when grouping attribute is specified in the negative policy. Then at least one of these attributes
                                            //should be used by the query in order to remove the locations
                                            else if (setIntersection(ne.getExceptGroupAttributes(), q.getGroupingAttributes()).size() >=1){
                                                if (ne.getExceptAttributes().contains(attribute)){
                                                    for(String aggrFunc : ne.getExceptAggregates()){
                                                        //check if the query attribute is aggregated with any denied aggregate function
                                                        if (q.getSelectAggregate().get(attribute).contains(aggrFunc)){
                                                            allowedLocations.get(attribute).removeAll(ne.getExceptLocations());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //Need to first get the locations assigned to an attribute, so that we can intersect locations of the other attributes of the query
        List<String> attributeList = new ArrayList<>(q.getSelectAggregate().keySet());

        Set<String> locationIntersection = allowedLocations.get(attributeList.get(0));
        //System.out.println(allowedLocations);
        for (String attribute : q.getSelectAggregate().keySet()) {
            if (allowedLocations.containsKey(attribute)){
                locationIntersection = setIntersection(locationIntersection, allowedLocations.get(attribute));
            }
        }
        return locationIntersection;
    }

    public Set<String> setIntersection(Set<String> set1, Set<String> set2) {
        if (set1 == null || set2 == null) return null;
        Set<String> intersection;
        if (set1.size() <= set2.size()){
            intersection = set1.stream().filter(set2::contains).collect(Collectors.toSet());
        }else {
            intersection = set2.stream().filter(set1::contains).collect(Collectors.toSet());
        }
        return intersection;
    }

    public Set<String> setUnion(Set<String> set1, Set<String> set2){
        if (set1 == null || set2 == null) return null;
        return Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
    }

    public boolean checkIntersectionEmpty(Set<String> set1, Set<String> set2) {
        return set1.stream().anyMatch(set2::contains);
    }

    public Map<String, Set<String>> initAllowedLocationsMap(Query q){
        Map<String, Set<String>> map = new HashMap<>();
        for (String attribute : q.getSelectAggregate().keySet()){
            map.put(attribute, new HashSet<>());
        }
        return map;
    }
    public boolean isAllNulls(Iterable<?> set) {
        for (Object element : set)
            if (element != null) return false;
        return true;
    }

}
