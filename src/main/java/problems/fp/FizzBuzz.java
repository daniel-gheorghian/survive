package problems.fp;

/**
 * Functional FizzBuzz
 *
 * The FizzBuzz problem: having a list of numbers, print for each of them a value,
 * according to these rules:
 * - if number can be divided by 3 -> 'fizz'
 * - if divides by 5               -> 'buzz'
 * - if divides by both 3 and 5    -> 'fizzbuzz'
 * - otherwise -> the number itself
 *
 * You have the iterative solution for it.
 * Refactor it to use a more functional style!
 *
 * (hint: may work with an IntStream, also see methods IntStream.rangeClosed(), mapToObj()...)
 *
 * Question: how can you structure your code to make it easier testable by unit tests?..
 */
public class FizzBuzz
{

    //some manual tests
    public static void main( String[] args )
    {
        fizzBuzzIterativ( 30 );
        fizzBuzzFunctional( 30 ); //should print same results..
    }

    //--- 1) Iterative version ---//
    static void fizzBuzzIterativ( int n )
    {
        for( int i = 1; i <= n; i++ )
        {
            if( i % 15 == 0 )
            {
                System.out.print( "fizzbuzz " );
            }
            else if( i % 3 == 0 )
            {
                System.out.print( "fizz " );
            }
            else if( i % 5 == 0 )
            {
                System.out.print( "buzz " );
            }
            else
            {
                System.out.print( i + " " );
            }
        }
    }

    //--- 2) Functional Version ---//
    static void fizzBuzzFunctional( int n )
    {
        //TODO - your code here!
    }
}
