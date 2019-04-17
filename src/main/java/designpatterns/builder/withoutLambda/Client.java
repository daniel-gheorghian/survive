package designpatterns.builder.withoutLambda;

public class Client
{
    public static void main( String[] args )
    {
        Message m = Message.builder( )
                           .sender( new Sender( "dan" ) )
                           .title( "Hello" )
                           .content( "World" )
                           .build( );
    }
}
