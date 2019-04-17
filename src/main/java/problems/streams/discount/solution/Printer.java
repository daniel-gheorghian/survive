package problems.streams.discount.solution;

import problems.streams.discount.model.Customer;
import problems.streams.discount.model.MemberCard;

import java.util.Optional;

public class Printer
{
    /*
     * Get user friendly discount percentage for member customers
     */
    public String getDiscountLine( Customer customer )
    {
        return Optional.ofNullable( customer.getMemberCard( ) )
                       .flatMap( this::getDiscountPercentage )
                       .map( d -> "Discount%: " + d )
                       .orElse( "" );
    }

    private Optional<Integer> getDiscountPercentage( MemberCard card )
    {
        if( card.getFidelityPoints( ) >= 100 )
        {
            return Optional.of( 5 );
        }

        if( card.getFidelityPoints( ) >= 50 )
        {
            return Optional.of( 3 );
        }

        return Optional.empty( );
    }
}
