import java.util.Scanner;

public class MyHeap1 {
	
	int[] arr;
	int numOfElements = 0;
	
	public MyHeap1(int size) {
		arr = new int[size + 1];
	}
	
	void insert(int key) {
		if (isFull()) {
			System.out.println("Heap is full!");
			return;
		}
		
		numOfElements++;
		arr[numOfElements] = key;
		
		bubbleUp(numOfElements);
	}
	
	int findMin() {
		return arr[1];
	}
	
	int deleteMin() {
		if (isEmpty()) {
			System.out.println("Heap is empty!");
			return -1;
		}
		
		int min = arr[1];
		
		arr[1] = arr[numOfElements];
		numOfElements--;
		
		if (!isEmpty())
			bubbleDown(1);
		
		return min;
	}
	
	boolean isEmpty() {
		return numOfElements == 0;
	}
	
	boolean isFull() {
		return numOfElements >= arr.length -1;
	}
	
	boolean isRoot(int i) {
		return i == 1;
	}
	
	boolean isLeaf(int i) {
		return i > 0.5 * numOfElements;
	}
	
	void bubbleUp(int c) {
		if (isRoot(c)) return;
			
		int p = c/2;
			
		if (arr[c] < arr[p]) {
			swap(c, p);
			bubbleUp(p);
		}
	}
	
	void bubbleDown(int p) {
		if (isLeaf(p)) return;
		
		int l = p * 2;
		int r = l + 1;
		int c = l;
		
		if (r <= numOfElements && arr[l] > arr[r])
			c = r;
		
		if (arr[c] < arr[p]) {
			swap(c, p);
			bubbleDown(c);
		}
	}
	
	void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i=1; i<= numOfElements; i++)
			str += arr[i] + " ";
		
		return str;
	}

	public static void main(String[] args) {
		
		MyHeap1 heap = new MyHeap1(10);
				
		Scanner scanner = new Scanner(System.in);
		char c;
		int x;
		String input;
		while(true) {
			System.out.println("Use \"+\" to add an integer;");
			System.out.println("Use \"-\" to delete the minimum value;");
			System.out.println("Use \"*\" to find the minimum value.");
			System.out.print("Input: ");
			input = scanner.nextLine();
			c = input.charAt(0);

			switch (c) {
			case '+':
				x = Integer.parseInt(input.substring(1, input.length()));
				heap.insert(x);
				break;
			case '-':
				x = heap.deleteMin();
				if (x >=0) 
					System.out.println("Delete " + x);
				break;
			case '*':
				x = heap.findMin();
				if (x >=0)
					System.out.println("Minimum value is " + x);
				break;
			}
			
			System.out.println("The numbers in the heap: " + heap + "\n\n");
		}
	}

}
