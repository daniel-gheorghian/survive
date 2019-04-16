package problems.refactor.flights.solution;

class FlightStatistics
{
    private int flightsCount;
    private int cancellations;
    private int totalDelay;

    public FlightStatistics( int flightsCount, int cancellations, int totalDelay )
    {
        this.flightsCount = flightsCount;
        this.cancellations = cancellations;
        this.totalDelay = totalDelay;
    }

    public int meanDelay( )
    {
        if( flightsCount == cancellations )
        {
            return 0;
        }

        return totalDelay / ( flightsCount - cancellations );
    }

    public int cancellationRate( )
    {
        return cancellations / flightsCount;
    }
}
