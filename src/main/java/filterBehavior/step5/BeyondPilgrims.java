package filterBehavior.step5;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class BeyondPilgrims
{
    public static void main( String[] args )
    {
        List<Pilgrim> pilgrims = new ArrayList<>( );
        List<String>  strings  = new ArrayList<>( );
        List<Integer> numbers  = new ArrayList<>( );

        new ByCriteria( ).filterBy( pilgrims, p -> p.isHooded( ) );

        new ByCriteria( ).filterBy( strings, s -> s.endsWith( "JDK" ) );

        new ByCriteria( ).filterBy( numbers, n -> n % 2 == 1 );
    }
}
