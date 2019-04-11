package defMethod;

import java.util.function.Function;

public interface SuperFunction<T, R> extends Function<T, R>
{
    @Override
    default R apply( T t )
    {
        System.out.println( "Processing " + t );

        return perform( t );
    }

    R perform( T t );
}
