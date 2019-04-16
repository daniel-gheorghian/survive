package problems.refactor.streamWrecks.solution;

import problems.refactor.streamWrecks.model.Order;
import problems.refactor.streamWrecks.model.OrderLine;
import problems.refactor.streamWrecks.model.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class OrdersProcessing
{
    /*
     * Return products frequently bought products (quantity greater than 10) in the the previous year, excluding deleted or hidden products.
     */
    public List<Product> getFrequentOrderedProducts( List<Order> orders )
    {
        Collection<Integer>          hiddenProductIds  = this.getHiddenProductIds( );
        Predicate<ProductStatistics> accessibleProduct = productStatistics -> !hiddenProductIds.contains( productStatistics.productId( ) );

        return getProductStatisticsWithinLastYear( orders ).stream( )
                                                           .filter( ProductStatistics::frequentlyBought )
                                                           .filter( ProductStatistics::availableProduct )
                                                           .filter( accessibleProduct )
                                                           .map( ProductStatistics::getProduct )
                                                           .collect( toList( ) );
    }

    private List<ProductStatistics> getProductStatisticsWithinLastYear( List<Order> orders )
    {
        return getProductStatistics( getOrderLinesByProductWithinTheLastYear( orders ) );
    }

    private List<ProductStatistics> getProductStatistics( Map<Integer, List<OrderLine>> orderLinesByProduct )
    {
        return orderLinesByProduct.values( )
                                  .stream( )
                                  .map( ProductStatistics::fromOrderLines )
                                  .filter( Optional::isPresent )
                                  .map( Optional::get )
                                  .collect( Collectors.toList( ) );
    }

    private Map<Integer, List<OrderLine>> getOrderLinesByProductWithinTheLastYear( List<Order> orders )
    {
        return orders.stream( )
                     .filter( Order::withinLastYear )
                     .map( Order::getOrderLines )
                     .flatMap( List::stream )
                     .collect( groupingBy( OrderLine::productId ) );
    }

    public Collection<Integer> getHiddenProductIds( )
    {
        return Collections.emptyList( );
    }
}
