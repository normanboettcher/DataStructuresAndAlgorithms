package recursion;
/**
 * 
 * @author norman
 *
 */
public class Recursion {
	
	static void openRussianDoll(int doll) {
		if(doll == 1) {
			System.out.println("All dolls are opened.");
		} else {
			System.out.println("Open doll number " + doll);
			openRussianDoll(doll - 1);
		}
	}
	/*
	 * With 3 Step formular
	 * 
	 * 1 - Recursive case - the flow
	 * 		n! = n * (n-1) * (n-2) * ..* 2 * 1 = n * (n - 1)!
	 * 
	 * 2 - Base case - the stopping criterion
	 * 		0! = 1
	 * 		1! = 1
	 * 
	 * 3 - Unintentional case - the constraint
	 * 	factorial < 0 ?
	 */
	static long factorial(long n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	/*
	 * f(n) = f(n-1) + f(n-2)
	 */
	static int fibonacci(int n) {
		if(n < 0) {
			return -1;
		}
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	/*
	 * Step 1 - 10 --> 10/10 = 1 and Remainder = 0 ==> f(n) = n%10 + f(n/10)
	 * Step 2 Base case --> n = 0
	 * Step 3 --> f(-11) (negative numbers)
	 *
	 */
	static int sumOfDigitsInteger(int n) {
		
		
		if(n == 0 || n < 0) {
			return 0;
		}
		return n % 10 + sumOfDigitsInteger(n/10);
	}
	
	/*
	 * Step 1 x^n = x * x * x (n times), x^b * x^d = x⁽b+d) ==> x^n = n * n^n-1
	 * Step 2 n = 0 and n = 1
	 * step 3 prevent for negatives
	 */
	static int calcPower(int base, int exp) {
		if(exp < 0 || base < 0) {
			return -1;
		}
		if(exp == 0) {
			return 1;
		}
		return base * calcPower(base, exp - 1);
	}
	
	/*
	 * Step 1 --> euclidean algorithm 
	 * 	Example: gcd(48,18)
	 * 		Step 1: 48/18 = 2 remainder 12
	 * 		Step 2: 18/12 = 1 remainder 6
	 * 		Step 3: 12/6 = 2 remainder 0
	 *  ==> gcd(a, 0) = a and gcd(a, b) = gcd(b, a mod b)
	 * 
	 * Base Condition --> 
	 */
	static int findGreatestCommonDivisor(int n1, int n2) {
		if(n1 < 0 || n2 < 0) {
			return -1;
		}
		
		if(n2 == 0) {
			return n1;
		}
		
		return findGreatestCommonDivisor(n2, n1 % n2);
	}
	
	/*
	 * Step 1--> 1. Divide n by 2
	 * 			2.  get the integer quotient for the next iteration
	 * 			3. Get the remainder for the binary digit
	 * 			4. Repeat the steps until the quotient is equal to 0
	 * 		==> f(n) = n mod 2 + 10 * f(n/2)
	 */
	static int decimalToBinary(int n) {
		
		if(n < 0) {
			return -1;
		}
		
		if(n == 0) {
			return 0;
		}
		return n % 2 + 10 * decimalToBinary(n/2);
	}
	
	public static void main(String[] args) {
		openRussianDoll(5);
		System.out.println("==============================");
		System.out.println(factorial(10));
		System.out.println("==============================");
		System.out.println(fibonacci(3));
		System.out.println("==============================");
		System.out.println(sumOfDigitsInteger(11));
		System.out.println("==============================");
		System.out.println(calcPower(2,4));
		System.out.println("==============================");
		System.out.println(findGreatestCommonDivisor(2,4));
		System.out.println("==============================");
		System.out.println(decimalToBinary(21));
	}
}
