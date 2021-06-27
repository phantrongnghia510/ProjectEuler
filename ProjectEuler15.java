import java.math.BigInteger;
import java.util.*;
//Lattice path
/*
 * Difficulty: ***
 *  _ _ _ _ _
 * | | | | | |
 *  _ _ _ _ _
 *  
 * | | | | | |
 *  _ _ _ _ _
 *  
 * 
 * For an N x M grid starting from the top left of the grid traveling to the bottom right of the grid 
 * involves N steps right and M steps down, for the total of N + M steps
 * 																		   (   N   )
 * Choosing either N steps right or M steps down, the rest is the other so [	   ]
 *																		   ( N + M )
 */
public class ProjectEuler15 {
    /*
     * Solution 1 (1)
     * Factorial involves really big number that exceeds the maximum capacity of the largest long integer
	 * Using BigInteger class is recommended : add, subtract, divide, mod, multiply, valueOf, ...
     */
	
//    public static BigInteger factorial(int n) {
//        BigInteger product = new BigInteger("1");
//        while (n > 1) {
//            product = product.multiply(BigInteger.valueOf(n));
//            n--;
//        }
//        return product;
//    }
    
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
			int numOfTestCase = scnr.nextInt();
			
			//Solution 2 (1)
		    /*
		     * Dynamic programming approach
		     */
		    int x = 501;
		    int y = 501;
		    int[][] dp = new int[x][y];
		    for (int j = 0; j < x; j++ ) {
		    	dp[j][0] = 1;
		    }
		    for (int k = 0; k < y; k++) {
		    	dp[0][k] = 1;
		    }
		    
		    for (int j = 1; j < x; j++) {
		    	for (int k = 1; k < y; k++) {
		    		dp[j][k] = (dp[j - 1][k] + dp[j][k - 1]) % (1000000000 + 7);
		    	}
		    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		    
			for (int i = 0; i < numOfTestCase; i++) {
			    int n = scnr.nextInt();
			    int m = scnr.nextInt();
			    /*
			     * Solution 1 (2)
			     */
//			    System.out.println( 
//			    ( factorial(m+n).divide( (factorial(n).multiply(factorial(m)) ) )  
//			    ).mod( BigInteger.valueOf((1000000000 + 7)) ) );
			    
 /////////////////////////////////////////////////////////////////////////////////////////////////////////
			    /*
			     * Solution 2 (2)
			     */
			    System.out.println(dp[n][m]);
			    
			}
		}
        catch(Exception E) {
        	System.out.println(E.getMessage());
        }
       
    }
}
