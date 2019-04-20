package fp_prez.fp_principles;

public class ImmutableDemo
{

    public class Person
    {

        //immutable - use final!
        private final int    cnp; //mandatory
        private final String name; //optional on build

        //mutable state
        private int age = 0;

        public Person( int cnp, int age )
        {
            this( cnp, "unknown", age );
        }

        public Person( int cnp, String name, int age )
        {
            this.cnp = cnp;
            this.name = name;
            this.age = age;
        }

        public int getCnp( )
        {
            return cnp;
        }

        public String getName( )
        {
            return name;
        }

        public int getAge( )
        {
            return age;
        }

        public void setAge( int age )
        {
            this.age = age;
        }
    }
}
