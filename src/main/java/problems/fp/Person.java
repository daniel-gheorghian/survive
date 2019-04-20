package problems.fp;

/**
 * A simple demo data class (usable for tests)
 */
public class Person
{
    private final int    cnp;
    private final String name;
    private final int    age;
    private final int    height;

    public Person( int cnp, String name, int age, int height )
    {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.height = height;
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

    public int getHeight( )
    {
        return height;
    }

    @Override
    public String toString( )
    {
        return "Person{" + "cnp=" + cnp + ", name='" + name + '\'' + ", age=" + age + ", height=" + height + '}';
    }
}
