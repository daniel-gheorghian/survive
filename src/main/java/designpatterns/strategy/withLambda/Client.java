package designpatterns.strategy.withLambda;

import designpatterns.strategy.model.Field;

import java.util.stream.Stream;

import static designpatterns.strategy.withLambda.Validator.*;

public class Client
{
    //better with lambda
    public static void main1( String[] args )
    {
        Field field = new Field( "aaa" );

        isNumeric( ).and( isLowercase( ) ).validate( field );
    }

    //generic function composition
    public static void main( String[] args )
    {
        Field field = new Field( "aaa" );

        Validator combinedValidator = Stream.of( isVowels( ), isLowercase( ) )
                                            .reduce( v -> true, Validator::combine );

        boolean fieldValid = combinedValidator.validate( field );

        System.out.println( fieldValid );
    }
}
