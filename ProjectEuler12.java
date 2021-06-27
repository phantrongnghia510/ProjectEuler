import java.io.*;
import java.util.*;
//Highly divisible triangular number
// Difficulty: ***

public class ProjectEuler12 {
	/**
	 * Find the number of factors of a (triangular) number
	 * @param (triangular) number
	 * @return the number of factors
	 */
    static int factor(int number){
        int count = 0;
        
        if(number == 1){
            return 1;
        }
        /*
         * Consider number n = i * x
         * if n % i == 0
         * 
         * 	if  n / i == i  where (x == i) or ( n = i * i)
         * 	then increment count by 1
         *
         * 	else n / i == x (x != i) then 
         * 	increment count by 2
         * 
         * 
         * 
         */
        for(int i = 1 ; i * i <= number ;i++){
            if(number % i == 0){
            		if (number / i == i) {
            			count++;
            		}
            		else {
            			count += 2;
            		}
            }
        }
      
  
        return count;
    }
    public static void main(String[] args) {
        int sols[] = new int[1001];
        int temp = 0, term = 0;
        /**
         * Find the smallest number that has more than i factors
         * variable temp holds the current number of factors 
         * for current term in triangulareNum sequence
         */
        for(int i = 1; i <= 1000; i++){
            while(temp <= i){
                term++;
                //the nth term of the triangular sequence is computed as n(n+1)/ 2 (Guass's)
                temp = factor(((term)*(term+1))/2);
                
            }
            sols[i]=((term)*(term+1))/2;
        }
        Scanner scnr = new Scanner(System.in);
        int testNum = scnr.nextInt();
        for (int k = 0; k < testNum; k++) {
            int n = scnr.nextInt();
            System.out.println(sols[n]);
        }
    }
}

