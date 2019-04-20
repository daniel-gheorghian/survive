package problems.fp;

import java.util.Set;

/**
 * Using stream operations:
 *
 * Given 2 instances of Set<String>, write 3 methods to compute
 * the intersection, union, and difference between them.
 * Try to implement them in a functional style, using just stream operations!
 *
 * (hint: for union you may need Stream.concat or flatMap)
 *
 * Questions:
 * 1) Can you make it more generic? (so it will work not only for Strings)
 * how much of your code you need to change?
 *
 *  2) Can you write some code (in main()) method which will compute in one line
 * the union of 3 of more Sets? (hint: see reduce() operation)
 */
public class SetOperationsWithStreams
{

    private static Set<String> intersection( Set<String> set1, Set<String> set2 )
    {
        //TODO
        return null;
    }

    private static Set<String> difference( Set<String> set1, Set<String> set2 )
    {
        //TODO
        return null;
    }

    private static Set<String> union( Set<String> set1, Set<String> set2 )
    {
        //TODO
        return null;
    }

    //some manual tests
    public static void main( String[] args )
    {
        //TODO: uncomment this when ready to test
        /*
        Set<String> set1 = new HashSet<>(Arrays.asList("aa", "bb", "cc"));
        Set<String> set2 = new HashSet<>(Arrays.asList("bb", "cc", "dd"));
        Set<String> set3 = new HashSet<>(Arrays.asList("dd", "EE", "FF"));
        System.out.println("set1: " + set1 + "\nset2: " + set2 + "\nset3: " + set3);

        System.out.println("\nintersection: " + intersection(set1, set2));
        System.out.println("diff c1-c2: " + difference(set1, set2));
        System.out.println("diff c2-c1: " + difference(set2, set1));
        System.out.println("union: " + union(set1, set2));

        //works also on other types?
        Set<Integer> intSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> intSet2 = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        System.out.println("int intersect: " + intersection(intSet1, intSet2));
        //System.out.println("int-String intersect?: " + intersection(set1, intSet2)); //this should NOT compile!

        //union of more than 2 sets?
        //Set<String> union13 = ?? //some code with reduce() here?..
        //System.out.println("union(1,2,3): " + union13);
        */
    }
}
