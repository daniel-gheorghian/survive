package imperativeVSdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        //imperative
        List<Integer> result = new ArrayList<>( );
        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] % 2 == 0 )
            {
                result.add( arr[i] );
            }
        }

        System.out.println( result );

        //declarative
        int[] result1 = Arrays.stream( arr ).filter( n -> n % 2 == 0 ).toArray( );

        System.out.println( result1 );
    }
}
