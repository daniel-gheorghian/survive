package designpatterns.factory.withoutLambda;

import designpatterns.factory.model.*;

public class ProductFactory
{
    public Product createProduct( ProductType productType, String code )
    {
        switch( productType )
        {
            case BOND:
                return new Bond( code );
            case LOAN:
                return new Loan( code );
            case STOCK:
                return new Stock( code );
            default:
                throw new IllegalArgumentException( "No such product type: " + productType );
        }
    }
}
