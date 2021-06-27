import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Maximum Path Sum I & II
 * Difficulty: ***.5
 */
public class ProjectEuler18 {
	static List<List<Integer>> array;
	
	/**
	 * maxPathSumI method:
	 * 		In order to compute the longest sum, approaching the problem from the top down to the bottom
	 * requires backtracking to the where a longer path is found
	 * 		Approaching from the bottom up has the advantage that longest sum is guaranteed 
	 * without backtracking
	 * 
	 * 	Provided that the longest sum path is UNIQUE
	 * 
	 * @return the maximumPathSum, which is computed from the bottom up
	 */
	public static int maxPathSumI() {
		
		for(int i = array.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				array.get(i).set( j, array.get(i).get(j) + Math.max(array.get(i + 1).get(j), array.get(i + 1).get(j + 1)) );
			}
		}
		return array.get(0).get(0);
	}

	public static void main(String[] args) {
		try { 
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			int numOfTestCase = Integer.parseInt(input.readLine());
			while (numOfTestCase-- > 0) {
				array = new ArrayList<>();
				int numOfRows = Integer.parseInt(input.readLine());
				
				for (int i = 0; i < numOfRows; i++) {
					ArrayList<Integer> newRow = new ArrayList<>();
					
					String[] numbers = input.readLine().split(" ");
					for (int k = 0; k < numbers.length; k++) {
						
						int value = Integer.valueOf(numbers[k]);
						newRow.add(value);
						
					}
					array.add(newRow);
				}
				output.append(String.valueOf(maxPathSumI())).append("\n");
	
			}
			output.flush();
			input.close();
			output.close();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
