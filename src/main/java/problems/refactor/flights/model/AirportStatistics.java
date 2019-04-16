package problems.refactor.flights.model;

public class AirportStatistics
{
    private int meanDelay;
    private int cancellationRate;

    public AirportStatistics( int meanDelay, int cancellationRate )
    {
        this.meanDelay = meanDelay;
        this.cancellationRate = cancellationRate;
    }

    public int getMeanDelay( )
    {
        return meanDelay;
    }

    public int getCancellationRate( )
    {
        return cancellationRate;
    }
}
