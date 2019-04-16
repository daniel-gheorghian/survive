package problems.refactor.streamWrecks.model;

public class Product
{
    private int     id;
    private boolean deleted;

    public Product( int id, boolean deleted )
    {
        this.id = id;
        this.deleted = deleted;
    }

    public int getId( )
    {
        return id;
    }

    public boolean isDeleted( )
    {
        return deleted;
    }
}
