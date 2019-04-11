package designpatterns.command;

public class Client
{
    public static void main( String[] args )
    {
        Stock amazon = new Stock( "AMZN", 1900 );
        Stock apple  = new Stock( "AAPL", 200 );

        SellStock sell1 = new SellStock( amazon, 1 );
        SellStock sell2 = new SellStock( amazon, 3 );
        BuyStock  buy1  = new BuyStock( apple, 5 );
        BuyStock  buy2  = new BuyStock( apple, 10 );

        Broker broker = new Broker( );
        broker.takeOrder( sell1 );
        broker.takeOrder( sell2 );
        broker.takeOrder( buy1 );
        broker.takeOrder( buy2 );

        broker.placeOrders( );
    }
}
