package designpatterns.builder.withoutLambda;

import designpatterns.builder.model.Message;
import designpatterns.builder.model.Sender;

public class MessageBuilder
{
    private Sender sender;
    private String title;
    private String content;

    public MessageBuilder sender( Sender sender )
    {
        this.sender = sender;

        return this;
    }

    public MessageBuilder content( String content )
    {
        this.content = content;

        return this;
    }

    public MessageBuilder title( String title )
    {
        this.title = title;

        return this;
    }

    public Message build( )
    {
        return new Message( sender, title, content );
    }

    public static MessageBuilder messageBuilder( )
    {
        return new MessageBuilder( );
    }
}
