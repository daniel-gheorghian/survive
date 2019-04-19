package designpatterns.builder.model;

public class SMSSender extends Sender
{
    private Contact contact;

    public SMSSender( Contact contact )
    {
        super( contact.getName( ) );

        this.contact = contact;
    }

    public Contact getContact( )
    {
        return contact;
    }
}
