package problems.fp;

/**
 * Problem related to Higher-Order functions
 *
 * Write a generic method maxBy() which checks the elements of a Collection
 * (received as input), and finds the element for which a given function
 * returns the maximum numeric value, compared to rest of elements.
 *
 * (the function should be received as a lambda parameter, and your method
 * should use it internally to compute a numeric value for each element,
 * find the element with max value, and then return the ELEMENT, not its numeric value)
 *
 * Try to make it as generic as you can (hint: may use generics too),
 * so that we can use it the for all kind of element types and lambdas, like:
 *   maxBy(someStrings, p -> p.length()     ==> returns longest String..
 *   maxBy(personsList, p -> p.getAge())    ==> returns the oldest person (if found..)
 *   maxBy(personsList, p -> p.getHeight()) ==> returns the tallest person..
 */
public class MaxByFunction
{
    /**
     * THE METHOD!
     *
     * Question: what should it signature be? what input params are needed, what to return back..
     */

    /* static ?? maxBy( ??, ??)
    {
      ...
    }
    */

    //some manual tests
    public static void main( String[] args )
    {
        //TODO: uncomment this after you completed maxBy() function
        /*
        //Should works on ints...
        List<Integer> ints = Arrays.asList( 5, 3, 8, 2, 9 );
        System.out.println( "max: " + maxBy( ints, x -> x ) );

        //... and on doubles...
        List<Double> doubles = Arrays.asList( 0.1, 0.5, -2.3, 2.777 );
        System.out.println( "max: " + maxBy( doubles, d -> d ) );

        //... and on any other custom type...
        List<Person> emptyList = new ArrayList<>( );
        System.out.println( "\noldest (on empty): " + maxBy( emptyList, Person::getAge ) );

        List<Person> persons = Arrays.asList(
                new Person( 1111, "Ionel", 19, 180 ),
                new Person( 2222, "Ana", 22, 167 ),
                new Person( 3333, "George", 14, 152 ) );
        //with various functions:
        System.out.println( "\noldest: " + maxBy( persons, Person::getAge ) );
        System.out.println( "longest name: " + maxBy( persons, p -> p.getName( ).length( ) ) );
        System.out.println( "tallest: " + maxBy( persons, Person::getHeight ) );
        */
    }

}
