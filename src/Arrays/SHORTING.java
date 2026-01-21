
package Arrays;

public class SHORTING {
	
	
	
//// bubble shorting
	public static void bubble_sort(int arr[]) {
		
		for(int turn =0 ; turn < arr.length-1; turn++) {
			int swap=0;
			for(int j =0 ; j < arr.length-1-turn; j++) {
				
				if(arr[j]>arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =temp;
					swap++;
				}
				
			}
			if(swap==0) {
				break;
			}
		}
		for(int i =0 ; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
	
	
	
	
	
	
//// selection sorting 
public static void selection_sort(int arr[]) {
	for(int i=0; i<arr.length-1;i++) {
		
		int minpos=i;
	
		for(int j=i+1; j<arr.length; j++) {
		
			if(arr[minpos]>arr[j]) {
			
				minpos=j;
			}
		}
		// swap 
		int temp =arr[i];
		arr[i]=arr[minpos];
		arr[minpos]=temp;
		
	}
	for(int i =0 ; i < arr.length; i++) {
		System.out.print(" "+arr[i]);
	}
}









//// insertion sort
	
public static void insertion_sort(int arr[]) {
	for(int i=0;i<arr.length;i++) {
		int curr = arr[i];
		int prev = i-1;
		
		while(prev >= 0 && arr[prev] > curr) {
			arr[prev+1]=arr[prev];
			prev--;
			
		}
		//insertion 
		
		arr[prev+1] = curr;
		
	}
	for(int i =0 ; i < arr.length; i++) {
		System.out.print(" "+arr[i]);
	}
}










///counting sort
public static void counting_sort(int arr[]) {
	int largest=Integer.MIN_VALUE;
	
	for(int i=0;i<arr.length;i++) {
		largest=Math.max(largest, arr[i]);
	}
	
	int count[]=new int[largest+1];
	for(int i=0;i<arr.length;i++) {
		count[arr[i]]++;
	}
	
	/// sorting
	int j=0;
	for(int i=0;i<count.length;i++) {
		while(count[i]>0) {
			arr[j]=i;
			j++;
			count[i]--;
		}
	}
	
	for(int i =0 ; i < arr.length; i++) {
		System.out.print(" "+arr[i]);
	}
	
	
}
	
	public static void main(String[] args) {
	int arr[]= {5,1,1,3,2};
counting_sort(arr);
	}

}
 


