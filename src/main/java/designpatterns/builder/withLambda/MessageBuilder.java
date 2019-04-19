package designpatterns.builder.withLambda;

import designpatterns.builder.model.Message;
import designpatterns.builder.model.SMSSender;
import designpatterns.builder.model.Sender;

public interface MessageBuilder
{
    static SenderBuilder message( )
    {
        return sender -> title -> content -> new Message( sender, title, content );
    }

    interface SenderBuilder
    {
        TitleBuilder sender( Sender sender );

        default TitleBuilder sender( String name )
        {
            return sender( new Sender( name ) );
        }

        default SMSBuilder sms( )
        {
            return sender -> content -> new Message( sender, null, content );
        }
    }

    interface TitleBuilder
    {
        ContentBuilder title( String title );
    }

    interface ContentBuilder
    {
        Message content( String content );
    }

    interface SMSBuilder
    {
        ContentBuilder sender( SMSSender sender );
    }
}

