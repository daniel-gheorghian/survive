package problems.design.library.model;

public class Video extends MediaEntity
{
    private int     duration;
    private boolean fullHD;

    public Video( String title, int noOfDownloads, int duration, boolean fullHD )
    {
        super( MediaType.VIDEO, title, noOfDownloads );
        this.duration = duration;
        this.fullHD = fullHD;
    }

    public int getDuration( )
    {
        return duration;
    }

    public boolean isFullHD( )
    {
        return fullHD;
    }
}
