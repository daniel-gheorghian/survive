package designpatterns.command.withoutLambda;

import designpatterns.command.withoutLambda.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Broker
{
    private List<Order> ordersList = new ArrayList<>( );

    public void takeOrder( Order o )
    {
        this.ordersList.add( o );
    }

    public void placeOrders( )
    {
        ordersList.forEach( Order::execute );
        ordersList.clear( );
    }
}
