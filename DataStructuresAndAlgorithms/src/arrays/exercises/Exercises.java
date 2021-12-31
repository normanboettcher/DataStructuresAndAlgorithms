package arrays.exercises;

import java.util.Arrays;

public class Exercises {

	public static void missingNumber(int[] arr) {
		int diff = 1;

		for (int k = 0; k < arr.length; k++) {
			int tmp = arr[k];
			try {
				if ((arr[k + 1] - tmp) > diff) {
					int missing = tmp + 1;
					System.out.println("Fehlende Zahl: " + missing);
				}
			} catch (IndexOutOfBoundsException e) {
				//
			}
		}
	}

	/**
	 * Function to return the pairs where the addition is the target value.
	 * 
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[][] twoSum(int[] nums, int target) {
		int numOfPairs = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int tmp = nums[i];
			for (int j = 1; j < nums.length; j++) {
				int sum = tmp + nums[j];
				if (sum == target) {
					numOfPairs++;
				}
			}
		}

		int[][] allPairs = new int[numOfPairs][0];
		int column = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int tmp = nums[i];
			for (int j = 1; j < nums.length; j++) {
				int sum = tmp + nums[j];
				if (sum == target) {
					int[] pairs = new int[2];
					pairs[0] = nums[i];
					pairs[1] = nums[j];
					allPairs[column] = pairs;
					column++;
				}
			}
		}

		return allPairs;
	}

	/**
	 * Calculate the maximal product of two integers in an array.
	 * 
	 * @return
	 */
	public static String maxProduct(int[] arr) {
		String str = "";
		int product = 0;
		int max = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			int tmp = arr[i];
			for (int j = 1; j < arr.length; j++) {
				product = tmp * arr[j];
				if (product > max) {
					max = product;
					String newString = tmp + " * " + arr[j] + " = " + max;
					str = str.replace(str, newString);
				}
			}
		}
		return str;
	}

	/**
	 * Method to prove uniqueness of a given array.
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isUnique(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int tmp = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (tmp == arr[j]) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Prove, if an array is a permutation of another array.
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean permutation(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; i++) {
			int anzFalse = 0; //Count false comparisons
			int tmp = arr1[i];
			for(int j = 0; j < arr2.length; j++) {
				
				if(tmp != arr2[j]) {
					anzFalse += 1;
				}
			}
			//if the number of false comparisons is equal to length of second array
			//the number from array1 is not in array2 and so it is not a permutation.
			if(anzFalse == arr2.length) {
				return false;
			}
		}
		return true;
	}
	
	public static int[][] transpose(int[][] matrix) {
		int[][] transponierte = new int[matrix[0].length][matrix.length];
		
		for(int m = 0; m < matrix.length; m++) {
			for(int n = 0; n < matrix[m].length; n++) {
				transponierte[n][m] = matrix[m][n];
			}
		}
		return transponierte;
	}
	
	public static void printAsMatrix(int[][] matrix) {
		System.out.println("========As Matrix=============");
		 for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		 }
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
		int[] permut = new int[] { 10, 2, 9, 4, 8, 6, 3, 5, 1 };
		int[] duplicates = new int[] { 2, 2 };
		missingNumber(array);
		
		int[][] matrix = new int[][] {
			{1,2,4,5}, 
			{3,7,8,9}, 
			{12,9,6,5}
		};

		String pairs = "pairs for given target " + Arrays.deepToString(twoSum(array, 11));

		System.out.println(pairs);
		System.out.println(maxProduct(array));
		System.out.println(isUnique(array));
		System.out.println(isUnique(duplicates));
		System.out.println(permutation(array, permut));
		
		int[] test1 = new int[100];
		int[] test2 = new int[100];
		
		for(int i = 0; i < test1.length; i++) {
			test1[i] = i;
		}
		int counter = 0;
		for(int j = test2.length - 1; j >= 0; j--) {
			test2[j] = test1[counter];
			counter++;
		}
	
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
		
		System.out.println(permutation(test1, test2));
		
		//Now change 1 element in test2 and prove again the permutation
		test2[55] = 11;
		System.out.println(permutation(test1, test2)); //should be false
		
		printAsMatrix(matrix);
		printAsMatrix(transpose(matrix));
	}

}
