package Heap;

public class HeapSort {
	
	public static void heapify(int i, int size,int arr[]) {
		int left = 2*i+1;
		int right = 2*i+2;
		int maxIdx=i; 
		
		if(left<size&& arr[maxIdx]< arr[left]) {
			maxIdx = left;
		}
		
		if(right<size&& arr[maxIdx]< arr[right]) {
			maxIdx = right;
		}
		
		if(maxIdx!=i) {
			//swap
			int temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx]=temp;
		 heapify(maxIdx, size, arr);
		}
	}
public static void heapSort(int arr[]) {
	// step 1 - build maxheap
	int n= arr.length;
	for (int i=n/2;i>=0;i--) {
		heapify(i,n, arr);
	}
	
	//step 2 - push largest at end
	for(int i=n-1;i>0;i--) {
		// swap lagest- first with last
		int temp = arr[0];
		arr[0]= arr[i];
		arr[i]=temp;
		
		heapify(0,i, arr);
	}
}
public static void main (String args[]) {
	int arr[]= {1,2,4,5,3};
	heapSort(arr);
	
	//print
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]+" ");
	}
	System.out.println(  );
}
}

////////////////// for descending order //////////////////////// 

//package Heap;
//
//public class HeapSort {
//	
//	public static void heapify(int i, int size,int arr[]) {
//		int left = 2*i+1;
//		int right = 2*i+2;
//		int minIdx=i; 
//		
//		if(left<size&& arr[minIdx]> arr[left]) {
//			minIdx = left;
//		}
//		
//		if(right<size&& arr[minIdx]> arr[right]) {
//			minIdx = right;
//		}
//		
//		if(minIdx!=i) {
//			//swap
//			int temp = arr[i];
//			arr[i] = arr[minIdx];
//			arr[minIdx]=temp;
//		 heapify(minIdx, size, arr);
//		}
//	}
//public static void heapSort(int arr[]) {
//	// step 1 - build minheap
//	int n= arr.length;
//	for (int i=n/2;i>=0;i--) {
//		heapify(i,n, arr);
//	}
//	
//	//step 2 - push largest at end
//	for(int i=n-1;i>0;i--) {
//		// swap lagest- first with last
//		int temp = arr[0];
//		arr[0]= arr[i];
//		arr[i]=temp;
//		
//		heapify(0,i, arr);
//	}
//}
//public static void main (String args[]) {
//	int arr[]= {1,2,4,5,3};
//	heapSort(arr);
//	
//	//print
//	for(int i=0;i<arr.length;i++) {
//		System.out.println(arr[i]+" ");
//	}
//	System.out.println(  );
//}
//}
