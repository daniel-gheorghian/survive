package problems.design.library;

import problems.design.library.model.Mp3;

public class Mp3Builder
{
    private String title;
    private int    noOfDownloads;
    private String singer;
    private String album;

    public Mp3Builder title( String title )
    {
        this.title = title;

        return this;
    }

    public Mp3Builder noOfDownloads( int noOfDownloads )
    {
        this.noOfDownloads = noOfDownloads;

        return this;
    }

    public Mp3Builder singer( String singer )
    {
        this.singer = singer;

        return this;
    }

    public Mp3Builder album( String album )
    {
        this.album = album;

        return this;
    }

    public Mp3 build( )
    {
        return new Mp3( title, noOfDownloads, singer, album );
    }
}
