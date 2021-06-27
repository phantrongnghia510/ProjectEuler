import java.util.Scanner;
/**
 * Number to Words
 * Difficulty: ***
 * Be careful of the misspelling
 */
public class ProjectEuler17 {
	static String[] zeroToNineteen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tenBeyondTen = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	
	public static void handlingLessThanAThousand (int num) {
		if (num / 100 != 0) {
			System.out.print(zeroToNineteen[num / 100] + " ");
			System.out.print("Hundred ");
			num %= 100;
		}
		if (num == 0) {
			return;
		}
		if (num > 0 && num < 20) {
			System.out.print(zeroToNineteen[num] + " ");
		} else {
			int firstDigit = num / 10;
			int secondDigit = num % 10;
		
			System.out.print(tenBeyondTen[firstDigit - 2] + " ");
			if (secondDigit != 0) {
			System.out.print(zeroToNineteen[secondDigit] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		try (Scanner scnr = new Scanner(System.in)) {
			int numOfTestCase = scnr.nextInt();
			
			
			for (int i = 0; i < numOfTestCase; i++) {
				long num = scnr.nextLong();
				
				int trillion = (int) (num / 1e12) % 1000;
				int billion = (int) (num / 1e9) % 1000;
				int million = (int) (num / 1e6) % 1000;
				int thousand = (int) (num / 1e3) % 1000;
				int lessThanAThousand = (int) (num  % 1000);
				
				if (trillion + billion + million + thousand + lessThanAThousand == 0 ) {
					System.out.print("Zero");
				}
				
				if (trillion != 0) {
					handlingLessThanAThousand(trillion);
					System.out.print("Trillion ");
				}
				if (billion != 0) {
					handlingLessThanAThousand(billion);
					System.out.print("Billion ");
				}
				if (million != 0) {
					handlingLessThanAThousand(million);
					System.out.print("Million ");
				}
				if (thousand != 0) {
					handlingLessThanAThousand(thousand);
					System.out.print("Thousand ");
				}
				if (lessThanAThousand != 0) {
					handlingLessThanAThousand(lessThanAThousand);
				}
				
				System.out.println("");

			}
		}
		catch (Exception E) {
			System.out.print(E.getMessage());
		}
	}
}
