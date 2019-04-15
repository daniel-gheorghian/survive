package problems.design.library.model;

import java.util.Objects;

public class Book extends MediaEntity
{
    private String author;
    private String publisher;

    public Book( String title, int noOfDownloads, String author, String publisher )
    {
        super( MediaType.BOOK, title, noOfDownloads );

        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor( )
    {
        return author;
    }

    public String getPublisher( )
    {
        return publisher;
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
        Book book = (Book)o;
        return Objects.equals( author, book.author ) &&
               Objects.equals( publisher, book.publisher );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( super.hashCode( ), author, publisher );
    }
}