package designpatterns.builder.withLambda;

import designpatterns.builder.withoutLambda.Sender;

public interface SenderBuilder
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
