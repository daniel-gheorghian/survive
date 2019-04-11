package designpatterns.factory;

public class ProductFactory
{
    public Product createProduct( ProductType productType )
    {
        switch( productType )
        {
            case BOND:
                return new Bond( );
            case LOAN:
                return new Loan( );
            case STOCK:
                return new Stock( );
            default:
                throw new IllegalArgumentException( "No such product type: " + productType );
        }
    }
}
