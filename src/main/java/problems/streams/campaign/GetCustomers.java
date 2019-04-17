package problems.streams.campaign;

import problems.streams.campaign.model.Campaign;
import problems.streams.campaign.model.CustomerProfile;
import problems.streams.campaign.model.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetCustomers
{
    /*
     * Get profiles of customers from group one of active campaigns
     */
    public List<CustomerProfile> profilesOfActiveCampaignsParticipants( List<Campaign> campaigns )
    {
        List<CustomerProfile> customerProfiles = new ArrayList<>( );

        for( Campaign c : campaigns )
        {
            if( c.isActive( ) )
            {
                for( Participant p : c.getParticipants( ) )
                {
                    if( p.getCampaignGroup( ) == 1 )
                    {
                        customerProfiles.add( p.getCustomerProfile( ) );
                    }
                }
            }
        }

        Collections.sort( customerProfiles, new Comparator<CustomerProfile>( )
        {
            public int compare( CustomerProfile c1, CustomerProfile c2 )
            {
                return c1.getName( ).compareTo( c2.getName( ) );
            }
        } );

        return customerProfiles;
    }
}
