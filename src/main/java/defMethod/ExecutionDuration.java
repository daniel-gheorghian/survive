package defMethod;

import java.util.function.Function;

public interface ExecutionDuration<T, R> extends Function<T, R>
{
    static <U, V> ExecutionDuration<U, V> measure( Function<U, V> f )
    {
        return input -> f.apply( input );
    }

    R perform( T t );

    @Override
    default R apply( T t )
    {
        long time = System.currentTimeMillis( );

        R result = perform( t );

        long duration = System.currentTimeMillis( ) - time;

        System.out.println( "Duration " + duration + " millis" );

        return result;
    }
}
