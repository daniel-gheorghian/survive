package defMethod;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class SuperFunctionTest
{
    public static void main( String[] args )
    {
        Function<Integer, Integer>      doubleFunction      = i -> 2 * i;
        SuperFunction<Integer, Integer> superDoubleFunction = i -> 2 * i;

        List<Integer> data = readData( );

        System.out.println( "\nNormal function:" );
        System.out.println( compute( data, doubleFunction ) );

        System.out.println( "\nSuper function:" );
        System.out.println( compute( data, superDoubleFunction ) );
    }

    private static <T> List<T> compute( List<T> data, Function<T, T> f )
    {
        return data.stream( )
                   .map( f )
                   .collect( toList( ) );
    }

    private static List<Integer> readData( )
    {
        return new Random( ).ints( 0, 10 )
                            .limit( 10 )
                            .boxed( )
                            .collect( toList( ) );
    }
}
