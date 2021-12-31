package arrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class AverageTemperature {
	
	private static int sumOfTemps(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	static double calcAvg(int[] arr) {
		return sumOfTemps(arr) / arr.length;
	}
	
	static int[] daysOverAvg(int[] arr) {
		double avg = calcAvg(arr);
		int size = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > avg) {
				size ++;
			}
		}
		int[] overAvg = new int[size];
		int indexCount = 0;
		for(int k = 0; k < arr.length; k++) {
			if(arr[k] > avg) {
				overAvg[indexCount] = arr[k];
				indexCount++;
			}
		}
		return overAvg;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("How many day's temperatures?");
		
		int numDays = scn.nextInt();
		int sum = 0;
		int[] days = new int[numDays];
		
		for(int i = 1; i < days.length; i++) {
			System.out.println("Temp of day " + i);
			days[i] = scn.nextInt();
		}

		System.out.println("AVG: " + calcAvg(days));
		String str = "Over AVG: " + Arrays.toString(daysOverAvg(days));
		System.out.println(str);
	}
}
