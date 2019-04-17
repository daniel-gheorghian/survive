package problems.streams.discount;

import problems.streams.discount.model.Customer;
import problems.streams.discount.model.MemberCard;

public class Printer
{
    public String getDiscountLine( Customer customer )
    {
        if( customer.getMemberCard( ) == null )
        {
            return "";
        }

        Integer discount = getDiscountPercentage( customer.getMemberCard( ) );

        if( discount != null )
        {
            return "Discount%: " + discount;
        }
        else
        {
            return "";
        }
    }

    private Integer getDiscountPercentage( MemberCard card )
    {
        if( card.getFidelityPoints( ) >= 100 )
        {
            return 5;
        }

        if( card.getFidelityPoints( ) >= 50 )
        {
            return 3;
        }

        return null;
    }
}
