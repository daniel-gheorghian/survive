package filterBehavior.step4;

import filterBehavior.model.Pilgrim;
import filterBehavior.step3.ByCriteriaPilgrims;

import java.util.ArrayList;
import java.util.List;

public class WithLambda
{
    public static void main( String[] args )
    {
        List<Pilgrim> pilgrims = new ArrayList<>( );

        new ByCriteriaPilgrims( ).filterBy( pilgrims, p -> "Iasi".equals( p.getHomeCity( ) ) );
    }
}
