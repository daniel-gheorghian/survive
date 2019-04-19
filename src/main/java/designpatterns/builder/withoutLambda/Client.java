package designpatterns.builder.withoutLambda;

import designpatterns.builder.model.Message;
import designpatterns.builder.model.Sender;

import static designpatterns.builder.withoutLambda.MessageBuilder.messageBuilder;

public class Client
{
    public static void main( String[] args )
    {
        Message m = messageBuilder( ).sender( new Sender( "dan" ) )
                                     .title( "Hello" )
                                     .content( "World" )
                                     .build( );
    }
}
