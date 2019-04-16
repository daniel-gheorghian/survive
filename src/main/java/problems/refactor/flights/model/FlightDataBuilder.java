package problems.refactor.flights.model;

import java.time.LocalDate;

public class FlightDataBuilder
{
    public interface OriginBuilder
    {
        DestinationBuilder origin( String origin );
    }

    public interface DestinationBuilder
    {
        DateBuilder destination( String destination );
    }

    public interface DateBuilder
    {
        FlightNumberBuilder date( LocalDate date );

        default FlightNumberBuilder today( )
        {
            return date( LocalDate.now( ) );
        }
    }

    public interface FlightNumberBuilder
    {
        CarrierBuilder flightNumber( int number );
    }

    public interface CarrierBuilder
    {
        DelayBuilder carrier( String carrier );
    }

    public interface DelayBuilder
    {
        CancelledBuilder delay( int delayMinutes );
    }

    public interface CancelledBuilder
    {
        FlightData cancelled( boolean cancelled );
    }
}
