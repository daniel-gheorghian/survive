package designpatterns.factory.withLambda;

import java.util.stream.IntStream;

import static designpatterns.factory.withLambda.ProductFactory.ProductCreators.BOND;
import static designpatterns.factory.withLambda.ProductFactory.ProductCreators.STOCK;

public class Client
{
    public static void main( String[] args )
    {
        //create and use
        ProductFactory.of( BOND ).create( "BOND1" ).buy( );

        //create, store and reuse
        ProductFactory factory = ProductFactory.of( STOCK );

        IntStream.range( 0, 10 ).forEach( i -> factory.create( "STOCK" + i ) );
    }
}