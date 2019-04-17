package problems.streams;

import org.junit.Test;
import problems.streams.campaign.GetCustomers;
import problems.streams.campaign.model.Campaign;
import problems.streams.campaign.model.CustomerProfile;
import problems.streams.campaign.model.Participant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetCustomersTest
{
    @Test
    public void empty_campaigns_list_returns_empty_customer_profiles_list( )
    {
        GetCustomers getCustomers = new GetCustomers( );

        List<CustomerProfile> customerProfiles = getCustomers.profilesOfActiveCampaignsParticipants( Collections.emptyList( ) );

        assertThat( customerProfiles, is( notNullValue( ) ) );
        assertThat( customerProfiles, is( empty( ) ) );
    }

    @Test
    public void list_of_non_active_campaigns_returns_empty_customer_profiles_list( )
    {
        GetCustomers   getCustomers = new GetCustomers( );
        List<Campaign> campaigns    = Arrays.asList( inactiveCampaign( ), inactiveCampaign( ) );

        List<CustomerProfile> customerProfiles = getCustomers.profilesOfActiveCampaignsParticipants( campaigns );

        assertThat( customerProfiles, is( notNullValue( ) ) );
        assertThat( customerProfiles, is( empty( ) ) );
    }

    @Test
    public void list_of_non_matching_campaign_group_returns_empty_customer_profiles_list( )
    {
        GetCustomers getCustomers = new GetCustomers( );
        List<Campaign> campaigns = Arrays.asList(
                activeNonMatchingCampaign( participant( "n1", 2 ), participant( "n2", 3 ) ),
                activeNonMatchingCampaign( participant( "n3", 3 ), participant( "n4", 5 ) ) );

        List<CustomerProfile> customerProfiles = getCustomers.profilesOfActiveCampaignsParticipants( campaigns );

        assertThat( customerProfiles, is( notNullValue( ) ) );
        assertThat( customerProfiles, is( empty( ) ) );
    }

    @Test
    public void list_of_matching_campaign_group_returns_customer_profiles_list( )
    {
        GetCustomers getCustomers = new GetCustomers( );
        List<Campaign> campaigns = Arrays.asList(
                activeNonMatchingCampaign( participant( "n1", 1 ), participant( "n2", 3 ) ),
                activeNonMatchingCampaign( participant( "n3", 3 ), participant( "n4", 1 ) ) );

        List<CustomerProfile> customerProfiles = getCustomers.profilesOfActiveCampaignsParticipants( campaigns );

        assertThat( customerProfiles, is( notNullValue( ) ) );
        assertThat( customerProfiles, hasSize( 2 ) );
        assertThat( customerProfiles, contains(
                hasProperty( "name", is( "n1" ) ),
                hasProperty( "name", is( "n4" ) ) ) );
    }

    @Test
    public void list_of_matching_campaign_group_returns_a_sorted_customer_profiles_list( )
    {
        GetCustomers getCustomers = new GetCustomers( );
        List<Campaign> campaigns = Arrays.asList(
                activeNonMatchingCampaign( participant( "n1", 1 ), participant( "n2", 3 ) ),
                activeNonMatchingCampaign( participant( "n3", 3 ), participant( "n4", 1 ) ) );

        List<CustomerProfile> customerProfiles = getCustomers.profilesOfActiveCampaignsParticipants( campaigns );

        assertThat( customerProfiles, is( notNullValue( ) ) );
        assertThat( customerProfiles, contains(
                hasProperty( "name", is( "n1" ) ),
                hasProperty( "name", is( "n4" ) ) ) );
    }

    private Campaign inactiveCampaign( )
    {
        return new Campaign( false, Collections.emptyList( ) );
    }

    private Campaign activeNonMatchingCampaign( Participant... participants )
    {
        return new Campaign( true, Arrays.asList( participants ) );
    }

    private Campaign activeMatchingCampaign( Participant... participants )
    {
        return new Campaign( true, Arrays.asList( participants ) );
    }

    private Participant participant( String name, int group )
    {
        return new Participant( new CustomerProfile( name ), group );
    }
}
