
public class Heap {
	
	static int heap_size;
	static int data_size = 10000;
	static int heap[] = new int[data_size];
	
	static void push(int data) {
		int target = heap_size + 1;
		while(target != 1 && heap[target/2] < data) {
			heap[target] = heap[target / 2];
			target /= 2;
		}
		heap[target] = data;
		heap_size++;
	}
	
	static int pop() {
		int ret = heap[1];
		int par = 1, child = 2;
		int temp = heap[heap_size];
		while(child < heap_size) {
			if(child + 1 < heap_size && heap[child] < heap[child+1]) {
				child++;
			}
			if(temp <= heap[child]) {
				break;
			}
			heap[par] = heap[child];
			par = child;
			child *= 2;
		}
		heap[par] = temp;
		heap_size--;
		return ret;
	}
	
	
//	static void push(int data) {
//		int target = heap_size + 1;
//		while(target != 1 && heap[target / 2] < data) {
//			heap[target] = heap[target / 2];
//			target /= 2;
//		}
//		heap[target] = data;
//		++heap_size;
//	}
//	
//	static int pop() {
//		int par = 1, child = 2;
//		int ret = heap[1];
//		int temp = heap[heap_size];
//		while(child < heap_size) {
//			if(child + 1 < heap_size && heap[child] < heap[child+1]) {
//				++child;
//			}
//			if(temp >= heap[child]) {
//				break;
//			}
//			heap[par] = heap[child];
//			par = child;
//			child *= 2;
//		}
//		heap[par] = temp;
//		--heap_size;
//		return ret;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
