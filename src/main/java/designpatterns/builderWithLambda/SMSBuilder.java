package designpatterns.builderWithLambda;

public interface SMSBuilder
{
    ContentBuilder sender( SMSSender sender );
}
