package problems.design.library;

import problems.design.library.model.Video;

public class VideoBuilder
{
    private String  title;
    private int     noOfDownloads;
    private int     duration;
    private boolean fullHD;

    public VideoBuilder title( String title )
    {
        this.title = title;

        return this;
    }

    public VideoBuilder noOfDownloads( int noOfDownloads )
    {
        this.noOfDownloads = noOfDownloads;

        return this;
    }

    public VideoBuilder duration( int duration )
    {
        this.duration = duration;

        return this;
    }

    public VideoBuilder fullHD( boolean fullHD )
    {
        this.fullHD = fullHD;

        return this;
    }

    public Video build( )
    {
        return new Video( title, noOfDownloads, duration, fullHD );
    }
}
