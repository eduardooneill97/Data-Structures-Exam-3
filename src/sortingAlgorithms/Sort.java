package sortingAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Sort {
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void heapSort(int[] arr) {
		makeHeap(arr);
		for(int i = arr.length-1; i>=0; i--) {
			swap(arr, 0, i);
			downHeap(arr, 0, i-1);
		}
	}
	
	public static void pairSort(int[] arr) {	//Duda para el profesor.
//		int range = 1;
//		while(range<= arr.length/2) {
//			int low = 0, m = low+range-1, sup = m+range;
//			while(sup<arr.length) {
//				merge(arr, low, m, sup);
//				low = sup+1;
//				m = low+range-1;
//				sup = m+range;
//			}
//			range++;
//		}
		
		int low = 0, m = low, sup = m+1;
		while(sup<arr.length) {
			merge(arr, low, m, sup);
			low = sup+1;
			m = low;
			sup = m+1;
		}
		low = 0;
		m = 1;
		sup = m+2;
		while(sup<arr.length) {
			merge(arr, low, m, sup);
			low = 0;
			m = sup;
			sup = m+2;
		}
		if(arr.length%2 != 0)
			merge(arr, 0, arr.length-2, arr.length-1);
	}
	
	private static void makeHeap(int[] arr) {
		for(int i = ((arr.length-1)-1)/2; i>=0; i--) {
			downHeap(arr, i, arr.length);
		}
	}
	
	private static void downHeap(int[] arr, int r, int k) {
		boolean isHeap = false;
		while(2*r+1<k && !isHeap) {
			int max = 2*r+1;
			if(2*r+2<k && arr[2*r+2]>arr[max])
				max = 2*r+2;
			if(arr[max]>arr[r]) {
				swap(arr, max, r);
				r = max;
			}
			else isHeap = true;
		}
	}
	
	private static void mergeSort(int[] arr, int low, int sup) {
		if(low<sup) {
			int m = (low+sup)/2;
			mergeSort(arr, low, m);
			mergeSort(arr, m+1, sup);
			merge(arr, low, m, sup);
		}
	}
	
	private static void merge(int[] arr, int low, int m, int sup) {
		Queue<Integer> h1 = new LinkedList<Integer>();
		Queue<Integer> h2 = new LinkedList<Integer>();
		
		for(int i = low; i<=m; i++) {
			h1.add(arr[i]);
		}
		for(int i = m+1; i<=sup; i++) {
			h2.add(arr[i]);
		}
		
		int i = low;
		while(!h1.isEmpty() && !h2.isEmpty()) {
			if(h1.peek() < h2.peek())
				arr[i] = h1.remove();
			else
				arr[i] = h2.remove();
			i++;
		}
		
		if(h1.isEmpty()) {
			while(!h2.isEmpty()) {
				arr[i] = h2.remove();
				i++;
			}
		}
		else if(h2.isEmpty()) {
			while(!h1.isEmpty()) {
				arr[i] = h1.remove();
				i++;
			}
		}
	}
	
	private static void quickSort(int[] arr, int low, int sup) {
		if(low<sup) {
			int p = partition(arr,low, sup);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, sup);
		}
	}
	
	private static int partition(int[] arr, int low, int sup) {
		
		int left = low+1, right = sup;
		while(left<=right) {
			while(left<=right && arr[left]<=arr[low])left++;
			while(left<=right && arr[right]>=arr[low])right--;
			if(left<right) {
				swap(arr, left, right);
				left++;
				right--;
			}
				
		}
		swap(arr, low, right);
		return right;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
