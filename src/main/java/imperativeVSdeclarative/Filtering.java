package imperativeVSdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Filtering
{
    public static void main( String[] args )
    {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        //1) imperative
        List<Integer> result1 = new ArrayList<>( );
        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] % 2 == 0 )
            {
                result1.add( arr[i] );
            }
        }

        System.out.println( result1 );

        //2) using 'for-each' - still imperative, but shorter (and a little more declarative, no explicit access by index)
        List<Integer> result2 = new ArrayList<>( );
        for( int value : arr )
        {
            if( value % 2 == 0 )
            {
                result2.add( value );
            }
        }

        System.out.println( result2 );

        //3) declarative
        List<Integer> result3 =
                Arrays.stream( arr )
                      .filter( n -> n % 2 == 0 )
                      .boxed( )
                      .collect( toList( ) );

        System.out.println( result3 );
    }
}
