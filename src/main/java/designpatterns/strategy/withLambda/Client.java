package designpatterns.strategy.withLambda;

import java.util.stream.Stream;

public class Client
{
    //better with lambda
    public static void main1( String[] args )
    {
        Field field = new Field( "aaa" );

        FieldValidator isNumeric   = new FieldValidator( Validator.isNumeric( ) );
        FieldValidator isLowercase = new FieldValidator( Validator.isLowercase( ) );

        boolean fieldValid1 = isNumeric.validate( field );
        boolean fieldValid2 = isLowercase.validate( field );
    }

    //function composition
    public static void main( String[] args )
    {
        Field field = new Field( "aaa" );

        Validator combinedValidator = Stream.of( Validator.isVowels( ), Validator.isLowercase( ) )
                                            .reduce( v -> true, Validator::combine );

        boolean fieldValid = new FieldValidator( combinedValidator ).validate( field );

        System.out.println( fieldValid );
    }
}
