package io.rapidpro.validations;

import java.util.Map;

import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.FlowRuleTest;
import io.rapidpro.models.RulesetResponse;

/**
 * Created by johncordeiro on 15/10/15.
 */
public class FieldRegexValidation implements FlowRuleValidation {

    @Override
    public boolean validate(FlowDefinition flowDefinition, RulesetResponse response) {
        FlowRuleTest flowRuleTest = response.getRule().getTest();
        Map<String, String> object = (Map<String, String>) flowRuleTest.getTest();
        return response.getResponse().contains(object.get(flowDefinition.getBaseLanguage()));
    }

}
