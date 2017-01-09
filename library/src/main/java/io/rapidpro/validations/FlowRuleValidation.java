package io.rapidpro.validations;

import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.RulesetResponse;

/**
 * Created by johncordeiro on 15/10/15.
 */
public interface FlowRuleValidation {

    boolean validate(FlowDefinition flowDefinition, RulesetResponse response);

}
