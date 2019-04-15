package problems.design.library.model;

import java.util.Objects;

public class Mp3 extends MediaEntity
{
    private String singer;
    private String album;

    public Mp3( String title, int noOfDownloads, String singer, String album )
    {
        super( MediaType.MP3, title, noOfDownloads );
        this.singer = singer;
        this.album = album;
    }

    public String getSinger( )
    {
        return singer;
    }

    public String getAlbum( )
    {
        return album;
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
        if( !super.equals( o ) )
        {
            return false;
        }
        Mp3 mp3 = (Mp3)o;
        return Objects.equals( singer, mp3.singer ) &&
               Objects.equals( album, mp3.album );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( super.hashCode( ), singer, album );
    }
}
