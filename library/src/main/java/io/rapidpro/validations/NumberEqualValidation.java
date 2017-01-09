package io.rapidpro.validations;

import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.RulesetResponse;

/**
 * Created by johncordeiro on 15/10/15.
 */
public class NumberEqualValidation implements FlowRuleValidation {

    @Override
    public boolean validate(FlowDefinition flowDefinition, RulesetResponse response) {
        try {
            Integer value = Integer.valueOf(response.getResponse());
            return value.equals(Integer.valueOf(response.getRule().getTest().getTest().values().iterator().next()));
        } catch(NumberFormatException exception) {
            return false;
        }
    }

}
