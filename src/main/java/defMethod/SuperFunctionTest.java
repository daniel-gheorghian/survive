package defMethod;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SuperFunctionTest
{
    public static void main( String[] args )
    {
        Function<Integer, Integer> doubleFunction = i -> 2 * i;
        SuperFunction<Integer, Integer> superDoubleFunction = i -> 2 * i;

        System.out.println( "Normal function" );
        System.out.println( compute( doubleFunction ) );

        System.out.println( "Super function" );
        System.out.println( compute( superDoubleFunction ) );
    }

    private static List<Integer> compute( Function<Integer, Integer> f )
    {
        return new Random( ).ints( 0, 5 )
                            .limit( 10 )
                            .boxed( )
                            .map( f )
                            .collect( Collectors.toList( ) );
    }
}
