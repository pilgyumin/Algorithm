import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SegmentTree {
	
	private static int[] ar;
	private static int[] tree;
	
	public static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = ar[start];
		}
		int mid = (start + end) / 2;
		
		return tree[node] = init(start,mid,node * 2) + init(mid+1,end,node*2 + 1);
	}
	
	public static void update(int start, int end, int node, int index, int diff) {
		if(index < start || index > end) {
			return;
		}
		
		tree[node] += diff;
		
		int mid = (start + end) / 2;
		
		update(start, mid,node * 2, index, diff);
		update(mid + 1, end, node * 2 + 1,index,diff);
	}
	
	public static int sum(int start, int end, int node, int left, int right) {
		if(start > left || end < right) {
			return 0;
		}
		
		if(start <= left && end >= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return sum(start,mid,node,left,right) + sum(mid+1,end,node,left,right);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			ar = new int[s.length];
			tree = new int[s.length * 4];
			Arrays.fill(tree, -1);
			for(int i = 0; i < s.length; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			init(0, ar.length - 1 , 1);
			for(int i = 0; i < tree.length; i++) {
				System.out.print(tree[i] + " ");
			}
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
