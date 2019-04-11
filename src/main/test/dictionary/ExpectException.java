package dictionary;

import java.util.Optional;

public class ExpectException
{

    public static Optional<Throwable> assertException( Runnable command )
    {
        try
        {
            command.run( );
            return Optional.empty( );
        }
        catch( Throwable t )
        {
            return Optional.of( t );
        }
    }
}
