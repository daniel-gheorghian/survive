package problems.streams.campaign.model;

import java.util.List;

public class Campaign
{
    private boolean active;
    private List<Participant> participants;

    public Campaign( boolean active, List<Participant> participants )
    {
        this.active = active;
        this.participants = participants;
    }

    public boolean isActive( )
    {
        return active;
    }

    public List<Participant> getParticipants( )
    {
        return participants;
    }
}
