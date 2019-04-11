package dictionary;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

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
                     .mapToObj( Character::toChars )
                     .map( String::new )
                     .collect( toList( ) );
    }

    private Optional<DictionaryWord> pickWord( String startingLetter )
    {
        Predicate<String> startsWithLetter = word -> word.startsWith( startingLetter );

        Optional<String> word = dictionary.keySet( )
                                          .stream( )
                                          .filter( startsWithLetter )
                                          .findAny( );

        return word.map( dictionary::get )
                   .orElse( emptyList( ) )
                   .stream( )
                   .findAny( );
    }
}
