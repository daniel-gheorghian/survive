package fp_prez.extra;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import static fp_prez.extra.Wrappers.withLog;
import static fp_prez.extra.Wrappers.withTimer;
import static java.util.stream.Collectors.toList;

/**
 * Inspired by:
 * https://dzone.com/articles/functional-programming-java-8
 */
public class WrapperLambdas
{
    public static void main( String[] args )
    {

        List<Integer> data = Arrays.asList( 1, 2, 3 );

        //--- Initial function ---//
        Function<Integer, Integer> pow = x -> 2 * x;

        //--- Some wrapper functions ---//
        Function<Integer, Integer> powWithLog   = withLog( "pow", pow );
        Function<Integer, Integer> powWithTimer = withTimer( "pow", pow );

        //may also apply them one over other:
        Function<Integer, Integer> powTimerOverLog = withTimer( "pow", withLog( "pow", pow ) );
        Function<Integer, Integer> powLogOverTimer = withLog( "pow", withTimer( "pow", pow ) );

        //or apply them sequentially:
        Function<Integer, Integer> powTimerThenLog = powWithTimer.andThen( powWithLog );
        Function<Integer, Integer> powLogThenTimer = powWithLog.andThen( powWithTimer );

        //--- Applying them ---//
        compute( data, pow, "pow" );
        compute( data, powWithTimer, "powWithTimer" );

        compute( data, powTimerOverLog, "powTimerOverLog" );
        compute( data, powLogOverTimer, "powLogOverTimer" );

        compute( data, powLogThenTimer, "powLogThenTimer" );
        compute( data, powTimerThenLog, "powTimerThenLog" );

        //apply on single value
        System.out.println( "\nApplying on single value:" );
        powLogOverTimer.apply( 99 );

        //--- May combine wrapper functionality with any other lambda of a supported types (like Function, Consumer) ---//
        Consumer<String> consumer      = WrapperLambdas::slowWorkOnData;
        Consumer<String> timedConsumer = withTimer( "consumer", consumer );

        System.out.println( "\nCalling consumer:" );
        consumer.accept( "some data" );

        System.out.println( "\nCalling timedConsumer:" );
        timedConsumer.accept( "some data" );

        System.out.println( "\nCalling factorial function:" );
        Function<Integer, BigInteger> fact =
                withTimer( "factorial",
                           withLog( "factorial",
                                    WrapperLambdas::factorial ) );
        BigInteger f1000 = fact.apply( 2000 );
        System.out.println( "2000! has: " + f1000.toString( ).length( ) + " digits" );
    }

    private static <T> void compute( List<T> data, Function<T, T> func, String funcDesc )
    {
        System.out.println( "\n------- Applying '" + funcDesc + "' -------" );
        System.out.println( "Computed data: " + data.stream( ).map( func ).collect( toList( ) ) );
    }

    private static void slowWorkOnData( String data )
    {
        System.out.print( "    >> (slowly) working on '" + data + "' " );
        IntStream.range( 1, 10 ).forEach( i -> {
            try
            {
                Thread.sleep( 100 );
            }
            catch( InterruptedException e )
            {
            }
            System.out.print( "." );
        } );
        System.out.println( " done! <<" );
    }

    private static BigInteger factorial( int n )
    {
        return factorial( BigInteger.valueOf( n ) );
    }

    private static BigInteger factorial( BigInteger n )
    {
        return n.compareTo( BigInteger.ONE ) <= 0 ? n : factorial( n.subtract( BigInteger.ONE ) ).multiply( n );
    }
}

class Wrappers
{

    static <T, R> Function<T, R> withLog( String fName, Function<T, R> f )
    {
        return t -> {
            System.out.println( "  calling " + fName + "(" + t + ")..." );
            R result = f.apply( t );
            System.out.println( "  ..." + fName + "(" + t + ") call ended, result: " + result );
            return result;
        };
    }

    static <T, R> Function<T, R> withTimer( String fName, Function<T, R> f )
    {
        return t -> {
            System.out.println( "  calling " + fName + "..." );
            long start = System.nanoTime( );
            try
            {
                return f.apply( t );
            }
            finally
            {
                long time = System.nanoTime( ) - start;
                System.out.println( "  ..." + fName + " call ended, time: " + time + " ns" );
            }
        };
    }

    //but need to declare one method for each Function type (no way to make this generic!)
    static <T> Consumer<T> withTimer( String fName, Consumer<T> f )
    {
        return t -> {
            System.out.println( "  calling " + fName + "..." );
            long start = System.nanoTime( );
            try
            {
                f.accept( t );
            }
            finally
            {
                long time = System.nanoTime( ) - start;
                System.out.println( "  ..." + fName + " call ended, time: " + time + " ns" );
            }
        };
    }
}
