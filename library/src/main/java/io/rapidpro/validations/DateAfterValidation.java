package io.rapidpro.validations;

import java.text.ParseException;
import java.util.Date;

import io.rapidpro.managers.FlowRunnerManager;
import io.rapidpro.models.FlowDefinition;
import io.rapidpro.models.RulesetResponse;

/**
 * Created by johncordeiro on 15/10/15.
 */
public class DateAfterValidation extends DateValidation implements FlowRuleValidation {

    @Override
    public boolean validate(FlowDefinition flowDefinition, RulesetResponse response) {
        try {
            Integer timeDelta = getTimeDeltaValue(response);
            Date deltaTime = getDeltaTime(timeDelta);

            Date date = FlowRunnerManager.getDefaultDateFormat().parse(response.getResponse());
            return date.after(deltaTime);
        } catch(ParseException | NumberFormatException exception) {
            return false;
        }
    }

}
