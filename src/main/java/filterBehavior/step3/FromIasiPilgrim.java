package filterBehavior.step3;

import filterBehavior.model.Pilgrim;

public class FromIasiPilgrim implements PilgrimPredicate
{
    @Override
    public boolean accept( Pilgrim pilgrim )
    {
        return "Iasi".equals( pilgrim.getHomeCity() );
    }
}
