package problems.refactor.streamWrecks.model;

public class OrderLine
{
    private Product product;
    private int     itemCount;

    public OrderLine( Product product, int itemCount )
    {
        this.product = product;
        this.itemCount = itemCount;
    }

    public Product getProduct( )
    {
        return product;
    }

    public int getItemCount( )
    {
        return itemCount;
    }

    public int productId( )
    {
        return product.getId( );
    }
}
