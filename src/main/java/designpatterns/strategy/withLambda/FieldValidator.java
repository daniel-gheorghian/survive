package designpatterns.strategy.withLambda;

public class FieldValidator
{
    private Validator validator;

    public FieldValidator( Validator validator )
    {
        this.validator = validator;
    }

    public boolean validate( Field field )
    {
        return validator.test( field.getValue( ) );
    }
}
