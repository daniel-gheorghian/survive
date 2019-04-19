package designpatterns.command.withLambda;

import designpatterns.command.model.Stock;

public class Client
{
    public static void main( String[] args )
    {
        Stock amazon = new Stock( "AMZN", 1900 );
        Stock apple  = new Stock( "AAPL", 200 );

        Broker broker = new Broker( );
        broker.takeOrders( ( ) -> amazon.sell( 1 ),
                           ( ) -> amazon.sell( 3 ),
                           ( ) -> apple.buy( 5 ),
                           ( ) -> apple.buy( 10 ) );

        broker.placeOrders( );
    }
}
