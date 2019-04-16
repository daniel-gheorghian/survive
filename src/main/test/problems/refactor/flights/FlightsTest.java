package problems.refactor.flights;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import problems.refactor.flights.model.AirportStatistics;
import problems.refactor.flights.model.FlightData;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class FlightsTest
{
    private Airport airport;

    @Before
    public void setUp( )
    {
        airport = new Airport( );
        airport = spy( airport );
    }

    @Test
    public void flight_data_is_constructed_with_all_properties( )
    {
        FlightData flight = FlightData.builder( )
                                      .origin( "BOS" )
                                      .destination( "LAX" )
                                      .today( )
                                      .flightNumber( 25 )
                                      .carrier( "AA" )
                                      .delay( 0 )
                                      .cancelled( false );

        assertThat( flight, hasProperty( "origin", is( "BOS" ) ) );
        assertThat( flight, hasProperty( "destination", is( "LAX" ) ) );
        assertThat( flight, hasProperty( "date", is( LocalDate.now( ) ) ) );
        assertThat( flight, hasProperty( "number", is( 25 ) ) );
        assertThat( flight, hasProperty( "carrier", is( "AA" ) ) );
        assertThat( flight, hasProperty( "delayMinutes", is( 0 ) ) );
        assertThat( flight, hasProperty( "cancelled", is( false ) ) );
    }

    @Test
    public void no_flight_data_returns_no_statistics( )
    {
        List<AirportStatistics> statistics = airport.airportStatistics( );

        assertThat( statistics, is( empty( ) ) );
    }

    @Test
    public void flights_with_no_delays_and_cancellations_result_in_zero_cancellation_rates_and_mean_delays( )
    {
        when( airport.flightData( ) ).thenReturn( FlightDataStore.zeroCancellationsAndDelays( ) );

        List<AirportStatistics> statistics = airport.airportStatistics( );

        assertThat( statistics, containsInAnyOrder( airportStatistics( 0, 0 ),
                                                    airportStatistics( 0, 0 ) ) );
    }

    @Test
    public void having_flights_with_delays_and_no_cancellations_result_in_zero_cancellation_rates_and_a_computed_mean_delay( )
    {
        when( airport.flightData( ) ).thenReturn( FlightDataStore.withDelayAndZeroCancellations( ) );

        List<AirportStatistics> statistics = airport.airportStatistics( );

        assertThat( statistics, containsInAnyOrder( airportStatistics( 0, 0 ),
                                                    airportStatistics( 10, 0 ) ) );
    }

    @Test
    public void having_flights_with_no_delays_and_cancellations_results_in_zero_mean_delay_and_a_computed_cancellation_rate( )
    {
        when( airport.flightData( ) ).thenReturn( FlightDataStore.withCancellationsAndZeroDelays( ) );

        List<AirportStatistics> statistics = airport.airportStatistics( );

        assertThat( statistics, containsInAnyOrder( airportStatistics( 0, 1 ),
                                                    airportStatistics( 0, 0 ) ) );
    }

    @Test
    public void having_flights_with_delays_and_cancellations_results_in_computed_cancellation_and_delay_rates( )
    {
        when( airport.flightData( ) ).thenReturn( FlightDataStore.withDelayAndCancellations( ) );

        List<AirportStatistics> statistics = airport.airportStatistics( );

        assertThat( statistics, containsInAnyOrder( airportStatistics( 0, 1 ),
                                                    airportStatistics( 10, 0 ) ) );
    }

    private Matcher<AirportStatistics> airportStatistics( int meanDelay, int cancellationRate )
    {
        return allOf( hasProperty( "meanDelay", is( meanDelay ) ),
                      hasProperty( "cancellationRate", is( cancellationRate ) ) );
    }
}
