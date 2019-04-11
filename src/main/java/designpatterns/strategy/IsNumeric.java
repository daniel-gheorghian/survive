package designpatterns.strategy;

import java.math.BigDecimal;

public class IsNumeric implements Validator
{
    @Override
    public boolean apply( String value )
    {
        return value.matches( "\\d+" );
    }
}
