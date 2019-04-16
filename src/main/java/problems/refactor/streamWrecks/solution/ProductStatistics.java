package problems.refactor.streamWrecks.solution;

import problems.refactor.streamWrecks.model.OrderLine;
import problems.refactor.streamWrecks.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductStatistics
{
    private Product product;
    private int     soldQuantity;

    public ProductStatistics( Product product, int soldQuantity )
    {
        this.product = product;
        this.soldQuantity = soldQuantity;
    }

    public static Optional<ProductStatistics> fromOrderLines( List<OrderLine> lines )
    {
        if( lines == null || lines.isEmpty( ) )
        {
            return Optional.empty( );
        }

        int soldQuantity = lines.stream( )
                                .mapToInt( OrderLine::getItemCount )
                                .sum( );

        Product product = lines.get( 0 ).getProduct( );

        return Optional.of( new ProductStatistics( product, soldQuantity ) );
    }

    public Product getProduct( )
    {
        return product;
    }

    public boolean frequentlyBought( )
    {
        return soldQuantity > 10;
    }

    public boolean availableProduct( )
    {
        return !product.isDeleted( );
    }

    public int productId( )
    {
        return product.getId( );
    }
}
