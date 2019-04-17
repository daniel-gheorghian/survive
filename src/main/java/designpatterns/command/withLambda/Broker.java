package designpatterns.command.withLambda;

import java.util.ArrayList;
import java.util.List;

public class Broker
{
    private List<Runnable> ordersList = new ArrayList<>( );

    public void takeOrder( Runnable o )
    {
        this.ordersList.add( o );
    }

    public void placeOrders( )
    {
        ordersList.forEach( Runnable::run );
        ordersList.clear( );
    }
}
