package filterBehavior.step3;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class ByCriteriaPilgrims
{
    public List<Pilgrim> filterBy( List<Pilgrim> pilgrims, PilgrimPredicate predicate )
    {
        List<Pilgrim> result = new ArrayList<>( );

        for( Pilgrim pilgrim : pilgrims )
        {
            if( predicate.accept( pilgrim ) )
            {
                result.add( pilgrim );
            }
        }

        return result;
    }
}
