import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * Factorial Digit Sum
 * Difficulty: **.5;
 */

public class ProjectEuler20 {
	
	/*
	 * Factorial method using iterative method 
	 */
	
	public static BigInteger factorial (int N) {
		BigInteger result = new BigInteger("1");
		while (N > 1) {
			BigInteger currN = BigInteger.valueOf(N);
			result = result.multiply(currN);
			N--;
		}
		
		return result;
	}

	public static void main(String[] args) {
		try { 
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int numOfTestCase = Integer.parseInt(input.readLine());
			while(numOfTestCase-- > 0) {
				int N = Integer.parseInt(input.readLine());
				
				long sumDigit = 0;
				BigInteger resultOfFactN = factorial(N);
				String[] stringOfDigits = String.valueOf(resultOfFactN).split("");
				
				for (String digit : stringOfDigits) {
					sumDigit += Integer.valueOf(digit);
				}
				
				output.append(String.valueOf(sumDigit)).append("\n");
			}
			
			output.flush();
			output.close();
			input.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
