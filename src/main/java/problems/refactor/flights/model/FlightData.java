package problems.refactor.flights.model;

import java.time.LocalDate;

public class FlightData
{
    private String    origin;
    private String    destination;
    private LocalDate date;
    private int       number;
    private String    carrier;
    private int       delayMinutes;
    private boolean   cancelled;

    public FlightData( String origin, String destination, LocalDate date, int number, String carrier, int delayMinutes, boolean cancelled )
    {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.number = number;
        this.carrier = carrier;
        this.delayMinutes = delayMinutes;
        this.cancelled = cancelled;
    }

    public static FlightDataBuilder.OriginBuilder builder( )
    {
        return origin -> destination -> date -> flightNumber -> carrier -> delayMinutes -> cancelled -> new FlightData( origin, destination,
                                                                                                                        date, flightNumber,
                                                                                                                        carrier,
                                                                                                                        delayMinutes,
                                                                                                                        cancelled );
    }

    public String getOrigin( )
    {
        return origin;
    }

    public String getDestination( )
    {
        return destination;
    }

    public LocalDate getDate( )
    {
        return date;
    }

    public int getNumber( )
    {
        return number;
    }

    public String getCarrier( )
    {
        return carrier;
    }

    public int getDelayMinutes( )
    {
        return delayMinutes;
    }

    public boolean isCancelled( )
    {
        return cancelled;
    }
}
