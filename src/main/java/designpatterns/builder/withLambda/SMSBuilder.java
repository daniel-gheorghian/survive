package designpatterns.builder.withLambda;

public interface SMSBuilder
{
    ContentBuilder sender( SMSSender sender );
}
