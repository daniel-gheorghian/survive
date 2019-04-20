package fp_prez.fp_principles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HigherOrderFunctions
{

    public static void main( String[] args )
    {
        List<String> list = Arrays.asList( "One", "Abc", "BCD" );

        Collections.sort(
                list,
                ( a, b ) -> a.compareTo( b ) );

        Comparator<String> comparator = ( a, b ) -> a.compareTo( b );

        Comparator<String> comparatorReversed = comparator.reversed( );

        Collections.sort( list, comparatorReversed );
    }
}