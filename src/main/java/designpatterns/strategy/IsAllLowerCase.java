package designpatterns.strategy;

public class IsAllLowerCase implements Validator
{
    @Override
    public boolean apply( String value )
    {
        return value.matches( "[a-z]+" );
    }
}
