package Recursion;

public class practise {
public static void printinc(int n) {
	if(n==1) {
		System.out.print(n+" ");
		return ;
		
	}
	printinc(n-1);
	System.out.print(n+" ");
} 
public static int facto(int n) {
	if(n==0) {
	return 1;	}
	int fnm1=facto(n-1);
	int fn=n*fnm1;
	return fn;
}
public static int SumofN(int n) {
	if(n==1) {
		return 1;	}
		int snm1=SumofN(n-1);
	int sn=n+snm1;
	return sn;
}
public static int fibonacci(int n) {
	if(n==0) {
		return 0;
	}
	if(n==1) {
		return 1;
	}
int fbnm2=fibonacci(n-2);
int fbnm1 = fibonacci(n-1);
int fbn=fbnm1+fbnm2;
return fbn;
}
public static boolean isSorted(int arr[],int i) {
	if(i==arr.length-1) {
		return true;
	}
	if(arr[i]>arr[i+1]) {
		
		return false;
	}
	return isSorted(arr,i+1);
}
public static int firstoccurence(int arr[],int i,int key) {
	if(arr[i]==arr.length-1) {
		return -1;
	}
	if(arr[i]==key) {
		return i;

	}
	return firstoccurence(arr, i+1, key);
}
public static int lastoccurence(int arr[],int i,int key) {
	if(arr[i]==arr.length-1) {
		return -1;
	}
	int isFound =lastoccurence(arr, i+1, key);
	if(isFound==-1&&arr[i]==key) {
		return i;
	}
	return isFound;
}
public static int power(int n,int x) {
	if(n==0) {
		return x;
	}
	int xnm1=power(n-1, x);
	int xn=x*xnm1;
	return xn;
}
public static int optimizedpower(int n,int x) {
	if(n-1==0) {
		return x;
	}
	int halfpower=optimizedpower(n/2, x);
	int halfpowersquare=halfpower*halfpower;
	if(n%2!=0) {
		halfpowersquare=halfpowersquare*x;
	}
	return halfpowersquare;
}
public static void main (String args[]) {
	 int n=50,x=2;
			 
System.out.println(optimizedpower(n, x));
}
}
