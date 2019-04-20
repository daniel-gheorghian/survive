package problems.fp;

/**
 * A simple demo data class (usable for tests)
 */
class Person
{
    private final int    cnp;
    private final String name;
    private final int    age;
    private final int    height;

    Person( int cnp, String name, int age, int height )
    {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    int getCnp( )
    {
        return cnp;
    }

    String getName( )
    {
        return name;
    }

    int getAge( )
    {
        return age;
    }

    int getHeight( )
    {
        return height;
    }

    @Override
    public String toString( )
    {
        return "Person{" + "cnp=" + cnp + ", name='" + name + '\'' + ", age=" + age + ", height=" + height + '}';
    }
}
