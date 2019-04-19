package designpatterns.command.withoutLambda.order;

import designpatterns.command.model.Stock;

public class BuyStockOrder implements Order
{
    private Stock stock;
    private int   quantity;

    public BuyStockOrder( Stock stock, int quantity )
    {
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute( )
    {
        stock.buy( quantity );
    }
}
