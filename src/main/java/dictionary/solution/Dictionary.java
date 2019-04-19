package dictionary.solution;

import dictionary.model.DictionaryWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Dictionary
{
    private Map<String, List<DictionaryWord>> dictionary = new HashMap<>( );

    /*
     * Add words to the english-romanian dictionary
     * Each romanian translation will for a pair with the english word and be saved in the dictionary
     */
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

    /*
     * Find the first romanian translation for an english word
     */
    public DictionaryWord firstTranslationFor( String word )
    {
        return allTranslationsFor( word ).stream( )
                                         .findFirst( )
                                         .orElseThrow( RuntimeException::new );
    }

    /*
     * Find all romanian translations for an english word
     */
    public List<DictionaryWord> allTranslationsFor( String word )
    {
        return dictionary.getOrDefault( word, emptyList( ) );
    }

    /*
     * Find all romanian translations for an english word, sorted by the romanian words
     */
    public List<DictionaryWord> allTranslationsForSorted( String word )
    {
        List<DictionaryWord> words = allTranslationsFor( word );

        words.sort( comparing( DictionaryWord::getRomanianWord ) );

        return words;
    }
}
