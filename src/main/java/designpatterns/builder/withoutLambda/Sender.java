package designpatterns.builder.withoutLambda;

public class Sender
{
    private String name;

    public Sender( String name )
    {
        this.name = name;
    }

    public String getName( )
    {
        return name;
    }
}
