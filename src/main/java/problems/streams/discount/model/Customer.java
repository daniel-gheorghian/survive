package problems.streams.discount.model;

public class Customer
{
    private MemberCard memberCard;

    public Customer( MemberCard memberCard )
    {
        this.memberCard = memberCard;
    }

    public MemberCard getMemberCard( )
    {
        return memberCard;
    }
}
