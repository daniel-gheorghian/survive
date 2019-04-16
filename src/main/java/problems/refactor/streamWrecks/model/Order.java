package problems.refactor.streamWrecks.model;

import java.time.LocalDate;
import java.util.List;

public class Order
{
    private LocalDate       creationDate;
    private List<OrderLine> orderLines;

    public Order( LocalDate creationDate, List<OrderLine> orderLines )
    {
        this.creationDate = creationDate;
        this.orderLines = orderLines;
    }

    public LocalDate getCreationDate( )
    {
        return creationDate;
    }

    public List<OrderLine> getOrderLines( )
    {
        return orderLines;
    }

    public Order addLine( OrderLine line )
    {
        orderLines.add( line );

        return this;
    }

    public boolean withinLastYear( )
    {
        return this.creationDate.isAfter( LocalDate.now( ).minusYears( 1 ) );
    }
}
