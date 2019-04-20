package fp_prez.fp_principles;

public class NoState
{

    public class CalculatorWithNoState
    {
        public int sum( int a, int b )
        {
            return a + b;
        }
    }

    public class CalculatorWithState
    {
        private int initVal = 5;

        public int sum( int a )
        {
            return initVal + a;
        }
    }
}
