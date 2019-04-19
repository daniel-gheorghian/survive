package designpatterns.strategy.withLambda;

import designpatterns.strategy.model.Field;

import java.util.stream.Stream;

import static designpatterns.strategy.withLambda.Validator.*;

public class Client
{
    public static void main( String[] args )
    {
        Field field = new Field( "aaa" );

        //better with lambda
        isNumeric( ).and( isLowercase( ) ).validate( field );

        //generic function composition
        Validator combinedValidator = Stream.of( isVowels( ), isLowercase( ) )
                                            .reduce( v -> true, Validator::and );

        boolean fieldValid = combinedValidator.validate( field );

        System.out.println( fieldValid );
    }
}
