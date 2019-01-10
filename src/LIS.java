import java.util.ArrayList;
import java.util.Scanner;

public class LIS {
	
	private static int n;
	private static ArrayList<Integer> tail;
	
	private static int lowerbound(int left,int right, int num) {
		int mid;
		
		while(left < right) {
			mid = (left + right) / 2;
	
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] ar = new int[n];
		tail = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		tail.add(ar[0]);
		int idx = 1;
		for(int i = 1; i < n; i++) {
			if(tail.get(tail.size()-1) < ar[i]) {
				tail.add(ar[i]);
			}
			else {
				tail.add(lowerbound(0,tail.size()-1,ar[i]), ar[i]);;
			}
		}
	}

}
