package fp_prez.extra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Demo of using some useful methods (like Map.merge(), nested collectors)
 * to write code in a more declarative way (= a first step towards functional way)
 * <p>
 * JAVA standard version: using Streams, Collectors..
 * <p>
 * See: https://developer.ibm.com/articles/j-java8idioms1/
 */
public class WordCount_Streams
{
    public static void main( String[] args )
    {

        System.out.println( "JAVA-STREAMS:" );

        Map<String, Integer> words1 = countWords( "some article here about Java functional style etc" );
        Map<String, Integer> words2 = countWords( "some other article about Java Scala and other stuff etc" );
        Map<String, Integer> words3 = countWords( "another article with extra info on functional programming etc" );

        System.out.println( "words1= " + words1 + "\nwords2= " + words2 + "\nwords3= " + words3 );

        //======== MERGE the 2 counter maps ========//

        //1) Merging 2 maps:
        Map<String, Integer> merged12 = Utils.mergeWithSum( words1, words2 ); //put the logic put in a reusable method, for later..

        System.out.println( "\nmerged 1-2: result: " + merged12 );

        //2) Merging more maps (more generic):
        Map<String, Integer> merged =
                Stream.of( words1, words2, words3 ) //Stream<Map<String,Integer>>
                      .reduce( new TreeMap<>( ), Utils::mergeWithSum ); //use the defined method for merging 2

        System.out.println( "merged 1-3 (reduce): result: " + merged );

        //======== PRINTING the results ========//

        //a) Print with forEach
        System.out.print( "\nprint with foreach: " );
        words1.forEach( ( k, v ) ->
                                System.out.print( k + " (" + v + "), " ) ); //notice the part: forEach( (k,v)->...
        System.out.println( );

        //b) Using separate steps (convert to string, later print):
        //Java: must use entrySet, stream(), collect()..
        String joined1 = merged
                .entrySet( )
                .stream( )
                .map( e -> e.getKey( ) + " (" + e.getValue( ) + ")" )
                .collect( joining( ", " ) );

        System.out.println( "joined string: " + joined1 );

        //c) With formatting of entry moved to a separate method:
        String joined2 = merged
                .entrySet( )
                .stream( )
                .map( Utils::entryToString )
                .collect( joining( ", " ) );

        //d) With other operations applied before print - like custom sorting: first descending by word count, then ascending by word

        //define first a custom comparator (by combining some predefined ones)
        Comparator<Map.Entry<String, Integer>> descByValueThenAscByKey =
                Comparator
                        .comparing( Map.Entry<String, Integer>::getValue ).reversed( )
                        .thenComparing( Map.Entry::getKey );

        //use it:
        String joined3 = merged
                .entrySet( )
                .stream( )
                .sorted( descByValueThenAscByKey )
                .map( Utils::entryToString )
                .collect( joining( ", " ) );

        System.out.println( "joined string (sorted): " + joined3 );
    }

    /**
     * Splits text to words, and counts the occurrences for each one, using groupingBy() collector
     * JAVA: we have no functions like mapValues, etc..; but we have cascading collectors at least
     */
    private static Map<String, Integer> countWords( String text )
    {
        /*
        //without cascading collectors:
        Map<String, List<String>> groupedWords =
                Arrays.stream(text.toLowerCase().split("\\s+")) //array to Stream
                        .collect(Collectors.groupingBy(w -> w));
        return groupedWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
         */

        //With cascading collectors (for grouping and summing in one stream):
        return Arrays
                .stream( text.toLowerCase( ).split( "\\s+" ) ) //array to Stream
                .collect(
                        Collectors.groupingBy(
                                w -> w, //classifier - results in Map<String, List<String>>
                                Collectors.summingInt( word -> 1 ) ) ); //downstream (other collectors)
    }

    //collection of utility (pure) functions
    static class Utils
    {

        /**
         * Merge 2 maps of word-counter pairs (summing the counters of same key)
         * <p>
         * Java: done using the Map.merge() method - a more declarative, higher level method.
         * Problem: it mutates one of the maps, not very functional - so extra work to avoid that!
         */
        static Map<String, Integer> mergeWithSum( Map<String, Integer> m1, Map<String, Integer> m2 )
        {

            Map<String, Integer> result = new TreeMap<>( m1 ); //make copy of 1st map, with copy constructor

            m2.forEach( ( k, v ) ->                        //nice syntax for iterating over key+value
                                result.merge( k, v, Integer::sum ) );  //mutates result map! (adding contents of 2nd map)

            return result;
        }

        //formats a Map.Entry in a specific way for display
        static String entryToString( Map.Entry<String, Integer> e )
        {
            return e.getKey( ) + " (" + e.getValue( ) + ")";
        }
    }
}