package problems.design.library.solution;

import problems.design.library.model.Book;
import problems.design.library.model.Mp3;
import problems.design.library.model.Video;

public class MediaEntityBuilder
{
    public static AlbumBuilder mp3( )
    {
        return album -> singer -> title -> noOfDownloads -> new Mp3( title, noOfDownloads, singer, album );
    }

    public static VideoTitleBuilder video( )
    {
        return title -> duration -> fullHD -> noOfDownloads -> new Video( title, noOfDownloads, duration, fullHD );
    }

    public static BookTitleBuilder book( )
    {
        return title -> author -> publisher -> noOfDownloads -> new Book( title, noOfDownloads, author, publisher );
    }

    //MP# Builder sequence
    public interface AlbumBuilder
    {
        SingerBuilder album( String album );
    }

    public interface SingerBuilder
    {
        Mp3TitleBuilder singer( String singer );
    }

    public interface Mp3TitleBuilder
    {
        Mp3NoOfDownloadsBuilder title( String title );
    }

    public interface Mp3NoOfDownloadsBuilder
    {
        Mp3 noOfDownloads( int noOfDownloads );
    }

    //VIDEO Builder sequence
    public interface VideoTitleBuilder
    {
        DurationBuilder title( String title );
    }

    public interface DurationBuilder
    {
        FullHDBuilder duration( int duration );
    }

    public interface FullHDBuilder
    {
        VideoNoOfDownloadsBuilder fullHD( boolean fullHD );
    }

    public interface VideoNoOfDownloadsBuilder
    {
        Video noOfDownloads( int noOfDownloads );
    }

    //BOOK Builder sequence
    public interface BookTitleBuilder
    {
        AuthorBuilder title( String title );
    }

    public interface AuthorBuilder
    {
        PublisherBuilder author( String author );
    }

    public interface PublisherBuilder
    {
        BookNoOfDownloadsBuilder publisher( String publisher );
    }

    public interface BookNoOfDownloadsBuilder
    {
        Book noOfDownloads( int noOfDownloads );
    }
}
