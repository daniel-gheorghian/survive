package designpatterns.strategy.withLambda;

import designpatterns.strategy.model.Field;

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

    default Validator and( Validator other )
    {
        return this.and( other );
    }

    default boolean validate( Field field )
    {
        return new FieldValidator( this ).validate( field );
    }
}
