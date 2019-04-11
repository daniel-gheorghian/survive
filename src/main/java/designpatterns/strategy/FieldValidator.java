package designpatterns.strategy;

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
