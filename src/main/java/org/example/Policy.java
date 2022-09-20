package org.example;

import java.util.ArrayList;
import java.util.List;

public class Policy {

    private PositivePolicy positivePolicy;
    private final List<NegativePolicy> negativePolicies = new ArrayList<>();

    //Get Methods
    public List<NegativePolicy> getNegativePolicies() {
        return negativePolicies;
    }
    public PositivePolicy getPositivePolicy( ) { return positivePolicy; }

    //Set Methods
    public void setPositivePolicies(PositivePolicy positivePolicy){
        this.positivePolicy = positivePolicy;
    }
    public void setNegativePolicies(NegativePolicy negativePolicy) {
        negativePolicies.add(negativePolicy);
    }
}
