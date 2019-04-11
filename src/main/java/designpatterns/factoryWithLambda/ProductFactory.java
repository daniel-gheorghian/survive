package designpatterns.factoryWithLambda;

import designpatterns.factory.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ProductFactory
{
    private Map<ProductType, Supplier<Product>> creators = new HashMap<>( );

    {
        creators.put( ProductType.BOND, Bond::new );
        creators.put( ProductType.LOAN, Loan::new );
        creators.put( ProductType.STOCK, Stock::new );

        creators = Collections.unmodifiableMap( creators );
    }

    public Product createProduct( ProductType productType )
    {
        return Optional.ofNullable( creators.get( productType ) )
                       .map( Supplier::get )
                       .orElseThrow( IllegalArgumentException::new );
    }
}
