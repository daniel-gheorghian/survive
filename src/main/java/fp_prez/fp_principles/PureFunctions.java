package fp_prez.fp_principles;

public class PureFunctions
{

    public class ObjectWithPureFunction
    {

        public int sum( int a, int b )
        {
            return a + b;
        }
    }

    public class ObjectWithNonPureFunction
    {
        private int value = 0;

        public int add( int nextValue )
        {
            this.value += nextValue;
            return this.value;
        }
    }
}
