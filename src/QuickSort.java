import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	private static int[] ar;

	
	private static void quickSort(int start, int end) {
		
		if(start >= end) {
			return ;
		}

		int i = start -1 , j = end + 1, key = ar[(i + j) / 2];
		
		
		while(true) {
			while(ar[++i] < key);
			while(ar[--j] > key);
			if(i >= j) break;
			int temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}

		quickSort(start, i-1);
		quickSort(j+1, end);
	}
	
	public static void main(String[] args) {
		ar = new int[1000000];
		Random r = new Random();
		for(int i = 0; i < 1000000; ++i) {
			ar[i] = r.nextInt(1000000) % 1000000;
		}
		long mymb = System.currentTimeMillis();
		quickSort(0, ar.length-1);
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
