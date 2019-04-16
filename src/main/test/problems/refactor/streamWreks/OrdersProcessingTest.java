package problems.refactor.streamWreks;

import org.junit.Before;
import org.junit.Test;
import problems.refactor.streamWrecks.OrdersProcessing;
import problems.refactor.streamWrecks.model.Order;
import problems.refactor.streamWrecks.model.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static problems.refactor.streamWreks.OrdersStore.line;
import static problems.refactor.streamWreks.OrdersStore.order;

public class OrdersProcessingTest
{
    private OrdersProcessing ordersProcessing;

    @Before
    public void setUp( )
    {
        ordersProcessing = new OrdersProcessing( );
        ordersProcessing = spy( ordersProcessing );
    }

    @Test
    public void empty_order_data_produces_empty_result( )
    {
        List<Product> frequentOrderedProducts = ordersProcessing.getFrequentOrderedProducts( Collections.emptyList( ) );

        assertThat( frequentOrderedProducts, is( empty( ) ) );
    }

    @Test
    public void having_orders_older_than_one_year_products_list_is_empty( )
    {
        List<Order> orders = Arrays.asList( order( ).yearsAgo( 1 )
                                                    .lines( line( ).productId( 1 ).quantity( 12 ) ),
                                            order( ).yearsAgo( 2 )
                                                    .lines( line( ).productId( 3 ).quantity( 12 ) ) );

        List<Product> frequentOrderedProducts = ordersProcessing.getFrequentOrderedProducts( orders );

        assertThat( frequentOrderedProducts, is( empty( ) ) );
    }

    @Test
    public void deleted_products_dont_appear_in_the_results( )
    {
        List<Order> orders = Arrays.asList( order( ).today( )
                                                    .lines( line( ).deletedProductId( 1 ).quantity( 120 ) ),
                                            order( ).today( )
                                                    .lines( line( ).productId( 3 ).quantity( 12 ) ) );

        List<Product> frequentOrderedProducts = ordersProcessing.getFrequentOrderedProducts( orders );

        assertThat( frequentOrderedProducts, is( not( empty( ) ) ) );
        assertThat( frequentOrderedProducts, containsInAnyOrder( hasProperty( "id", is( 3 ) ) ) );
    }

    @Test
    public void hidden_products_dont_appear_in_the_results( )
    {
        List<Order> orders = Arrays.asList( order( ).today( )
                                                    .lines( line( ).productId( 1 ).quantity( 120 ) ),
                                            order( ).today( )
                                                    .lines( line( ).productId( 3 ).quantity( 12 ) ) );
        when( ordersProcessing.getHiddenProductIds( ) ).thenReturn( Arrays.asList( 3 ) );

        List<Product> frequentOrderedProducts = ordersProcessing.getFrequentOrderedProducts( orders );

        assertThat( frequentOrderedProducts, is( not( empty( ) ) ) );
        assertThat( frequentOrderedProducts, containsInAnyOrder( hasProperty( "id", is( 1 ) ) ) );
    }

    @Test
    public void only_products_ordered_more_than_10_times_are_returned( )
    {
        List<Order> orders = Arrays.asList( order( ).today( )
                                                    .lines( line( ).productId( 1 ).quantity( 2 ) ),
                                            order( ).today( )
                                                    .lines( line( ).productId( 5 ).quantity( 12 ) ) );

        List<Product> frequentOrderedProducts = ordersProcessing.getFrequentOrderedProducts( orders );

        assertThat( frequentOrderedProducts, is( not( empty( ) ) ) );
        assertThat( frequentOrderedProducts, containsInAnyOrder( hasProperty( "id", is( 5 ) ) ) );
    }
}
