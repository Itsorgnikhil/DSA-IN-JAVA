package Arrays;



public class Trapping_rainwater {
public static int trapping_raiwater(int height[]) {
	int n=height.length;
	//first we have to calculate left max boundary array
	int left_max[]=new int[n];
	left_max[0]=height[0];
	for(int i=1;i<n;i++) {
		left_max[i]=Math.max(height[i],left_max[i-1]);
	}
	// second we have to calculate right max boundary array
	
	int right_max[]=new int[n];
	right_max[n-1]=height[n-1];
	for(int i=n-2;i>=0;i--) {
		right_max[i]=Math.max(height[i],right_max[i+1]);
	
	}
	
	// water level calculate
	int tapped_water=0;
	int water_leve;
	for(int i=0;i<n;i++) {
		water_leve =Math.min(left_max[i], right_max[i]);
	
	 tapped_water += water_leve - height[i];
	
	}
	
	return tapped_water;
}

public static void main(String []args) {
	int height[] = {4,2,0,6,3,2,5};
	System.out.println(trapping_raiwater(height));
	
}
}
