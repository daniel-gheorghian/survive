package designpatterns.builder.withLambda;

import designpatterns.builder.withoutLambda.Sender;

import static designpatterns.builder.withLambda.Message.message;

public class Client
{
    public static void main( String[] args )
    {
        Message message1 = message( ).sender( new Sender( "dan" ) )
                                     .title( "Hello" )
                                     .content( "World" );

        //with conversion
        Message message2 = message( ).sender( "dan" )
                                     .title( "Hello" )
                                     .content( "World" );

        //with alternate path
        Message message3 = message( ).sms( )
                                     .sender( new SMSSender( new Contact( 123, "dan" ) ) )
                                     .content( "Hello" );
    }
}
