package Arrays;
/*
PSEUDO CODE
start = 0, end =n-1
while(start<=end)
find mid   ==( start + end ) / 2
compare mid & key
mid==key  found
mid>key    move left  1st end 
mid<key     move right  2nd start
*/

//time complexity is (log(n))

import java.util.*;

public class Searcing_algo {
public static int binary_search(int num[],int key) {
int start=0;int end=num.length-1;


while(start<=end) {
int mid=(start+end)/2;

if(num[mid]==key) {
return mid;
}
if(num[mid]<key) {
start=mid+1;
}
else {
end = mid-1;
}

}

return -1;


}

public static void main(String[] args) {
// TODO Auto-generated method stub
int num[]= {2,4,6,8,10,12,14,16,18};
int key = 10; 

System.out.println("the value you are searching is at"+" "+binary_search(num,key)+" "+"index");
}

}
//
//
//import java.util.Scanner;
//
//public class linear_search {
//public static int linear_search(int number[],int key) {
//	for (int i=0;i<number.length;i++) {
//		if(number[i]==key) {
//			return i;
//		}
//	}
//	return -1;
//}
//public static void main (String args[]) {
//
//	int number[]= {10,20,34,8490,949,49,4984,4949,97,};
//	Scanner sc =new Scanner(System.in);
//	int key = sc.nextInt();
//	
//int index=	linear_search(number, key);
//if(index==-1) {
//	System.out.println("not found");
//}
//else {
//	System.out.println("founded at index"+" "+index);
//}
//}
//}

