import java.util.Arrays;
import java.util.Random;

public class Hash {
	
	static char input[][] = new char[30000][10];
	int cmd[][] = new int[30000][2];
	
	int my_find[] = new int[30000];
	int stl_find[] = new int[30000];
	
	
	static int remove = 1;
	static int find = 2;
	
	static int PN = 31;
	static int HASH_SIZE = 10000; // �ؽ� ������� 1/3 ������ ����
	
	static int name_size;	
	static char[][] name = new char[30000][100];
	static int[][] table = new int[HASH_SIZE][30];

	public static void main(String[] args) {
		Random r = new Random();

		for(int i = 0; i < 1000000; ++i) {
		}
		long mymb = System.currentTimeMillis();
		long myme = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000; ++i) {
		}
		long stlmb = System.currentTimeMillis();
		long stlme = System.currentTimeMillis();
		
		System.out.println("mylist : " + (myme - mymb));
		System.out.println("stl : " + (stlme - stlmb));
	}
	
	static int get_key(char[] data) {
		int key = 0, len = data.length, p = 1;
		
		for(int i = 0; i < len; i++) {
			key += (p * data[i]);
			p *= PN;	
		}
		
		if(key < 0) {
			key *= -1;
		}
		return key % HASH_SIZE;
	}
	
	static boolean strcmp(char[] a, char[] b) {
		
		if(a.length != b.length) {
			return false;
		}
		
		int len = a.length < b.length ? a.length : b.length;
		
		for(int i = 0; i < len ; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static int contain(char[] data) {
		int key = get_key(data);
		int size = table[key][0];
		
		for(int i = 1; i <= size; i++) {
			if(strcmp(name[table[key][i]],data)) {
				return table[key][i];
			}
		}
		
		return -1;
	}
	
	static void add(char[] data) {
		int key = get_key(data);
		int size = table[key][0];
		
		for(int i = 0; i < data.length; i++) {
			name[name_size][i] = data[i];
		}
		
		table[key][++table[key][0]] = name_size;
		
		name_size++;
	}
	
	static boolean remove(char data[]) {
		int key = get_key(data);
		int size = table[key][0];
		for(int i = 1; i <= size; i++) {
			if(strcmp(name[table[key][i]],data)) {
				for(int j = i+1; j <= size; j++) {
					table[key][j-1] = table[key][j];
				}
				table[key][0]--;
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
//	static int get_key(char _name[]) {
//		int key = 0, p = 1;
//		for(int i = 0; _name[i] != 0; ++i) {
//			key += (_name[i] * p);
//			p *= PN;
//		}
//		
//		if(key < 0) key *= -1;
//		
//		return (key % HASH_SIZE);
//	}
//	
//	static boolean my_strcmp(char a[], char b[]) {
//		int alen = a.length;
//		int blen = b.length;
//		int len = alen < blen ? alen : blen;
//		for(int i = 0; i < len ; i++) {
//			if(a[i] != b[i]) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	static int contain(char _name[]) {
//		int key = get_key(_name);
//		int h_size = table[key][0];
//		for(int i = 1; i <= h_size; ++i ) {
//			int n_pos = table[key][i];
//			if(my_strcmp(name[n_pos], _name)) {
//				return n_pos;
//			}
//		}
//		return -1;
//	}
//	
//	static void add (char _name[]) {
//		int len;
//		for(len = 0; _name[len] != 0; ++len) {
//			name[name_size][len] = _name[len];
//		}
//		name[name_size][len] = 0;
//		
//		int key = get_key(_name);
//		table[key][++table[key][0]] = name_size;
//		
//		++name_size;
//	}
//	
//	static boolean remove(char _name[]) {
//		int key = get_key(_name);
//		for(int i = 1; i <= table[key][0]; ++i) {
//			int n_pos = table[key][i];
//			if(my_strcmp(name[n_pos], _name)) {
//				for(int j = i+1; j <= table[key][0]; ++j) {
//					table[key][j-1] = table[key][j];
//				}
//				--table[key][0];
//				return true;
//			}
//		}
//		return false;
//	}

}
