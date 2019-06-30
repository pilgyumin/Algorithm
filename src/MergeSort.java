import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	private static int[] ar;
	private static int[] sort;
	
	private static void mergeSort(int start, int end) {
		
		if (start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		
		int i = start, j = mid + 1, p = start;
		
		while (i <= mid && j <= end) {
			if (ar[i] < ar[j]) {
				sort[p++] = ar[i++];
			} 
			else {
				sort[p++] = ar[j++];
			}
		}
		if (i <= mid) {
			for (int k = i; k <= mid; k++) {
				sort[p++] = ar[k];
			}
		} 
		else {
			for (int k = j; k <= end; k++) {
				sort[p++] = ar[k];
			}
		}
		for (int k = start; k <= end; k++) {
			ar[k] = sort[k];
		}
	}
	
	public static void main(String[] args) {
		ar = new int[1000000];
		sort = new int[1000000];
		Random r = new Random();
		for(int i = 0; i < 1000000; ++i) {
			ar[i] = r.nextInt(1000000) % 1000000;
		}
		long mymb = System.currentTimeMillis();
		mergeSort(0, ar.length-1);
		long myme = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000; ++i) {
			ar[i] = r.nextInt(1000000) % 1000000;
		}
		long stlmb = System.currentTimeMillis();
		Arrays.sort(ar);
		long stlme = System.currentTimeMillis();
		
		System.out.println("mylist : " + (myme - mymb));
		System.out.println("stl : " + (stlme - stlmb));
	}
}
