package dictionary.complete;

import dictionary.model.DictionaryWord;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Dictionary
{
    private Map<String, List<DictionaryWord>> dictionary = new HashMap<>( );

    public void pushWords( String englishWord, String... romanianTranslations )
    {
        Function<String, DictionaryWord> createDictionaryWord = romanianWord -> new DictionaryWord( englishWord, romanianWord );

        List<DictionaryWord> words = Arrays.stream( romanianTranslations )
                                           .map( createDictionaryWord )
                                           .collect( toList( ) );

        dictionary.merge( englishWord, words, this::union );
    }

    private <T> List<T> union( List<T> list1, List<T> list2 )
    {
        return Stream.of( list1, list2 )
                     .flatMap( List::stream )
                     .collect( toList( ) );
    }

    public DictionaryWord firstTranslationFor( String word )
    {
        return allTranslationsFor( word ).stream( )
                                         .findFirst( )
                                         .orElseThrow( RuntimeException::new );
    }

    public List<DictionaryWord> allTranslationsFor( String word )
    {
        return dictionary.getOrDefault( word, emptyList( ) );
    }

    public List<DictionaryWord> allTranslationsForSorted( String word )
    {
        List<DictionaryWord> words = allTranslationsFor( word );

        words.sort( comparing( DictionaryWord::getRomanianWord ) );

        return words;
    }

    public List<DictionaryWord> pickWords( int count )
    {
        return generateRandomLetters( count ).stream( )
                                             .map( this::pickWord )
                                             .filter( Optional::isPresent )
                                             .map( Optional::get )
                                             .collect( toList( ) );
    }

    public List<String> generateRandomLetters( int count )
    {
        Random random = new Random( );

        return random.ints( 97, 123 )
                     .limit( count )
                     .mapToObj( this::toChar )
                     .collect( toList( ) );
    }

    private String toChar( int asciiCode )
    {
        return String.valueOf( (char) asciiCode );
    }

    private Optional<DictionaryWord> pickWord( String startingLetter )
    {
        Predicate<Map.Entry<String, List<DictionaryWord>>> startsWithLetter = e -> e.getKey( ).startsWith( startingLetter );

        return dictionary.entrySet( )
                         .stream( )
                         .filter( startsWithLetter )
                         .limit( 1 )
                         .map( Map.Entry::getValue )
                         .flatMap( List::stream )
                         .findAny( );
    }
}
