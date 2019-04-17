package designpatterns.strategy;

public class IsNumeric implements Validator
{
    @Override
    public boolean apply( String value )
    {
        return value.matches( "\\d+" );
    }
}
