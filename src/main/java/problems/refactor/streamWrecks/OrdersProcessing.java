package problems.refactor.streamWrecks;

import problems.refactor.streamWrecks.model.Order;
import problems.refactor.streamWrecks.model.OrderLine;
import problems.refactor.streamWrecks.model.Product;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class OrdersProcessing
{
    /*
     * Return products frequently bought products (quantity greater than 10) in the the previous year, excluding deleted or hidden products.
     */
    public List<Product> getFrequentOrderedProducts( List<Order> orders )
    {
        return orders.stream( )
                     .filter( o -> o.getCreationDate( ).isAfter( LocalDate.now( ).minusYears( 1 ) ) )
                     .flatMap( o -> o.getOrderLines( ).stream( ) )
                     .collect( groupingBy( OrderLine::getProduct, summingInt( OrderLine::getItemCount ) ) )
                     .entrySet( )
                     .stream( )
                     .filter( e -> e.getValue( ) >= 10 )
                     .map( Map.Entry::getKey )
                     .filter( p -> !p.isDeleted( ) )
                     .filter( p -> !this.getHiddenProductIds( ).contains( p.getId( ) ) )
                     .collect( toList( ) );
    }

    public Collection<Integer> getHiddenProductIds( )
    {
        return Collections.emptyList( );
    }
}
