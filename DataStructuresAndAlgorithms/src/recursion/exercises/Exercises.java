package recursion.exercises;

public class Exercises {
	
	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int productOfArray(int arr[], int n) {
		if(n < 0 || n > arr.length) {
			return -1;
		}
		if(n == 0) {
			return arr[n];
		}
		return arr[n-1] * productOfArray(arr, n-1);
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	private static int recursiveRange(int n) {
		if(n < 0) {
			return -1;
		}
		
		if(n == 0) {
			return n;
		}
		return n + recursiveRange(n - 1);
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String reverse(String str) {
		if(str.isEmpty()) {
			return "EMPTY. NOTHING TO DO";
		}
		if(str.length() == 1) {
			return str;
		}	
		return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isPalindrome(String str) {
			
			if(str.length() == 0 || str.length() == 1) {
                return true; 
			}
            if(str.charAt(0) == str.charAt(str.length()-1)) {
            	return isPalindrome(str.substring(1, str.length()-1));
            }
            return false;
	}
	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static boolean isOdd(int[] arr, int n) {
		if(arr == null) {
			return false;
		}
		
		if((n == 0) && (arr[n] % 2 != 0)) {
			return true;
		}
		
		if((n==0) && (arr[n] % 2 == 0)) {
			return false;
		}
		
		if(arr[n] % 2 != 0) {
			return true;
		} else {
			return isOdd(arr, n -1);
		}
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static char findFirstUpperCase(String str) {
		if(str.isEmpty()) {
			return ' ';
		}
		
		if(Character.isUpperCase(str.charAt(0))) {
			return str.charAt(0);
		} else {
			return findFirstUpperCase(str.substring(1, str.length()));
		}
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String capitalizeEachWord(String str) {
		if(str.isEmpty()) {
			return "NOTHING TO DO HERE";
		}
	    char chr = str.charAt(str.length()-1);
	    if(str.length()==1) {
	        return Character.toString(Character.toUpperCase(chr));
	    }
	    if((str.substring(str.length() -2, str.length()-1).equals(" "))) {
	        chr = Character.toUpperCase(chr);
	    }
	    return capitalizeEachWord(str.substring(0,str.length()-1))+ Character.toString(chr);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,10};
		long product = productOfArray(arr, arr.length);
		System.out.println("productOfArray: " + product);
		
		long recursiveSum = recursiveRange(10);
		System.out.println("Recursive Sum: " + recursiveSum);
		
		String recursiveString = "I want to be printed recursively";
		System.out.println(reverse(recursiveString));
		
		System.out.println(isPalindrome("hallo"));
		
		int[] arrWithoutOdd = new int[] {2, 4, 6};
		System.out.println("Array with Odd: " + isOdd(arr, arr.length - 1));
		System.out.println("Array without odd: " + isOdd(arrWithoutOdd, arrWithoutOdd.length -1));
		
		System.out.println(findFirstUpperCase("Hallo"));
		
		System.out.println(capitalizeEachWord("i love java"));
	}

}
