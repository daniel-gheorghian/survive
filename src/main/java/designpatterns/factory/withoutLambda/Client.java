package designpatterns.factory.withoutLambda;

import designpatterns.factory.model.ProductType;

public class Client
{
    public static void main( String[] args )
    {
        new ProductFactory( ).createProduct( ProductType.BOND, "BOND1" );
    }
}
