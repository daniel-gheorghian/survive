package filterBehavior.step3;

import filterBehavior.model.Pilgrim;

import java.util.ArrayList;
import java.util.List;

public class BehaviourParametrization
{
    public static void main( String[] args )
    {
        List<Pilgrim> pilgrims = new ArrayList<>( );

        //code is flexible
        //promotes reuse
        //use of classes to express criteria is verbose
        new ByCriteriaPilgrims( ).filterBy( pilgrims, new GreenHoodedPilgrim( ) );
        new ByCriteriaPilgrims( ).filterBy( pilgrims, new FromIasiPilgrim( ) );
    }
}
