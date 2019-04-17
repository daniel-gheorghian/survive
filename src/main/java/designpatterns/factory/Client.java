package designpatterns.factory;

public class Client
{
    public static void main( String[] args )
    {
        new ProductFactory( ).createProduct( ProductType.BOND );
    }
}
