package problems.refactor.flights.solution;

import problems.refactor.flights.model.AirportStatistics;
import problems.refactor.flights.model.FlightData;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Airport
{
    /*
     * Compute per destination airport the mean delay of flights and the cancellation rate
     * Flight data looks like this:
     * {
     *      "origin": "BOS", "destination": "LAX", "date": "2015-01-12",
     *      "number": "25", "carrier": "AA", "delayMinutes": 0.0, "cancelled": false
     * }
     */
    public List<AirportStatistics> airportStatistics( )
    {
        Map<String, List<FlightData>> dataByAirport = flightData( ).stream( )
                                                                   .collect( Collectors.groupingBy( FlightData::getDestination ) );

        return dataByAirport.values( )
                            .stream( )
                            .map( this::flightStatistics )
                            .map( this::airportStatistics )
                            .collect( Collectors.toList( ) );
    }

    private FlightStatistics flightStatistics( List<FlightData> data )
    {
        int flightsCount = data.size( );
        int cancellations = (int)data.stream( )
                                     .filter( FlightData::isCancelled )
                                     .count( );
        int totalDelay = data.stream( )
                             .mapToInt( FlightData::getDelayMinutes )
                             .sum( );

        return new FlightStatistics( flightsCount, cancellations, totalDelay );
    }

    private AirportStatistics airportStatistics( FlightStatistics statistics )
    {
        return new AirportStatistics( statistics.meanDelay( ), statistics.cancellationRate( ) );
    }

    public List<FlightData> flightData( )
    {
        return Collections.emptyList( );
    }
}
