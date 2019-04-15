package problems.design.library;

import problems.design.library.model.Book;

public class BookBuilder
{
    private String author;
    private String publisher;
    private String title;
    private int    noOfDownloads;

    public BookBuilder author( String author )
    {
        this.author = author;

        return this;
    }

    public BookBuilder publisher( String publisher )
    {
        this.publisher = publisher;

        return this;
    }

    public BookBuilder title( String title )
    {
        this.title = title;

        return this;
    }

    public BookBuilder noOfDownloads( int noOfDownloads )
    {
        this.noOfDownloads = noOfDownloads;

        return this;
    }

    public Book build( )
    {
        return new Book( title, noOfDownloads, author, publisher );
    }
}
