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
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,10};
		long product = productOfArray(arr, arr.length);
		System.out.println("productOfArray: " + product);
		
		long recursiveSum = recursiveRange(10);
		System.out.println("Recursive Sum: " + recursiveSum);
	}

}
