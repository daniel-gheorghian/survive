package designpatterns.strategy;

public class Client
{
    public static void main( String[] args )
    {
        Field field = new Field( "aaa" );

        FieldValidator isNumeric   = new FieldValidator( new IsNumeric( ) );
        FieldValidator isLowercase = new FieldValidator( new IsAllLowerCase( ) );

        boolean fieldValid1 = isNumeric.validate( field );
        boolean fieldValid2 = isLowercase.validate( field );
    }
}
