package dictionary;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static dictionary.ExpectException.*;
import static org.mockito.Mockito.*;

public class DictionaryTest
{
    private Dictionary dictionary;

    @Before
    public void setup( )
    {
        dictionary = new Dictionary( );
    }

    @Test
    public void should_return_home_for_first_translation( )
    {
        dictionary.pushWords( "home", "casa", "acasa" );

        String translation = dictionary.firstTranslationFor( "home" ).getRomanianWord( );

        assertThat( translation, is( equalTo( "casa" ) ) );
    }

    @Test
    public void should_return_all_translations( )
    {
        dictionary.pushWords( "home", "casa", "acasa" );

        List<DictionaryWord> words = dictionary.allTranslationsFor( "home" );

        assertThat( words, hasSize( 2 ) );
    }

    @Test
    public void should_return_all_translations_sorted( )
    {
        dictionary.pushWords( "home", "casa", "acasa" );

        List<DictionaryWord> words = dictionary.allTranslationsForSorted( "home" );

        assertThat( words, hasSize( 2 ) );
        assertThat( words.get( 0 ).getRomanianWord( ), is( equalTo( "acasa" ) ) );
        assertThat( words.get( 1 ).getRomanianWord( ), is( equalTo( "casa" ) ) );
    }

    @Test
    public void should_throw_exception_when_no_single_word_found( )
    {
        dictionary.pushWords( "home", "casa", "acasa" );

        Optional<Throwable> exception = assertException( ( ) -> dictionary.firstTranslationFor( "house" ) );

        assertThat( exception.isPresent( ), equalTo( true ) );
        assertThat( exception.get( ).getClass( ), typeCompatibleWith( RuntimeException.class ) );
    }

    @Test
    public void should_merge_translations_for_the_same_word( )
    {
        dictionary.pushWords( "home", "casa" );
        dictionary.pushWords( "home", "acasa" );

        List<DictionaryWord> words = dictionary.allTranslationsFor( "home" );

        assertThat( words, hasSize( 2 ) );
    }

    @Test
    public void should_return_random_letters( )
    {
        List<String> letters = dictionary.generateRandomLetters( 10 );

        assertThat( letters, hasSize( 10 ) );
        assertThat( letters, everyItem(
                isOneOf( "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                         "x", "y", "z" ) ) );
    }

    @Test
    public void should_return_random_words( )
    {
        dictionary = spy( dictionary );
        when( dictionary.generateRandomLetters( anyInt( ) ) ).thenReturn( Arrays.asList( "h" ) );

        dictionary.pushWords( "home", "casa" );

        List<DictionaryWord> words = dictionary.pickWords( 1 );

        assertThat( words, hasSize( 1 ) );
        assertThat( words, containsInAnyOrder( new DictionaryWord( "home", "casa" ) ) );
    }
}
