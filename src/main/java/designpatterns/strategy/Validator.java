package designpatterns.strategy;

import java.math.BigDecimal;

public interface Validator
{
    boolean apply( String value );
}
