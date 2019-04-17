package designpatterns.strategy.withoutLambda.validator;

public class IsNumeric implements Validator
{
    @Override
    public boolean apply( String value )
    {
        return value.matches( "\\d+" );
    }
}
