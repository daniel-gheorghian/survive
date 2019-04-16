package problems.refactor.flights;

import problems.refactor.flights.model.AirportStatistics;
import problems.refactor.flights.model.FlightData;

import java.util.*;

public class Airport
{
    public List<AirportStatistics> airportStatistics( )
    {
        List<FlightData> flightData = flightData( );

        Map<String, Integer> count         = new HashMap<>( );
        Map<String, Integer> cancellations = new HashMap<>( );
        Map<String, Integer> totalDelay    = new HashMap<>( );

        for( FlightData flight : flightData )
        {
            String airport = flight.getDestination( );

            if( !count.containsKey( airport ) )
            {
                count.put( airport, 0 );
                cancellations.put( airport, 0 );
                totalDelay.put( airport, 0 );
            }

            count.put( airport, count.get( airport ) + 1 );

            if( flight.isCancelled( ) )
            {
                cancellations.put( airport, cancellations.get( airport ) + 1 );
            }
            else
            {
                totalDelay.put( airport, totalDelay.get( airport ) + flight.getDelayMinutes( ) );
            }
        }

        List<AirportStatistics> result = new ArrayList<>( );

        for( String airport : count.keySet( ) )
        {
            int flownFlights = count.get( airport ) - cancellations.get( airport );
            int meanDelay    = 0;

            if( flownFlights > 0 )
            {
                meanDelay = totalDelay.get( airport ) / flownFlights;
            }

            int cancellationRate = cancellations.get( airport ) / count.get( airport );

            AirportStatistics statistics = new AirportStatistics( meanDelay, cancellationRate );
            result.add( statistics );
        }

        return result;
    }

    public List<FlightData> flightData( )
    {
        return Collections.emptyList( );
    }
}
