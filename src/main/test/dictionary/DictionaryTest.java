package dictionary;

import dictionary.model.DictionaryWord;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static dictionary.ExpectException.assertException;
import static dictionary.WordsGenerator.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DictionaryTest
{
    private Dictionary dictionary;
    private String     englishWord;
    private String[]   romanianWords;

    @Before
    public void setup( )
    {
        dictionary = new Dictionary( );
        englishWord = generateWord( );
        romanianWords = generateWords( 2 );
    }

    @Test
    public void should_return_home_for_first_translation( )
    {
        dictionary.pushWords( englishWord, romanianWords );

        String translation = dictionary.firstTranslationFor( englishWord ).getRomanianWord( );

        assertThat( translation, is( equalTo( romanianWords[0] ) ) );
    }

    @Test
    public void should_return_all_translations( )
    {
        dictionary.pushWords( englishWord, romanianWords );

        List<DictionaryWord> words = dictionary.allTranslationsFor( englishWord );

        assertThat( words, hasSize( 2 ) );
    }

    @Test
    public void should_return_all_translations_sorted( )
    {
        romanianWords = new String[] { generateWordStartingWith( "b" ), generateWordStartingWith( "a" ) };
        dictionary.pushWords( englishWord, romanianWords );

        List<DictionaryWord> words = dictionary.allTranslationsForSorted( englishWord );

        assertThat( words, hasSize( 2 ) );
        assertThat( words.get( 0 ).getRomanianWord( ), is( equalTo( romanianWords[1] ) ) );
        assertThat( words.get( 1 ).getRomanianWord( ), is( equalTo( romanianWords[0] ) ) );
    }

    @Test
    public void should_throw_exception_when_no_word_found( )
    {
        dictionary.pushWords( englishWord, romanianWords );

        Optional<Throwable> exception = assertException( ( ) -> dictionary.firstTranslationFor( generateWord( ) ) );

        assertThat( exception.isPresent( ), equalTo( true ) );
        assertThat( exception.get( ).getClass( ), typeCompatibleWith( RuntimeException.class ) );
    }

    @Test
    public void should_merge_translations_for_the_same_word( )
    {
        dictionary.pushWords( englishWord, generateWord( ) );
        dictionary.pushWords( englishWord, generateWord( ) );

        List<DictionaryWord> words = dictionary.allTranslationsFor( englishWord );

        assertThat( words, hasSize( 2 ) );
    }
}
