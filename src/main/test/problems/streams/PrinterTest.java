package problems.streams;

import org.junit.Test;
import problems.streams.discount.Printer;
import problems.streams.discount.model.Customer;
import problems.streams.discount.model.MemberCard;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PrinterTest
{
    @Test
    public void three_percent_discount_for_60_fidelity_points( )
    {
        Customer customer = new Customer( new MemberCard( 60 ) );

        String discountLine = new Printer( ).getDiscountLine( customer );

        assertThat( discountLine, is( equalTo( "Discount%: 3" ) ) );
    }

    @Test
    public void five_percent_discount_for_110_fidelity_points( )
    {
        Customer customer = new Customer( new MemberCard( 110 ) );

        String discountLine = new Printer( ).getDiscountLine( customer );

        assertThat( discountLine, is( equalTo( "Discount%: 5" ) ) );
    }

    @Test
    public void no_discount_for_less_than_50_fidelity_points( )
    {
        Customer customer = new Customer( new MemberCard( 30 ) );

        String discountLine = new Printer( ).getDiscountLine( customer );

        assertThat( discountLine, is( equalTo( "" ) ) );
    }

    @Test
    public void no_member_card_no_discount( )
    {
        Customer customer = new Customer( null );

        String discountLine = new Printer( ).getDiscountLine( customer );

        assertThat( discountLine, is( equalTo( "" ) ) );
    }
}
