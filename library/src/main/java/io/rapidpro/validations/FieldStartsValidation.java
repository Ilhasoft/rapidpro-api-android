package io.rapidpro.validations;

import java.util.Map;

import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.RulesetResponse;

/**
 * Created by johncordeiro on 15/10/15.
 */
public class FieldStartsValidation implements FlowRuleValidation {

    @Override
    public boolean validate(FlowDefinition flowDefinition, RulesetResponse response) {
        final Map<String, String> object = response.getRule().getTest().getTest();
        return response.getResponse().startsWith(object.get(flowDefinition.getBaseLanguage()));
    }

}
