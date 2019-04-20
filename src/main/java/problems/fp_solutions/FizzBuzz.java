package problems.fp_solutions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Functional FizzBuzz
 * <p>
 * The FizzBuzz problem: having a list of numbers, print for each of them a value,
 * according to these rules:
 * - if number can be divided by 3 -> 'fizz'
 * - if divides by 5               -> 'buzz'
 * - if divides by both 3 and 5    -> 'fizzbuzz'
 * - otherwise -> the number itself
 * <p>
 * You have the iterative solution for it.
 * Refactor it to use a more functional style!
 * <p>
 * (hint: may work with an IntStream, also see methods IntStream.rangeClosed(), mapToObj()...)
 * <p>
 * Question: how can you structure your code to make it easier testable by unit tests?..
 */
public class FizzBuzz
{

    public static void main( String[] args )
    {
        fizzBuzz1( 30 );
    }

    //--- 1) Iterative version ---//
    static void fizzBuzz1( int n )
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

    //--- 2) Version using Streams ---// //Q: is it functional? (yet)
    static void fizzBuzz2( int n )
    {
        IntStream.rangeClosed( 1, n )
                 .mapToObj( i -> {
                     if( i % 15 == 0 )
                     {
                         return "fizzbuzz";
                     }
                     if( i % 3 == 0 )
                     {
                         return "fizz";
                     }
                     if( i % 5 == 0 )
                     {
                         return "buzz";
                     }
                     return String.valueOf( i );
                 } )
                 .forEach( System.out::println );
    }

    //--- 3) Version separating some functionality ---//
    static void fizzBuzz3( int n )
    {
        IntStream.rangeClosed( 1, n )
                 .mapToObj( FizzBuzz::intToFizzBuzz )
                 .forEach( System.out::println );
    }

    static String intToFizzBuzz( int i )
    {
        if( i % 15 == 0 )
        {
            return "fizzbuzz";
        }
        if( i % 3 == 0 )
        {
            return "fizz";
        }
        if( i % 5 == 0 )
        {
            return "buzz";
        }
        return String.valueOf( i );
    }

    //--- 4) Version separating also the side effects (printing values) ---//
    //Note that only the 'foreach(println)' remains not covered by tests - but is simple enough to reason about it that is ok..
    static void fizzBuzz4( int n )
    {
        fizzBuzzList( n )
                .forEach( System.out::println ); //do IO -> side-effects only here.
    }

    static List<String> fizzBuzzList( int n )
    {
        return IntStream.rangeClosed( 1, n )
                        .mapToObj( FizzBuzz::intToFizzBuzz )
                        .collect( Collectors.toList( ) );
    }


    /*
    //---JUnit tests ---//
    @Test
    public void testFB() {
        //How would you test these?...
        //- fizzBuzz1 ?
        //- fizzBuzz2 ?
        //- fizzBuzz3 ?
    }

    @Test
    public void testIntToFizzBuzz() {
        assertEquals("2", intToFizzBuzz(2));
        assertEquals("fizz", intToFizzBuzz(6));
        assertEquals("buzz", intToFizzBuzz(10));
        assertEquals("fizzbuzz", intToFizzBuzz(45));
    }

    @Test
    public void testFizzBuzzList() {
        //check size:
        assertEquals(17, fizzBuzzList(17).size());

        //check first/last:
        assertEquals("1", fizzBuzzList(42).get(0));
        assertEquals("fizz", fizzBuzzList(42).get(41));

        //check all elems:
        assertEquals(
                Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"),
                fizzBuzzList(15));
    }
    */
}
