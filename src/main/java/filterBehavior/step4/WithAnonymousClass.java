package filterBehavior.step4;

import filterBehavior.model.Pilgrim;
import filterBehavior.step3.ByCriteriaPilgrims;
import filterBehavior.step3.PilgrimPredicate;

import java.util.ArrayList;
import java.util.List;

public class WithAnonymousClass
{
    public static void main( String[] args )
    {
        List<Pilgrim> pilgrims = new ArrayList<>(  );

        new ByCriteriaPilgrims().filterBy( pilgrims, new PilgrimPredicate( )
        {
            @Override
            public boolean accept( Pilgrim pilgrim )
            {
                return pilgrim.isHooded() && "green".equals( pilgrim.getHoodColor() );
            }
        } );
    }
}
