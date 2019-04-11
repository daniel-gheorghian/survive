package filterBehavior.step3;

import filterBehavior.model.Pilgrim;

public class GreenHoodedPilgrim implements PilgrimPredicate
{
    @Override
    public boolean accept( Pilgrim pilgrim )
    {
        return pilgrim.isHooded() && "green".equals( pilgrim.getHoodColor() );
    }
}
