package problems.design.library.model;

import java.util.Objects;

public abstract class MediaEntity
{
    protected MediaType type;
    protected String    title;
    protected int       noOfDownloads;

    public MediaEntity( MediaType type, String title, int noOfDownloads )
    {
        this.type = type;
        this.title = title;
        this.noOfDownloads = noOfDownloads;
    }

    public MediaType getType( )
    {
        return type;
    }

    public String getTitle( )
    {
        return title;
    }

    public int getNoOfDownloads( )
    {
        return noOfDownloads;
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
        MediaEntity entity = (MediaEntity)o;
        return type == entity.type &&
               Objects.equals( title, entity.title );
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( type, title );
    }
}
