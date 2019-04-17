package designpatterns.commandWithLambda;

public class Stock
{
    private String code;

    public Stock( String code, double value )
    {
        this.code = code;
        this.value = value;
    }

    private double value;

    public void buy( int quantity )
    {
        System.out.println( "Buying stock: code: " + code + ", value: " + value + ", in quantity: " + quantity );
    }

    public void sell( int quantity )
    {
        System.out.println( "Selling stock: code: " + code + ", value: " + value + ", in quantity: " + quantity );
    }
}
