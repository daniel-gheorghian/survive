package fp_prez.using_optional;

public class WithNull
{

    public static void main( String[] args )
    {
        Dog    dog1  = new Dog( "husky" );
        Person owner = new Person( "Ion" );
        owner.setAddress( "Iasi" );
        dog1.setOwner( owner );
        printOwnerNameAddress( dog1 );

        Dog dog2 = new Dog( "chow chow" );
        printOwnerNameAddress( dog2 );
    }

    private static void printOwnerNameAddress( Dog dog1 )
    {
        System.out.println( "Dog belongs to: " + dog1.owner.name +
                            ", lives at address: " + dog1.owner.name );
    }

    static class Person
    {
        //these can be null
        private String name;
        private String address;

        Person( String name )
        {
            this.name = name;
        }

        String getName( )
        {
            return name;
        }

        String getAddress( )
        {
            return address;
        }

        void setAddress( String address )
        {
            this.address = address;
        }
    }

    static class Dog
    {
        private String breed;
        private Person owner;

        Dog( String breed )
        {
            this.breed = breed;
        }

        String getBreed( )
        {
            return breed;
        }

        Person getOwner( )
        {
            return owner;
        }

        void setOwner( Person owner )
        {
            this.owner = owner;
        }
    }
}
