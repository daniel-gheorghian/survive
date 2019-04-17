package problems.streams.campaign.model;

public class Participant
{
    private CustomerProfile customerProfile;
    private int             campaignGroup;

    public Participant( CustomerProfile customerProfile, int campaignGroup )
    {
        this.customerProfile = customerProfile;
        this.campaignGroup = campaignGroup;
    }

    public int getCampaignGroup( )
    {
        return campaignGroup;
    }

    public CustomerProfile getCustomerProfile( )
    {
        return customerProfile;
    }
}
