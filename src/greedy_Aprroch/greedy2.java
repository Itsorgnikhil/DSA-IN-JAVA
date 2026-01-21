//package greedy_Aprroch;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class greedy2 {
//
//	public static void main(String args[]) {
//        int val[] = {60, 100, 120};     // values of items
//        int weight[] = {10, 20, 30};    // weights of items
//        int w = 50;                     // total capacity of knapsack
//
//        // ratio[i][0] = index, ratio[i][1] = value/weight ratio
//        double ratio[][] = new double[val.length][2];
//
//        for (int i = 0; i < val.length; i++) {
//            ratio[i][0] = i;
//            ratio[i][1] = val[i] / (double) weight[i];  // compute value-to-weight ratio
//        }
//
//        // sort items by ratio in ascending order (lowest first)
//        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
//
//        int capacity = w;
//        double finalVal = 0;   // total profit
//
//        // iterate from highest ratio (last element) to lowest
//        for (int i = ratio.length - 1; i >= 0; i--) {
//            int idx = (int) ratio[i][0];  // get original index of item
//
//            if (capacity >= weight[idx]) {
//                // take the whole item
//                finalVal += val[idx];         // add full value
//                capacity -= weight[idx];      // reduce capacity
//            } else {
//                // take fraction of the item
//                finalVal += ratio[i][1] * capacity; // value/weight * remaining capacity
//                capacity = 0;                         // knapsack is full
//                break;                                // stop
//            }
//        }
//
//        System.out.println("Maximum value in knapsack = " + finalVal);
//
//        /*
//        ================= DRY RUN =================
//        Input:
//          val[] = {60,100,120}
//          weight[] = {10,20,30}
//          W = 50
//
//        Step 1: Calculate ratios
//          Item0: 60/10 = 6.0
//          Item1: 100/20 = 5.0
//          Item2: 120/30 = 4.0
//          ratio = {{0,6.0}, {1,5.0}, {2,4.0}}
//
//        Step 2: Sort ascending by ratio
//          → {{2,4.0}, {1,5.0}, {0,6.0}}
//
//        Step 3: Traverse from highest ratio (end of array)
//
//          - Pick Item0 (ratio 6, weight=10, value=60)
//            capacity=50 ≥ 10 → take full
//            finalVal = 60, capacity = 40
//
//          - Pick Item1 (ratio 5, weight=20, value=100)
//            capacity=40 ≥ 20 → take full
//            finalVal = 160, capacity = 20
//
//          - Pick Item2 (ratio 4, weight=30, value=120)
//            capacity=20 < 30 → take fraction
//            fraction = 20/30 → value = 20 * 4 = 80
//            finalVal = 160 + 80 = 240
//            capacity = 0 → stop
//
//        Step 4: Result
//          Maximum value in knapsack = 240
//        ==========================================
//        */
//    }
//}

package greedy_Aprroch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class greedy2 {
public static void main(String args[]) {
	
	int start[] = {10,12,20};
	int end[]= {20,25,30};
	//sorting
	int activities [] [] =new int [start.length] [3];
	for(int i=0;i<start.length;i++) {
		activities[i][0]=i;
		activities[i][1] =start[i];
		activities[i][2] =end[i];
		
	}
	//lambda function for shorting
	Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
	
	// end time basis sort
	int maxAct =0;
	ArrayList<Integer> ans= new ArrayList<>();
	// 1st activity
	maxAct=1;
      ans.add(activities[0][0]);
      int lastEnd = activities[0][2];
      for(int i=1;i<end.length;i++) {
    	  if(activities[i][1]>=lastEnd) {
    		  //activity select 
    		  maxAct++;
    		  ans.add(activities[i][0]);
    		  lastEnd=activities[i][2];
    	  }
      }
      System.out.println("max activities ="+maxAct);
      for(int i=0;i<ans.size();i++) {
    	  System.out.println("A"+ans.get(i)+" ");
      }
      System.out.println();
}
}

