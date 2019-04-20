package fp_prez.using_optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DogPerson_WithOptional
{

    public static void main( String[] args )
    {
        Optional<Person> p1 = Person.build( "" );
        Optional<Person> p2 = Person.build( "Ion" );
        Optional<Person> p3 = Person.build( "Ana", "" );
        Optional<Person> p4 = Person.build( "Maria", "Iasi" );

        System.out.println( "\np1: " + p1 );
        System.out.println( "p2: " + p2 );
        System.out.println( "p3: " + p3 );
        System.out.println( "p4: " + p4 );

        Optional<Dog> d0 = Dog.build( "" );
        Optional<Dog> d1 = Dog.build( "husky", p1.orElse( null ) );
        Optional<Dog> d2 = Dog.build( "chow chow", p2.orElse( null ) );
        Optional<Dog> d3 = Dog.build( "buldog", p3.orElse( null ) );
        Optional<Dog> d4 = Dog.build( "dalmatian", p4.orElse( null ) );

        System.out.println( "\nd0: " + d0 );
        System.out.println( "d1: " + d1 );
        System.out.println( "d2: " + d2 );
        System.out.println( "d3: " + d3 );
        System.out.println( "d4: " + d4 + "\n" );

        d0.ifPresent( DogPerson_WithOptional::printOwnerNameAddress );
        d1.ifPresent( DogPerson_WithOptional::printOwnerNameAddress );
        d2.ifPresent( DogPerson_WithOptional::printOwnerNameAddress );
        d3.ifPresent( DogPerson_WithOptional::printOwnerNameAddress );
        d4.ifPresent( DogPerson_WithOptional::printOwnerNameAddress );

        //working with collections/streams with Optional values
        List<Dog> dogs =
                Stream.of( d0, d1, d2, d3, d4 )
                      .flatMap( DogPerson_WithOptional::optToStream ) //annoying: must translate Optional to Stream, then flatten
                      .collect( toList( ) );
        System.out.println( "\nnon empty dogs: " + dogs );

        List<Person> owners =
                dogs.stream( )
                    .map( Dog::getOwner )
                    .flatMap( DogPerson_WithOptional::optToStream )
                    .collect( toList( ) );
        System.out.println( "non empty dog owners: " + owners );
    }

    //needed because Optional.toStream() is missing in Java 8 (added later..)
    static <T> Stream<T> optToStream( Optional<T> opt )
    {
        return opt.map( Stream::of ).orElse( Stream.empty( ) );
    }

    static void printOwnerNameAddress( Dog dog )
    {
        System.out.println(
                "Dog: breed " + dog.getBreed( ) +
                ", belongs to: " + dog.getOwner( ).map( Person::getName ).orElse( "?" ) +
                ", lives at address: " + dog.getOwner( ).flatMap( Person::getAddress ).orElse( "?" ) );
    }

    static class Person
    {
        //prefer immutable fields
        private final String name; //mandatory (not null/empty)
        private final String address; //optional (nullable/empty)

        //private ctor, use build() method instead
        private Person( String name, String address )
        {
            this.name = name;
            this.address = address;
        }

        //may return name as is, as is never null/empty
        String getName( )
        {
            return name;
        }

        //address may be missing (null or empty), return it as Optional!
        Optional<String> getAddress( )
        {
            return Optional.ofNullable( address ).filter( s -> !s.isEmpty( ) );
        }

        @Override
        public String toString( )
        {
            return "Person{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
        }

        //factory methods
        static Optional<Person> build( String name )
        {
            return build( name, null );
        }

        //name must be valid, or else this returns no person!
        static Optional<Person> build( String name, String address )
        {
            return ( name == null || name.isEmpty( ) ) ?
                   Optional.empty( ) :
                   Optional.of( new DogPerson_WithOptional.Person( name, address ) );
        }
    }

    static class Dog
    {
        private final String breed; //mandatory (not null/empty)
        private final Person owner; //optional (nullable)

        private Dog( String breed, Person owner )
        {
            this.breed = breed;
            this.owner = owner;
        }

        String getBreed( )
        {
            return breed;
        }

        Optional<Person> getOwner( )
        {
            return Optional.ofNullable( owner );
        }

        @Override
        public String toString( )
        {
            return "Dog{" + "breed='" + breed + '\'' + ", owner=" + owner + '}';
        }

        //factory methods
        static Optional<Dog> build( String breed )
        {
            return build( breed, null );
        }

        static Optional<Dog> build( String breed, Person owner )
        {
            return ( breed == null || breed.isEmpty( ) ) ?
                   Optional.empty( ) :
                   Optional.of( new Dog( breed, owner ) );
        }
    }
}
