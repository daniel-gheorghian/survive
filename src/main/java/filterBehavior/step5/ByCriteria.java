package filterBehavior.step5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ByCriteria
{
    public <T> List<T> filterBy( List<T> list, Predicate<T> predicate )
    {
        List<T> result = new ArrayList<>( );

        for( T e : list )
        {
            if( predicate.test( e ) )
            {
                result.add( e );
            }
        }

        return result;
    }
}
