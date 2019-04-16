package problems.refactor.flights;

import problems.refactor.flights.model.FlightData;

import java.util.Arrays;
import java.util.List;

public class FlightDataStore
{
    public static List<FlightData> zeroCancellationsAndDelays( )
    {
        return Arrays.asList( FlightData.builder( )
                                        .origin( "BOS" )
                                        .destination( "LAX" )
                                        .today( )
                                        .flightNumber( 25 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( false ),
                              FlightData.builder( )
                                        .origin( "LAX" )
                                        .destination( "BOS" )
                                        .today( )
                                        .flightNumber( 26 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( false ) );
    }

    public static List<FlightData> withCancellationsAndZeroDelays( )
    {
        return Arrays.asList( FlightData.builder( )
                                        .origin( "BOS" )
                                        .destination( "LAX" )
                                        .today( )
                                        .flightNumber( 25 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( true ),
                              FlightData.builder( )
                                        .origin( "LAX" )
                                        .destination( "BOS" )
                                        .today( )
                                        .flightNumber( 26 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( false ) );
    }

    public static List<FlightData> withDelayAndZeroCancellations( )
    {
        return Arrays.asList( FlightData.builder( )
                                        .origin( "BOS" )
                                        .destination( "LAX" )
                                        .today( )
                                        .flightNumber( 25 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( false ),
                              FlightData.builder( )
                                        .origin( "LAX" )
                                        .destination( "BOS" )
                                        .today( )
                                        .flightNumber( 26 )
                                        .carrier( "AA" )
                                        .delay( 10 )
                                        .cancelled( false ) );
    }

    public static List<FlightData> withDelayAndCancellations( )
    {
        return Arrays.asList( FlightData.builder( )
                                        .origin( "BOS" )
                                        .destination( "LAX" )
                                        .today( )
                                        .flightNumber( 25 )
                                        .carrier( "AA" )
                                        .delay( 0 )
                                        .cancelled( true ),
                              FlightData.builder( )
                                        .origin( "LAX" )
                                        .destination( "BOS" )
                                        .today( )
                                        .flightNumber( 26 )
                                        .carrier( "AA" )
                                        .delay( 10 )
                                        .cancelled( false ) );
    }
}
