package dictionary;

import dictionary.model.DictionaryWord;

import java.util.*;

public class Dictionary
{
    private Map<String, List<DictionaryWord>> dictionary = new HashMap<>( );

    /*
     * Add words to the english-romanian dictionary
     * Each romanian translation will for a pair with the english word and be saved in the dictionary
     */
    public void pushWords( String englishWord, String... romanianTranslations )
    {
        for( String translation : romanianTranslations )
        {
            List<DictionaryWord> wordList = dictionary.get( englishWord );

            if( wordList == null )
            {
                wordList = new ArrayList<>( );
                dictionary.put( englishWord, wordList );
            }

            wordList.add( new DictionaryWord( englishWord, translation ) );
        }
    }

    /*
     * Find the first romanian translation for an english word
     */
    public DictionaryWord firstTranslationFor( String word )
    {
        List<DictionaryWord> wordList = allTranslationsFor( word );

        if( wordList.isEmpty( ) )
        {
            throw new RuntimeException( );
        }

        return wordList.get( 0 );
    }

    /*
     * Find all romanian translations for an english word
     */
    public List<DictionaryWord> allTranslationsFor( String word )
    {
        List<DictionaryWord> wordList = dictionary.get( word );

        if( wordList == null )
        {
            return Collections.emptyList( );
        }

        return wordList;
    }

    /*
     * Find all romanian translations for an english word, sorted by the romanian words
     */
    public List<DictionaryWord> allTranslationsForSorted( String word )
    {
        List<DictionaryWord> wordList = allTranslationsFor( word );

        Collections.sort( wordList, new Comparator<DictionaryWord>( )
        {
            @Override
            public int compare( DictionaryWord o1, DictionaryWord o2 )
            {
                return o1.getRomanianWord( ).compareTo( o2.getRomanianWord( ) );
            }
        } );

        return wordList;
    }
}
