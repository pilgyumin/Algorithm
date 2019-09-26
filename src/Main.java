import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nw = br.readLine().split(" ");
		
		int n = Integer.parseInt(nw[0]);
		int w = Integer.parseInt(nw[1]);
		int dqlen = 0;
		if(n % 2  == 1) {
			dqlen = (n/2)+1;
		}
		else {
			dqlen = n/2;
		}
		
		Deque<String>[] dq = new Deque[dqlen];
		
		for(int i = 0; i < dqlen; i++) {
			dq[i] = new ArrayDeque<String>();
		}
		
		String[][] map = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = s[j];
			}
		}
		
		int len = n;
		
		for(int i = 0; i < dqlen; i++) {
			int x = i, y = i;
			while(y < len) {
				dq[i].add(map[x][y++]);
			}
			y--;
			x++;
			while(x < len) {
				dq[i].add(map[x++][y]);
			}
			x--;
			y--;
			while(y >= i) {
				dq[i].add(map[x][y--]);
			}
			y++;
			x--;	
			while(x > i) {
				dq[i].add(map[x--][y]);
			}
			len--;
		}
		
		for(int i = 0; i < dqlen; i++) {
			int rotate = Math.abs(w) % dq[i].size();
			if(w < 0) {
				for(int r = 0; r < rotate; r++) {
					String st = dq[i].pollFirst();
					dq[i].addLast(st);
				}
			}
			else if(w > 0){
				for(int r = 0; r < rotate; r++) {
					String st = dq[i].pollLast();
					dq[i].addFirst(st);
				}
			}
			w *= -1;
		}
		
		len = n;
		
		for(int i = 0; i < dqlen; i++) {
			int x = i, y = i;
			while(y < len) {
				map[x][y++] = dq[i].pollFirst();
			}
			y--;
			x++;
			while(x < len) {
				map[x++][y] = dq[i].pollFirst();
			}
			x--;
			y--;
			while(y >= i) {
				map[x][y--] = dq[i].pollFirst();
			}
			y++;
			x--;	
			while(x > i) {
				map[x--][y] = dq[i].pollFirst();
			}
			len--;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
