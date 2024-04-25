package application;

import java.util.HashSet;
import java.util.Set;

public class Program {

    public static Set<int[]> makeChange(int n) {
        Set<int[]> resultSet = new HashSet<>(); // Initialize an empty set to store the representations

        // Iterate through all possible combinations of coins
        for(int quarters = 0; quarters <= n / 25; quarters++) {
        	for(int dimes = 0; dimes <= (n - 25 * quarters) / 10; dimes++) {
        		for(int nickels = 0; nickels <= (n - 25 * quarters - 10 * dimes) / 5; nickels++) {
        			int pennies = n - 25 * quarters - 10 * dimes - 5 * nickels;
        			resultSet.add(new int[]{quarters, dimes, nickels, pennies});
        		}
        	}
        }
        return resultSet;
    }

    public static void main(String[] args) {
        int n = 12;
        Set<int[]> waysToRepresent = makeChange(n);

        // Print the ways to represent n cents
        for (int[] coins : waysToRepresent) {
            System.out.printf("[%d, %d, %d, %d] ", coins[0], coins[1], coins[2], coins[3]);
        }
    }
}

