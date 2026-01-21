package divideconquere;

public class sorting {
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
public static void mergesort(int arr[],int si,int ei) {
	// base case
	if(si>=ei) {
		return ;
	}
	//kaam
	int mid = si+(ei-si)/2;  // (si+ei)/2
	mergesort(arr, si, mid); // left part
	mergesort(arr, mid+1, ei); // right part
	merge(arr, si,mid, ei);
}
public static void merge(int arr[],int si,int mid,int ei)
{
	int temp[]=new int [ei-si+1];
	int i=si; // iterator for left part 
	int j=mid+1; //   iterator for right part 
	int k=0;//iterator for temp array
	
	while(i<=mid && j<=ei) {
		if(arr[i]<arr[j]) {
			temp[k]=arr[i];
		i++;
		}else {
			temp[k]=arr[j];
			j++;
		}
		k++;
	}
	
	// left part main jo elelment bach gaye hai uke liye loop
	while (i<=mid) {
		temp[k++]=arr[i++];
	}
	//right part main jo elelment bach gaye hai uke liye loop
	while(j<=ei) {
		temp[k++]=arr[j++];
	}
	
	// copy temp to orignal arr
	
	for(k=0,i=si;k<temp.length;k++,i++) {
		arr[i]=temp[k];
	}
	
}
public static void Quicksort(int arr[],int si,int ei) {
	if(si>=ei) {
		return ;
	}
	//last element ya fir piviot
	int pIdx= Partition(arr, si, ei);
	Quicksort(arr, si, pIdx-1); // left 
	Quicksort(arr, pIdx+1, ei); // Right
}
public static int Partition(int arr[],int si,int ei) {
	int pivot = arr[ei];
	int i=si-1; //to make place for elements smaller than pivot
	for (int j=si;j<ei;j++) {
		if(arr[j]<=pivot) {
			i++;
			//swap
			int temp=arr[j];
			arr[j]= arr[i];
			arr[i]=temp;
			
		}
		
	}
	i++;
	int temp =pivot;
	arr[ei]=arr[i];
	arr[i]=temp;
	return i;
}
public static void main(String args[]) {
	int arr[]= {6,3,9,5,2,8};
	Quicksort(arr, 0, arr.length-1);
	printarray(arr);
}
	
}
