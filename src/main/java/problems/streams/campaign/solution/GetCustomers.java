package problems.streams.campaign.solution;

import problems.streams.campaign.model.Campaign;
import problems.streams.campaign.model.CustomerProfile;
import problems.streams.campaign.model.Participant;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class GetCustomers
{
    /*
     * Get profiles of customers from group one of active campaigns
     */
    public List<CustomerProfile> profilesOfActiveCampaignsParticipants( List<Campaign> campaigns )
    {
        return campaigns.stream( )
                        .filter( Campaign::isActive )
                        .map( Campaign::getParticipants )
                        .flatMap( List::stream )
                        .filter( p -> p.getCampaignGroup( ) == 1 )
                        .map( Participant::getCustomerProfile )
                        .sorted( comparing( CustomerProfile::getName ) )
                        .collect( toList( ) );
    }
}
