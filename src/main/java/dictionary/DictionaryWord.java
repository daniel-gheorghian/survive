package dictionary;

import java.util.Objects;

public class DictionaryWord
{
    private String englishWord;
    private String romanianWord;

    public DictionaryWord( String englishWord, String romanianWord )
    {
        this.englishWord = englishWord;
        this.romanianWord = romanianWord;
    }

    public String getEnglishWord( )
    {
        return englishWord;
    }

    public void setEnglishWord( String englishWord )
    {
        this.englishWord = englishWord;
    }

    public String getRomanianWord( )
    {
        return romanianWord;
    }

    public void setRomanianWord( String romanianWord )
    {
        this.romanianWord = romanianWord;
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o )
        {
            return true;
        }
        if( o == null || getClass( ) != o.getClass( ) )
        {
            return false;
        }
        DictionaryWord that = (DictionaryWord)o;
        return Objects.equals( englishWord, that.englishWord ) &&
               Objects.equals( romanianWord, that.romanianWord );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( englishWord, romanianWord );
    }

    @Override
    public String toString( )
    {
        return "DictionaryWord{" +
               "englishWord='" + englishWord + '\'' +
               ", romanianWord='" + romanianWord + '\'' +
               '}';
    }
}
