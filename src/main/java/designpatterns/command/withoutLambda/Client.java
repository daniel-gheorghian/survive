package designpatterns.command.withoutLambda;

import designpatterns.command.withoutLambda.order.BuyStockOrder;
import designpatterns.command.withoutLambda.order.SellStockOrder;

public class Client
{
    public static void main( String[] args )
    {
        Stock amazon = new Stock( "AMZN", 1900 );
        Stock apple  = new Stock( "AAPL", 200 );

        SellStockOrder sell1 = new SellStockOrder( amazon, 1 );
        SellStockOrder sell2 = new SellStockOrder( amazon, 3 );
        BuyStockOrder  buy1  = new BuyStockOrder( apple, 5 );
        BuyStockOrder  buy2  = new BuyStockOrder( apple, 10 );

        Broker broker = new Broker( );
        broker.takeOrder( sell1 );
        broker.takeOrder( sell2 );
        broker.takeOrder( buy1 );
        broker.takeOrder( buy2 );

        broker.placeOrders( );
    }
}
