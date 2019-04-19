package designpatterns.builder.model;

public class Contact
{
    private long   phoneNumber;
    private String name;

    public Contact( long phoneNumber, String name )
    {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getName( )
    {
        return name;
    }

    public long getPhoneNumber( )
    {
        return phoneNumber;
    }
}
