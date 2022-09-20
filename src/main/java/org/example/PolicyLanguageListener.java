package org.example;

import org.policylanguage.PolicyLanguageBaseListener;
import org.policylanguage.PolicyLanguageParser;

public class PolicyLanguageListener extends PolicyLanguageBaseListener {
    Policy policy = new Policy();

    public void enterPositive_policy(PolicyLanguageParser.Positive_policyContext ctx) {

        if (ctx != null) {
            PositivePolicy pe = new PositivePolicy();

            if (ctx.ship() != null) {
                if (ctx.ship().ASTERISK() != null) {
                    pe.setShipAttributes(ctx.ship().ASTERISK().getText());
                } else {
                    for (int i = 0; i < ctx.ship().ship_attribute().size(); i++){
                        pe.setShipAttributes(ctx.ship().ship_attribute().get(i).getText().toLowerCase());
                    }
                }
            }

            if (ctx.as_aggregates() != null){
                for (int i = 0; i < ctx.as_aggregates().aggr_func().size(); i++){
                    pe.setShipAggregates(ctx.as_aggregates().aggr_func().get(i).getText().toLowerCase());
                }
            }

            if (ctx.from() != null){
                pe.setFromTable(ctx.from().table().getText().toLowerCase());
            }

            if (ctx.to() != null) {
                if (ctx.to().ASTERISK() != null) {
                    pe.setShipLocations(ctx.to().ASTERISK().getText());
                } else {
                    for (int i = 0; i < ctx.to().location().size(); i++){
                        pe.setShipLocations(ctx.to().location().get(i).getText().toLowerCase());
                    }
                }
            }

            if (ctx.where() != null) {
                pe.setShipWhereClause(ctx.where().getText());
            }

            if (ctx.group_by() != null){
                if (ctx.group_by().ASTERISK() != null) {
                    pe.setShipGroupAttributes(ctx.group_by().ASTERISK().getText());
                }else {
                    for (int i = 0; i < ctx.group_by().ship_attribute().size(); i++){
                        pe.setShipGroupAttributes(ctx.group_by().ship_attribute().get(i).getText().toLowerCase());
                    }
                }
            }

        policy.setPositivePolicies(pe);
        }
    }

    public void enterNegative_policy(PolicyLanguageParser.Negative_policyContext ctx) {
        NegativePolicy ne = new NegativePolicy();

        if (ctx.except() != null) {
            if (ctx.except().ASTERISK() != null) {
                ne.setExceptAttributes(ctx.except().ASTERISK().getText());
            }else {
                for (int i = 0; i < ctx.except().except_attribute().size(); i++){
                    ne.setExceptAttributes(ctx.except().except_attribute().get(i).getText().toLowerCase());
                }
            }
        }

        if (ctx.except_as_aggregates() != null){
            for (int i = 0; i < ctx.except_as_aggregates().aggr_func().size(); i++){
                ne.setExceptAggregates(ctx.except_as_aggregates().aggr_func().get(i).getText().toLowerCase());
            }
        }

        if (ctx.except_to() != null){
            if (ctx.except_to().ASTERISK() != null){
                ne.setExceptLocations(ctx.except_to().ASTERISK().getText());
            } else {
                for (int i = 0; i < ctx.except_to().location().size(); i++){
                    ne.setExceptLocations(ctx.except_to().location().get(i).getText().toLowerCase());
                }
            }
        }

        if (ctx.except_where() != null) {
            ne.setExceptWhereClause(ctx.except_where().getText());
        }

        if (ctx.except_group_by() != null) {
            for (int i = 0; i < ctx.except_group_by().except_attribute().size(); i++) {
                ne.setExceptGroupAttributes(ctx.except_group_by().except_attribute().get(i).getText().toLowerCase());
            }
        }

        policy.setNegativePolicies(ne);
    }
}
