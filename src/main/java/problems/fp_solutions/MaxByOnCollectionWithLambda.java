package problems.fp_solutions;

import problems.fp.Person;

import java.util.*;
import java.util.function.Function;

/**
 * Problem related to Higher-Order functions
 * <p>
 * Write a generic method maxBy() which checks the elements of a Collection
 * (received as input), and finds the element for which a given function
 * returns the maximum numeric value, compared to rest of elements.
 * <p>
 * (the function should be received as a lambda parameter, and your method
 * should use it internally to compute a numeric value for each element,
 * find the element with max value, and then return the ELEMENT, not its numeric value)
 * <p>
 * Try to make it as generic as you can (hint: may use generics too),
 * so that we can use it the for all kind of element types and lambdas, like:
 * maxBy(someStrings, p -> p.length()     ==> returns longest String..
 * maxBy(personsList, p -> p.getAge())    ==> returns the oldest person (if found..)
 * maxBy(personsList, p -> p.getHeight()) ==> returns the tallest person..
 */
public class MaxByOnCollectionWithLambda
{

    public static void main( String[] args )
    {
        //Testing the maxBy() method:

        //works on ints...
        List<Integer> ints = Arrays.asList( 5, 3, 8, 2, 9 );
        System.out.println( "max: " + maxBy( ints, x -> x ) );
        System.out.println( "min: " + maxBy( ints, x -> -x ) );

        //... and on doubles...
        List<Double> doubles = Arrays.asList( 0.1, 0.5, -2.3, 2.777 );
        System.out.println( "max: " + maxBy( doubles, d -> d ) );

        //... and on any other custom type...
        List<Person> persons = Arrays.asList(
                new Person( 1111, "Ionel", 19, 180 ),
                new Person( 2222, "Ana", 22, 167 ),
                new Person( 3333, "George", 14, 152 ),
                new Person( 4444, "Maria", 31, 160 )
        );

        //returns no value for empty list
        List<Person> emptyList = new ArrayList<>( );
        System.out.println( "\noldest (on empty): " + maxBy( emptyList, Person::getAge ) );

        //with various functions:
        System.out.println( "\noldest: " + maxBy( persons, Person::getAge ) );
        System.out.println( "longest name: " + maxBy( persons, p -> p.getName( ).length( ) ) );
        System.out.println( "max cnp value: " + maxBy( persons, Person::getCnp ) );
        System.out.println( "tallest: " + maxBy( persons, Person::getHeight ) );

        //working with Optional values:
        maxBy( persons, p -> -p.getHeight( ) ) //using '-' for reverse ordering
                                               .ifPresent( p ->             //unwrapping the value of Optional
                                                                   System.out.println( "\nshortest: " + p ) );

        //extract part of Optional (map to other value)
        maxBy( persons, Person::getHeight )
                .map( Person::getName )
                .ifPresent( n -> System.out.println( "\nname of tallest: " + n ) );
    }

    /**
     * The maxBy method (a functional implementation)
     *
     * @param <T>          - the generic type of elements in the collection (we want to support any type)
     * @param elements     - the collection of elements (of type T)
     * @param toNumberFunc - function deriving a Number from any element of collection (we use Number here to support all functions which return either an int/long/double.. as Number is the base class for all primitive numeric types)
     * @return - an Optional which  contains either the element (of type T) for which the func() returns the max value,
     * or empty if a max cannot be determined (like for empty collection)
     */
    private static <T> Optional<T> maxBy( Collection<T> elements,
                                          Function<T, Number> toNumberFunc )
    {
        return elements
                .stream( )
                .reduce( ( t1, t2 ) -> maxByOf( t1, t2, toNumberFunc ) ); //relying here on a separate combiner function
    }

    /**
     * Helper maxBy function, knows to combine just 2 elements of generic type T,
     * by choosing the one with the max numeric value (once the given conversion function is applied)
     */
    private static <T> T maxByOf( T t1, T t2, Function<T, Number> toNumber )
    {
        return toNumber.apply( t1 ).doubleValue( ) > toNumber.apply( t2 ).doubleValue( ) ? t1 : t2;
    }

    /**
     * A more iterative version of the method, give just for comparision.
     * (note that is: longer, more complex, easier to miss some bugs..)
     */
    private static <T> Optional<T> maxByIter( Collection<T> elements,
                                              Function<T, Number> toNumberFunc )
    {
        //start with an empty max
        Optional<T> maxElem = Optional.empty( );
        double      maxVal  = Double.NEGATIVE_INFINITY;

        //go over each element
        for( T elem : elements )
        {
            //compute its numeric value by applying the given lambda (and we also convert it to Double
            double val = toNumberFunc.apply( elem ).doubleValue( );

            //if numeric value is biggest found until now, remember the value and also the element
            if( val > maxVal )
            {
                maxVal = val;
                maxElem = Optional.of( elem );
            }
        }

        //return just the max element (either a found one, or empty if collection was empty)
        return maxElem;
    }
}