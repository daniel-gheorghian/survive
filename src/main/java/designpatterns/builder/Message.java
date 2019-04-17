package designpatterns.builder;

public class Message
{
    private Sender sender; //required
    private String title; //required
    private String content; //optional

    public Message( Sender sender, String title, String content )
    {
        this.sender = sender;
        this.title = title;
        this.content = content;
    }

    public Sender getSender( )
    {
        return sender;
    }

    public String getTitle( )
    {
        return title;
    }

    public String getContent( )
    {
        return content;
    }

    public static MessageBuilder builder( )
    {
        return new MessageBuilder( );
    }
}
