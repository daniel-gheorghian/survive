package filterBehavior.step1;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class GreenHoodedPilgrims
{
    public List<Pilgrim> filterGreenHoodedPilgrims( List<Pilgrim> pilgrims )
    {
        List<Pilgrim> result = new ArrayList<>( );

        for( Pilgrim pilgrim : pilgrims )
        {
            if( pilgrim.isHooded( ) && "green".equals( pilgrim.getHoodColor() ) )
            {
                result.add( pilgrim );
            }
        }

        return result;
    }
}
