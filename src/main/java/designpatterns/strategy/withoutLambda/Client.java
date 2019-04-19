package designpatterns.strategy.withoutLambda;

import designpatterns.strategy.model.Field;
import designpatterns.strategy.withoutLambda.validator.IsAllLowerCase;
import designpatterns.strategy.withoutLambda.validator.IsNumeric;

public class Client
{
    public static void main( String[] args )
    {
        Field field = new Field( "aaa" );

        FieldValidator isNumeric   = new FieldValidator( new IsNumeric( ) );
        FieldValidator isLowercase = new FieldValidator( new IsAllLowerCase( ) );

        boolean fieldValid1 = isNumeric.validate( field );
        boolean fieldValid2 = isLowercase.validate( field );

        if( fieldValid1 && fieldValid2 )
        {
            System.out.println( "Valid input" );
        }
    }
}
