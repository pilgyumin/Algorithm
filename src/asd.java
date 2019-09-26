import java.util.ArrayList;
import java.util.HashSet;


public class asd {

	public static void main(String[] args) {

		Math.max(1, 2);
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		HashSet<String> hs = new HashSet<String>();
		hs.add("asd");
		System.out.println(hs.contains("asd"));
		ArrayList<Integer> uniqA = new ArrayList<>(new HashSet<>(a));
	}

	private static void sort(int[] ar) {

		
		for(int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
	
	

}
