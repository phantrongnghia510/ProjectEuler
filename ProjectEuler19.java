import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * Counting [Sun]days for the given range of time
 * Difficulty: ***.75;
 */

public class ProjectEuler19 {
	static final int SUNDAY = 1;
	/*
	 * This method is not necessary
	 */
	public static void validateInput(long[][] dates) {
		if (overDate(dates)) {
			swap(dates);
		}
	}
	///////////////////////////////////////////////////////////
	
	public static boolean overDate(long[][] dates) {
		if (dates[0][0] > dates[1][0]) {
			return true;
		} else if (dates[0][0] == dates[1][0]){
			if (dates[0][1] > dates[1][1]) {
				return true;
			} else if (dates[0][1] == dates[1][1]) {
				if (dates[0][2] > dates[1][2]) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * This method is not necessary
	 */
	public static void swap(long[][] dates) {
		long[] temp = new long[3];
		temp = dates[0];
		dates[0] = dates[1];
		dates[1] = temp;
	}
	///////////////////////////////////////////////////////////

	
	/**
	 * verifyDate method using Zeller's Congruence to check if the date
	 * in the argument is Sunday (output of the formula is 1)
	 * @param year
	 * @param month
	 * @param day (after the first check the other day is automatically 1 because we set it)
	 * @return true if output of the formula is 1, false otherwise
	 */
	public static boolean verifyDate (long year, long month, long day) {
		int h;
		long q = day;
		long m = month;
		long K = year % 100;
		long J = year / 100;
		
		h = (int) ((q + Math.floor(13 * (m + 1) / 5) + K + Math.floor(K / 4) + Math.floor(J / 4) + 5 * J) % 7);
		
		/*
		 * other formula: 
		 * 
		 * long Y = year;
		 * h = (int) ((1 + Math.floor(13 * (m + 1) / 5) + Y + Math.floor(Y / 4) - Math.floor(Y / 100) + Math.floor(Y / 400) % 7);
		 */
		
		if (h == 1) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		try { 
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			int numOfTestCase = Integer.parseInt(input.readLine());
			while (numOfTestCase-- > 0) {
				long countDay = 0;
				long[][] dates = new long[2][3];
				
				for (int i = 0; i < 2; i++) {
					String[] date = input.readLine().split(" ");
					for (int j = 0; j < 3; j++) {
						dates[i][j] = Long.valueOf(date[j]);
					}
				}
				
				
				//Check if the input dates are in valid order 
				validateInput(dates);
				while (!overDate(dates)) {
					int tempMonth = 0;
					if (dates[0][2] == 1) {
						
						if (dates[0][1] == 1) {
							tempMonth = 1;
							dates[0][1] = 13;
							dates[0][0]--;
						} else if (dates[0][1] == 2) {
							tempMonth = 2;
							dates[0][1] = 14;
							dates[0][0]--;
						}
						
						if (verifyDate(dates[0][0], dates[0][1], dates[0][2])) {
							countDay++;
						}
						
						if (dates[0][1] == 13 || dates[0][1] == 14) {
							dates[0][1] = tempMonth;
							dates[0][0] ++;
						}
					}
					/*
					 * After the border date of Input
					 * check the first day of every month after the month of Input
					 * to see if that day is a Sunday
					 */
					
					//Set the date to be the first day of the month
					dates[0][2] = 1;
					
					//Increment the month
					dates[0][1]++;
					/*
					 * March = 3; April = 4; ... December = 12;
					 * January = 13; February = 14 (Year = Year - 1)
					 */
					if (dates[0][1] > 12) {
						dates[0][1] = 1;
						dates[0][0]++;
					}
					
					
					if (overDate(dates)) {
						break;
					}
				}
				
//				for (int i = 0; i < 2; i++) {
//					for (int j = 0; j < 3; j++) {
//						System.out.print(dates[i][j] + " ");
//					}
//					System.out.println();
//				}
//				
				output.append(String.valueOf(countDay)).append("\n");
	
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
