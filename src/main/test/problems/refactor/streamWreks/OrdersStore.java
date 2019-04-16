package problems.refactor.streamWreks;

import problems.refactor.streamWrecks.model.Order;
import problems.refactor.streamWrecks.model.OrderLine;
import problems.refactor.streamWrecks.model.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class OrdersStore
{

    public static OrderDateBuilder order( )
    {
        return date -> lines -> new Order( date, Arrays.asList( lines ) );
    }

    public static OrderLineProduct line( )
    {
        return product -> count -> new OrderLine( product, count );
    }

    public interface OrderDateBuilder
    {
        OrderBuilder date( LocalDate date );

        default OrderBuilder yearsAgo( int minusYears )
        {
            return date( LocalDate.now( ).minusYears( minusYears ) );
        }

        default OrderBuilder today( )
        {
            return date( LocalDate.now( ) );
        }
    }

    public interface OrderBuilder
    {
        Order lines( OrderLine... lines );
    }

    public interface OrderLineProduct
    {
        OrderLineCount productId( Product p );

        default OrderLineCount deletedProductId( int id )
        {
            return productId( new Product( id, true ) );
        }

        default OrderLineCount productId( int id )
        {
            return productId( new Product( id, false ) );
        }
    }

    public interface OrderLineCount
    {
        OrderLine quantity( int count );
    }
}
