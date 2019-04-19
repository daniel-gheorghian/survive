package dictionary;

import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WordsGenerator
{
    private static final int MAX_WORD_LENGTH        = 10;
    private static final int LOWERCASE_A_ASCII_CODE = 97;
    private static final int LOWERCASE_Z_ASCII_CODE = 122;

    public static String[] generateWords( int count )
    {
        return IntStream.range( 0, count )
                        .mapToObj( i -> generateWord( ) )
                        .collect( toList( ) )
                        .toArray( new String[count] );
    }

    public static String generateWord( )
    {
        Random random = new Random( );

        return random.ints( LOWERCASE_A_ASCII_CODE, LOWERCASE_Z_ASCII_CODE + 1 )
                     .limit( random.nextInt( MAX_WORD_LENGTH ) )
                     .mapToObj( WordsGenerator::toChar )
                     .collect( joining( ) );
    }

    public static String generateWordStartingWith( String c )
    {
        return c + generateWord( );
    }

    private static String toChar( int asciiCode )
    {
        return String.valueOf( (char)asciiCode );
    }
}
