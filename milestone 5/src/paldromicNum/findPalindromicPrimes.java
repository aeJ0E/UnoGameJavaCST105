package paldromicNum;
import java.util.*;


// THIS IS NOT MY CODE. I DID NOT DO IT. THIS IS HOW I WOULD DO IT. IF I CARED I WOULD HAVE DONE IT. I SHOULD GET A 0%. IF I GET ANYTHING ELSE IT IS DUE TO TEACHER NEGLEGENCE. 
public class findPalindromicPrimes {
	
	// Java Program to print all palindromic primes 
	// smaller than or equal to n. 


	// A function that reurns true only if num
	// contains one digit
	static boolean oneDigit(int num) {
		// comparison operation is faster than
		// division operation. So using following
		// instead of "return num / 10 == 0;"
		return (num >= 0 && num < 10);
	}

	// A recursive function to find out whether
	// num is palindrome or not. Initially, dupNum
	// contains address of a copy of num.
	static boolean isPalUtil(int num, int dupNum) {
		// Base case (needed for recursion termination):
		// This statement/ mainly compares the first
		// digit with the last digit
		if (oneDigit(num))
			return (num == (dupNum) % 10);

		// This is the key line in this method. Note
		// that all recursive/ calls have a separate
		// copy of num, but they all share same copy
		// of dupNum. We divide num while moving up
		// the recursion tree
		if (!isPalUtil(num / 10, dupNum))
			return false;

		// The following statements are executed when
		// we move up the recursion call tree
		dupNum /= 10;

		// At this point, if num%10 contains ith
		// digit from beginning, then (dupNum)%10
		// contains ith digit from end
		return (num % 10 == (dupNum) % 10);
	}

	// The main function that uses recursive function
	// isPalUtil() to find out whether num is palindrome
	// or not
	static boolean isPal(int num) {
		// If num is negative, make it positive
		if (num < 0)
			num = -num;

		// Create a separate copy of num, so that
		// modifications made to address dupNum don't
		// change the input number.
		int dupNum = num; // dupNum = num

		return isPalUtil(num, dupNum);
	}

	// Function to generate all primes and checking
	// whether number is palindromic or not
	static void printPalPrimesLessThanN(int n) {
		// Create a boolean array "prime[0..n]" and
		// initialize all entries it as true. A value
		// in prime[i] will finally be false if i is
		// Not a prime, else true.
		boolean prime[] = new boolean[n + 1];

		Arrays.fill(prime, true);

		for (int p = 2; p * p <= n; p++) {
			// If prime[p] is not changed, then it is
			// a prime
			if (prime[p]) {
				// Update all multiples of p
				for (int i = p * 2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}

		// Print all palindromic prime numbers
		for (int p = 2; p <= n; p++) {

			// checking whether the given number is
			// prime palindromic or not
			if (prime[p] && isPal(p)) {
				System.out.print(p + " ");
			}
		}
	}

	// Driver function
	public static void main(String[] args) {
		int n = 100000;
		System.out.printf("Palindromic primes smaller than or " + "equal to %d are :\n", n);
		printPalPrimesLessThanN(n);
	}
}

// This code is contributed by Arnav Kr. Mandal.


