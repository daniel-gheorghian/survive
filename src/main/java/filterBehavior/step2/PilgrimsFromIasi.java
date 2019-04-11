package filterBehavior.step2;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class PilgrimsFromIasi
{
    public List<Pilgrim> filterGreenHoodedPilgrims( List<Pilgrim> pilgrims, String homeCity )
    {
        List<Pilgrim> result = new ArrayList<>( );

        for( Pilgrim pilgrim : pilgrims )
        {
            if( pilgrim.isHooded( ) && homeCity.equals( pilgrim.getHomeCity() ) )
            {
                result.add( pilgrim );
            }
        }

        return result;
    }
}
