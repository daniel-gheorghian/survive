package filterBehavior.step2;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class HoodedPilgrims
{
    //color as parameter
    public List<Pilgrim> filterGreenHoodedPilgrims( List<Pilgrim> pilgrims, String color )
    {
        List<Pilgrim> result = new ArrayList<>( );

        for( Pilgrim pilgrim : pilgrims )
        {
            if( pilgrim.isHooded( ) && color.equals( pilgrim.getHoodColor( ) ) )
            {
                result.add( pilgrim );
            }
        }

        return result;
    }
}
