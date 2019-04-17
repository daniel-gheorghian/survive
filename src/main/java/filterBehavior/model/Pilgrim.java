package filterBehavior.model;

public class Pilgrim
{
    private String  name;
    private String  homeCity;
    private boolean hooded;
    private String  hoodColor;

    public String getHoodColor( )
    {
        return hoodColor;
    }

    public void setHoodColor( String hoodColor )
    {
        this.hoodColor = hoodColor;
    }

    public String getName( )
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getHomeCity( )
    {
        return homeCity;
    }

    public void setHomeCity( String homeCity )
    {
        this.homeCity = homeCity;
    }

    public boolean isHooded( )
    {
        return hooded;
    }

    public void setHooded( boolean hooded )
    {
        this.hooded = hooded;
    }
}
