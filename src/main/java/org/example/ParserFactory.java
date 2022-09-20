package org.example;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.policylanguage.PolicyLanguageLexer;
import org.policylanguage.PolicyLanguageParser;

import java.util.ArrayList;
import java.util.List;

public class ParserFactory {
    List<Policy> policies = new ArrayList<>();

    public void createParser(String policyExpression){
        PolicyLanguageLexer lexer = new PolicyLanguageLexer(CharStreams.fromString(policyExpression));
        PolicyLanguageParser parser = new PolicyLanguageParser(new CommonTokenStream(lexer));
        PolicyLanguageParser.Policy_expressionContext tree = parser.policy_expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        PolicyLanguageListener policyListener = new PolicyLanguageListener();
        walker.walk(policyListener, tree);
        policies.add(policyListener.policy);


        //Error checking in policy expression
        for (Policy p : policies){
            for (NegativePolicy ne : p.getNegativePolicies()){
                if (!p.getPositivePolicy().getShipAttributes().contains("*") && !ne.getExceptAttributes().contains("*")){
                    if (!p.getPositivePolicy().getShipAttributes().containsAll(ne.getExceptAttributes()))throw new RuntimeException("Except attributes should be defined in the Ship Clause");
                }
                if (!p.getPositivePolicy().getShipLocations().contains("*") && !ne.getExceptLocations().contains("*")){
                    if (!p.getPositivePolicy().getShipLocations().containsAll(ne.getExceptLocations()))throw new RuntimeException("Locations in negative policy should be defined in the positive policy");
                }
                if (!p.getPositivePolicy().getShipAggregates().containsAll(ne.getExceptAggregates()))throw new RuntimeException("Aggregate functions in the negative policy should be defined in the positive policy");
                if (!p.getPositivePolicy().getShipGroupAttributes().contains("*")){
                    if (!p.getPositivePolicy().getShipGroupAttributes().containsAll(ne.getExceptGroupAttributes()))throw new RuntimeException("Group By attributes in the negative policy should be defined in the group by attributes of the positive policy");
                }
            }
        }
    }

}
