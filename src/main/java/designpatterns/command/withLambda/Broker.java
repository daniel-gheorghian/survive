package designpatterns.command.withLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Broker
{
    private List<Runnable> commandList = new ArrayList<>( );

    public void takeOrders( Runnable... commands )
    {
        this.commandList.addAll( Arrays.asList( commands ) );
    }

    public void placeOrders( )
    {
        commandList.forEach( Runnable::run );
        commandList.clear( );
    }
}
