
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import java.util.Scanner;

class Solution {
    static BufferedReader br;
    
    static class Node{
    	int x;
    	int y;
    	
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
 
    }
 
    static final int MAX_SIZE = 100;
 
    static Node heap[] = new Node[MAX_SIZE];
    static int heapSize = 0;
 
    static void heapInit()
    {
        heapSize = 0;
    }
 
    static void heapPush(Node value)
    {
        if (heapSize + 1 > MAX_SIZE)
        {
            return;
        }
 
        heap[heapSize] = value;
 
        int current = heapSize;
        while (current > 0 && heap[current].x <= heap[(current - 1) / 2].x) 
        {
        	if(heap[current].y < heap[(current - 1) / 2].y) 
        	{
        		Node temp = heap[(current - 1) / 2];
                heap[(current - 1) / 2] = heap[current];
                heap[current] = temp;
               
        	}
        	current = (current - 1) / 2;
        }
 
        heapSize = heapSize + 1;
    }
 
    static Node heapPop()
    {
        if (heapSize <= 0)
        {
            return null;
        }
 
        Node value = heap[0];
        heapSize = heapSize - 1;
 
        heap[0] = heap[heapSize];
 
        int current = 0;
        while (current < heapSize && current * 2 + 1 < heapSize)
        {
            Node child;
//            if (current * 2 + 2 >= heapSize)
//            {
//                child = heap[current * 2 + 1];
//            }
//            else
//            {
//                child = heap[current * 2 + 1] < heap[current * 2 + 2] ? heap[current * 2 + 1] : heap[current * 2 + 2];
//            }
// 
//            if (heap[current] < heap[child])
//            {
//                break;
//            }
// 
//            int temp = heap[current];
//            heap[current] = heap[child];
//            heap[child] = temp;
// 
//            current = child;
        }
        return value;
    }
 
    static void heapPrint(Node[] heap, int heap_size)
    {
        for (int i = 0; i < heap_size; i++)
        {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
 
 
    public static void main(String arg[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
             
            heapInit();
             
            for (int i = 0; i < N; i++)
            {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                heapPush(new Node(a,b));
            }
 
            System.out.print("#" + test_case + " ");            
            for (int i = 0; i < N; i++)
            {
                System.out.print(heapPop() + " ");
            }
            System.out.println();
        }
    }
}


