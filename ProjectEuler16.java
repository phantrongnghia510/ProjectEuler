import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ProjectEuler16 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numOfTestCase = scnr.nextInt();
        
        for (int i = 0; i < numOfTestCase; i++) {
            int n = scnr.nextInt();
            BigInteger num = new BigInteger("2");
            String numString;
            num = num.pow(n);
            numString = num.toString();
            int sum = 0;
            for(int j = 0; j < numString.length(); j++) {
            	//the number represent a number is i - character'0'(ASCII)
                sum += numString.charAt(j) - '0';
            }
            
            System.out.println(sum);
        }
    }
}
