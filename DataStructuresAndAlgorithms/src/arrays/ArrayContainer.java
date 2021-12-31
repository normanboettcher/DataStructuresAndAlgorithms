package arrays;

import java.util.Arrays;

public class ArrayContainer {
	TwoDimArray twoDim;
	
	private class TwoDimArray {
		private int[][] arr;
		
		protected TwoDimArray(int size1, int size2) {
			init(size1, size2);
		}
		
		 private void init(int sizeFirstDim, int size2Dim) {
			this.arr = new int[sizeFirstDim][size2Dim]; 
			for(int i = 0; i < this.arr.length; i++) {
				for(int j = 0; j < this.arr[i].length; j++) {
					arr[i][j] = 1;
				}
			}
		}
		 
		 protected void printAsMatrix() {
			 System.out.println("========As Matrix=============");
			 for(int i = 0; i < this.arr.length; i++) {
				for(int j = 0; j < this.arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println("");
			 }
		 }
		 
		protected void insert(int row, int column, int value) {
			this.arr[row][column] = value;
		}
		 
		protected String TwoDimToString() {
			return Arrays.deepToString(arr);
		}
	}
	
	public TwoDimArray init2Dim(int sizeFirst, int sizeSecond) {
		this.twoDim = new TwoDimArray(sizeFirst, sizeSecond);
		return this.twoDim;
	}
	
	private int[] arr;
	
	public ArrayContainer(int sizeOfArray) {
		this.arr = new int[sizeOfArray];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}
	/**
	 * O(1)
	 * @param location
	 * @param value
	 */
	public void insert(int location, int value) {
		try {
			if(arr[location] == Integer.MIN_VALUE) {
				arr[location] = value;
				System.out.println("Sucessfully inserted");
			} else {
				System.out.println("This cell is already occupied");
				
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid Location");
		}
		
	}
	/**
	 * O(n), because we are looking for an specific element to delete.
	 * So we have to traverse through the whole array in the worst case.
	 * @param value
	 */
	public void delete(int value) {
		try {
			for (int v = 0; v < this.arr.length; v++) {
				if(this.arr[v] == value) {
					this.arr[v] = Integer.MIN_VALUE;
				}
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
	}
	/**
	 * Deleting with O(1)
	 * @param index
	 */
	public void deleteByIndex(int index) {
		try {
			this.arr[index] = Integer.MIN_VALUE;
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.arr);
	}
	
	public String int2DtoString() {
		return this.twoDim.TwoDimToString();
	}
	
	public static void main(String[] args) {
		ArrayContainer base = new ArrayContainer(10);
		
		base.insert(0, 5);
		base.insert(0, 4); //Should not work. Already occupied message.
		base.insert(1, 3);
		base.insert(11, 5);
		base.insert(-1, 5);
		
		System.out.println(base.toString());
		base.delete(3);
		System.out.println(base.toString());
		
		base.init2Dim(3, 5);
		System.out.println(base.int2DtoString());
		
		base.twoDim.insert(0, 0, 0);
		System.out.println(base.int2DtoString());
		base.twoDim.printAsMatrix();
	}

}
