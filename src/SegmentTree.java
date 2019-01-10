import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SegmentTree {
	
	private static int[] ar;
	private static int[] tree;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			ar = new int[s.length];
			tree = new int[s.length * 4];
			for(int i = 0; i < s.length; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
