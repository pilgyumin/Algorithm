

import java.util.Arrays;
import java.util.Scanner;

public class tsp {
	static int[][] cache;
	static int[][] map;
	static int n;
	
	private static int dp(int here, int visited) {
		if(cache[here][visited] != -1) {
			return cache[here][visited];
		}
		
		cache[here][visited] = 987654321;
		if(visited == (1 << n) -1) {
			cache[here][visited] = map[here][0];

			return cache[here][visited];
		}
		
		for(int there = 1; there < n; there++) {
			if((visited & (1 << there)) == 0) {
				int next = visited | (1 << there);

				cache[here][visited] = Math.min(cache[here][visited], dp(there,next) + map[here][there]);

			}
			
		}
		System.out.println("-------------");
		return cache[here][visited];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		cache = new int[n][1 << n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < n; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		System.out.printf("#%d \n",dp(0,1));
		
	}
}
