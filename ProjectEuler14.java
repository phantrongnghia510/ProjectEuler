import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


/*
 * Longest Collatz Sequence
 * Difficulty: ****
 * Involves: Memoization and Dynamic Programming concepts
 */

public class ProjectEuler14 {
	static final int MAX_CAPACITY = 5000000;
	//Keep the length of the Collatz sequence from number i to 1
	static int[] collatzLength = new int[MAX_CAPACITY + 1];
	
	
	public static int computeCollatzLength(long number) {
		
		Stack<Long> currNumInCollatzSequence = new Stack<>();
		int distanceCount = 0;
		
		while (number > 1) {
			if (number <= MAX_CAPACITY && collatzLength[(int)number] != 0) {
				/*
				 * If the Collatz length for the current number has already found,
				 * we stop iterating and assign the distance with the length of sequence 
				 * that has already found.
				 * We minus 1 because we push the 2 ends of the sequence where only 1 should be counted
				 */
				
				distanceCount = collatzLength[(int)number] - 1;
				break;
			}
			
			number = (number % 2 == 0) ? (number / 2) : (number * 3 + 1);
			currNumInCollatzSequence.push(number);
		}
		
		while (! currNumInCollatzSequence.empty()) {
			number = currNumInCollatzSequence.pop();
			distanceCount++;
			
			if (number <= MAX_CAPACITY) {
				collatzLength[(int)number] = distanceCount;
			}
			
		}
		return distanceCount;
	}
	
	public static void main (String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			int numOfTestCase = Integer.parseInt(input.readLine());
			
			int currLength = 0;
			int currMaxLength = 1;
			int currNumWithMaxLength = 1;
			int[] longestCollatzSequence = new int[MAX_CAPACITY + 1];
		
			for (int i = 1; i <= MAX_CAPACITY; i++) {
				currLength = computeCollatzLength(i);
				
				if (currLength >= currMaxLength) {
					currMaxLength = currLength;
					currNumWithMaxLength = i;
				}
				
				longestCollatzSequence[i] = currNumWithMaxLength;
				
			}
			
			while (numOfTestCase-- > 0) {
				int startingNum = Integer.parseInt(input.readLine());
				output.append(String.valueOf(longestCollatzSequence[startingNum])).append("\n");
			}
			
			output.flush();
			output.close();
			input.close();
			
		}
		catch(Exception E) {
			System.out.println(E);
		}
		
	}
}
	
