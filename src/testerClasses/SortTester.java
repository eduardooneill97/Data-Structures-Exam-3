package testerClasses;

import java.util.Scanner;

import sortingAlgorithms.Sort;

public class SortTester {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		//Sort.quickSort(arr);
		//Sort.mergeSort(arr);
		//Sort.heapSort(arr);
		Sort.pairSort(arr);
		print(arr);
		
	}
	
	public static void print(int[] arr) {
		for(Integer x: arr) {
			System.out.print(x+" ");
		}
	}

}
