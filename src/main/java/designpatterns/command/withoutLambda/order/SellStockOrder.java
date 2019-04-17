package designpatterns.command.withoutLambda.order;

import designpatterns.command.withoutLambda.Stock;

public class SellStockOrder implements Order
{
    private Stock stock;
    private int   quantity;

    public SellStockOrder( Stock stock, int quantity )
    {
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute( )
    {
        stock.sell( quantity );
    }
}
