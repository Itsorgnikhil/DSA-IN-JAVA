package Arrays;


//package start1;
//
//public class kadaness_algorithm {
//
//	
//
//	public static void kadanes(int num[]) {
//		int cs=0;
//		int ms=Integer.MIN_VALUE;
//		for(int i=0;i<num.length;i++) {
//			cs=cs+num[i];
//			if(cs<0) {
//				cs=0;
//			}
//			ms=Math.max(cs,ms);
//		}
//		System.out.println("maximum sub array is"+" "+ms);
//	}
//public static void main(String args[]) {
//	int num[]= {2,-4,6,-8,10};
//	kadanes(num);
//	
//}
//}



/// full fleged kadaness

public class Kadaness_algo{

	

	public static void kadanes(int num[]) {
		int cs=0;
		int ms=Integer.MIN_VALUE;
		int nms=Integer.MIN_VALUE;
		
		for(int i=0;i<num.length;i++) {
			cs=cs+num[i];
			if(cs<0) {
				cs=0;
			}
			ms=Math.max(cs,ms);
		
			 if (ms==0) {
			nms=Math.max(num[i],nms);
			System.out.println("maximum sub array is"+" "+nms);
			break;
		}}
		if(ms!=0){
		System.out.println("maximum sub array is"+" "+ms);}
	}
public static void main(String args[]) {
	int num[]= {2,-4,-6,-8,-10};
	kadanes(num);
	
}
}
