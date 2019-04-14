package dictionary;

import dictionary.model.DictionaryWord;

import java.util.*;

public class Dictionary
{
    private Map<String, List<DictionaryWord>> dictionary = new HashMap<>( );

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

    public DictionaryWord firstTranslationFor( String word )
    {
        List<DictionaryWord> wordList = allTranslationsFor( word );

        if( wordList.isEmpty( ) )
        {
            throw new RuntimeException( );
        }

        return wordList.get( 0 );
    }

    public List<DictionaryWord> allTranslationsFor( String word )
    {
        List<DictionaryWord> wordList = dictionary.get( word );

        if( wordList == null )
        {
            return Collections.emptyList( );
        }

        return wordList;
    }

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

    public List<DictionaryWord> pickWords( int count )
    {
        List<DictionaryWord> words = new ArrayList<>( );

        for( String letter : generateRandomLetters( count ) )
        {
            DictionaryWord word = pickWord( letter );

            if( word != null )
            {
                words.add( word );
            }
        }

        return words;
    }

    public List<String> generateRandomLetters( int count )
    {
        Random random = new Random( );
        List<String> letters = new ArrayList<>( );

        for( int i = 0; i < count; i++ )
        {
            int letter = random.nextInt( (122 - 97) + 1 ) + 97;

            letters.add( toChar( letter ) );
        }

        return letters;
    }

    private String toChar( int asciiCode )
    {
        return String.valueOf( (char) asciiCode );
    }

    private DictionaryWord pickWord( String startingLetter )
    {
        for( String word : dictionary.keySet( ) )
        {
            if( word.startsWith( startingLetter ) )
            {
                return dictionary.get( word ).get( 0 );
            }
        }

        return null;
    }
}
