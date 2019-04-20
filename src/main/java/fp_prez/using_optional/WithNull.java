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
        System.out.println( "Dog belongs to: " + dog1.owner.name + ", lives at address: " + dog1.owner.name );
    }

    static class Person
    {
        private String name;
        private String address;

        Person( String name )
        {
            this.name = name;
        }

        public String getName( )
        {
            return name;
        }

        public String getAddress( )
        {
            return address;
        }

        public void setAddress( String address )
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

        public String getBreed( )
        {
            return breed;
        }

        public Person getOwner( )
        {
            return owner;
        }

        public void setOwner( Person owner )
        {
            this.owner = owner;
        }
    }
}
