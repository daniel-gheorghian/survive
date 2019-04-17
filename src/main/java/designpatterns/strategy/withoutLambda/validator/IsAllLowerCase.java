package designpatterns.strategy.withoutLambda.validator;

public class IsAllLowerCase implements Validator
{
    @Override
    public boolean apply( String value )
    {
        return value.matches( "[a-z]+" );
    }
}
