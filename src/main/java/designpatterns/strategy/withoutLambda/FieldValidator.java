package designpatterns.strategy.withoutLambda;

import designpatterns.strategy.model.Field;
import designpatterns.strategy.withoutLambda.validator.Validator;

public class FieldValidator
{
    private Validator validator;

    public FieldValidator( Validator validator )
    {
        this.validator = validator;
    }

    public boolean validate( Field field )
    {
        return validator.apply( field.getValue( ) );
    }
}
