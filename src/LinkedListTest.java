import java.util.LinkedList;
import java.util.Random;

public class LinkedListTest {
	static int NODE_SIZE = 100000;

	static class Node {
		int prev;
		int next;
		int val;
	}

	static class Linkedlist {
		Node[] node;
		int HEAD = NODE_SIZE;
		int TAIL = NODE_SIZE + 1;
		int pos;

		public Linkedlist() {
			pos = 0;
			node = new Node[NODE_SIZE+2];
			for(int i = 0; i < NODE_SIZE+2; i++) {
				node[i] = new Node();
			}
			node[HEAD].next = TAIL;
			node[TAIL].prev = HEAD;
		}

		void push_back(int data) {
			int prev = node[TAIL].prev;
			int next = TAIL;
			
			node[pos].val = data;
			
			node[pos].next = next;
			node[next].prev = pos;
			
			node[pos].prev = prev;
			node[prev].next = pos;
			++pos;
		}

		void push_front(int data) {
			int prev = HEAD;
			int next = node[prev].next;
			
			node[pos].val = data;
			
			node[pos].next = next;
			node[next].prev = pos;
			
			node[pos].prev = prev;
			node[prev].next = pos;
			
			++pos;
		}

		void insert(int p, int data) {
			int next = node[HEAD].next;
			for(int i = 0; i < p; i++) {
				next = node[next].next;
			}
			int prev = node[next].prev;
			
			node[pos].val = data;
			
			node[pos].next = next;
			node[next].prev = pos;
			
			node[pos].prev = prev;
			node[prev].next = pos;
			++pos;
		}

		void pop_back() {
			int target = node[TAIL].prev;
			
			int next = TAIL;
			int prev = node[target].prev;
			
			node[next].prev = prev;
			node[prev].next = next;
			
		}

		void pop_front() {
			int target = node[HEAD].next;
			
			int prev = HEAD;
			int next = node[target].next;
			
			node[prev].next = next;
			node[next].prev = prev;
		}

		void delete(int p) {
			int next = node[HEAD].next;
			for(int i = 0; i < p; i++) {
				next = node[next].next;
			}
			int prev = node[next].prev;
			
			node[prev].next = next;
			node[next].prev = prev;
		}
	}

	public static void main(String[] args) {
		Linkedlist li = new Linkedlist();
		LinkedList<Integer> stl = new LinkedList<>();
		int[][] testcmd = new int[NODE_SIZE][3];
		Random r = new Random();
		int cursize = 0;
		
		for(int i = 0; i < NODE_SIZE; ++i) {
			if(i < NODE_SIZE / 3) {
				testcmd[i][0] = r.nextInt(100000) % 2;
			}
			else {
				testcmd[i][0] = r.nextInt(100000) % 6;
			}
			switch(testcmd[i][0]) {
			case 0: case 1:
				testcmd[i][1] = r.nextInt(100000);
				++cursize;
				break;
			case 2:
				testcmd[i][1] = r.nextInt(100000) % cursize;
				testcmd[i][2] = r.nextInt(100000);
				++cursize;
				break;
			case 3: case 4:
				--cursize;
				break;
			case 5:
				testcmd[i][1] = r.nextInt(100000) % cursize;
				--cursize;
				break;
			}
		}
		
		long mylistbegin = System.currentTimeMillis();
		for(int i = 0; i < NODE_SIZE; ++i) {
			switch(testcmd[i][0]) {
			case 0:
				li.push_back(testcmd[i][1]);
				break;
			case 1:
				li.push_front(testcmd[i][1]);
				break;
			case 2:
				li.insert(testcmd[i][1], testcmd[i][2]);
				break;
			case 3:
				li.pop_back();
				break;
			case 4:
				li.pop_front();
				break;
			case 5:
				li.delete(testcmd[i][1]);
				break;
			}
		}
		long mylistend = System.currentTimeMillis();
		
		long stlbegin = System.currentTimeMillis();
		for(int i = 0; i < NODE_SIZE; ++i) {
			switch(testcmd[i][0]) {
			case 0:
				stl.addLast(testcmd[i][1]);
				break;
			case 1:
				stl.addFirst(testcmd[i][1]);
				break;
			case 2:
				stl.add(testcmd[i][1], testcmd[i][2]);
				break;
			case 3:
				stl.pollLast();
				break;
			case 4:
				stl.pollFirst();
				break;
			case 5:
				stl.remove(testcmd[i][1]);
				break;
			}
		}
		long stlend = System.currentTimeMillis();
		System.out.println("mylist : " + (mylistend - mylistbegin));
		System.out.println("stl : " + (stlend - stlbegin));
	}
}
