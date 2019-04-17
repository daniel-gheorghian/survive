package designpatterns.command.withLambda;

public class Client
{
    public static void main( String[] args )
    {
        Stock amazon = new Stock( "AMZN", 1900 );
        Stock apple  = new Stock( "AAPL", 200 );

        Runnable sell1 = ( ) -> amazon.sell( 1 );
        Runnable sell2 = ( ) -> amazon.sell( 3 );
        Runnable buy1  = ( ) -> apple.buy( 5 );
        Runnable buy2  = ( ) -> apple.buy( 10 );

        Broker broker = new Broker( );
        broker.takeOrder( sell1 );
        broker.takeOrder( sell2 );
        broker.takeOrder( buy1 );
        broker.takeOrder( buy2 );

        broker.placeOrders( );
    }
}
