package designpatterns.builderWithLambda;

import designpatterns.builder.Sender;

import static designpatterns.builderWithLambda.Message.message;

public class Client
{
    public static void main( String[] args )
    {
        Message message = message( ).sender( new Sender( "dan" ) )
                                    .title( "Hello" )
                                    .content( "World" );

        //with conversion
        message = message( ).sender( "dan" )
                            .title( "Hello" )
                            .content( "World" );

        //with alternate path
        message = message( ).sms( )
                            .sender( new SMSSender( new Contact( 07, "dan" ) ) )
                            .content( "Hello" );
    }
}
