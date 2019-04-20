package fp_prez.imperativeVSdeclarative;

import java.util.Arrays;
import java.util.List;

public class DeclarativeVsImperative
{

    public static void main( String[] args )
    {
        List<String> names = Arrays.asList( "Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques" );

        findNemo_Imperative( names );
        findNemo_Declarative( names );
    }

    static void findNemo_Imperative( List<String> names )
    {
        boolean found = false;
        for( String name : names )
        {
            if( name.equals( "Nemo" ) )
            {
                found = true;
                break;
            }
        }

        if( found )
        {
            System.out.println( "Found Nemo" );
        }
        else
        {
            System.out.println( "Sorry, Nemo not found" );
        }
    }

    static void findNemo_Declarative( List<String> names )
    {
        if( names.contains( "Nemo" ) )
        {
            System.out.println( "Found Nemo" );
        }
        else
        {
            System.out.println( "Sorry, Nemo not found" );
        }
    }
}
