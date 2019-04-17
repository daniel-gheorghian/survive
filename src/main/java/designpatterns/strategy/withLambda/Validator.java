package designpatterns.strategy.withLambda;

import java.util.function.Predicate;

public interface Validator extends Predicate<String>
{
    static Validator isNumeric( )
    {
        return value -> value.matches( "\\d+" );
    }

    static Validator isVowels( )
    {
        return value -> value.matches( "[aeiou]+" );
    }

    static Validator isLowercase( )
    {
        return value -> value.matches( "[a-z]+" );
    }

    default Validator combine( Validator other )
    {
        return value -> this.test( value ) && other.test( value );
    }
}
