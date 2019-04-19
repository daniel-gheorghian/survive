package designpatterns.factory.withLambda;

import designpatterns.factory.model.Bond;
import designpatterns.factory.model.Loan;
import designpatterns.factory.model.Product;
import designpatterns.factory.model.Stock;

@FunctionalInterface
public interface ProductFactory
{
    static ProductFactory of( ProductCreators creator )
    {
        return creator.constructor;
    }

    Product create( String code );

    enum ProductCreators
    {
        BOND( Bond::new ),
        LOAN( Loan::new ),
        STOCK( Stock::new );

        private final ProductFactory constructor;

        ProductCreators( ProductFactory constructor )
        {
            this.constructor = constructor;
        }
    }
}
