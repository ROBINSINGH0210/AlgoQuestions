package bitwiseOperation;

public class MultiplicationUsingShiftOperator {

	static int multiply(int n, int m)
    { 
        int ans = 0, count = 0;
        while (m > 0)
        {
            // check for set bit and left 
            // shift n, count times
            if (m % 2 == 1)             
                ans += n << count;
     
            // increment of place 
            // value (count)
            count++;
            m /= 2;
        }
         
        return ans;
    }
     
    // Driver code
    public static void main (String[] args)
    {
        int n = 5, m = 6;
         
        System.out.print( multiply(n, m) );
    }

}
