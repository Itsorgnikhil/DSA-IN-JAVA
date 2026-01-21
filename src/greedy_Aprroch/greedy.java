package greedy_Aprroch;

import java.awt.JobAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class greedy {

	// chocola problem
	
	/*public static void main(String args[]) {
        int n = 4, m = 6;

        // Vertical cuts cost (m-1 values)
        Integer costVer[] = {2, 1, 3, 1, 4};
        // Horizontal cuts cost (n-1 values)
        Integer costHor[] = {4, 1, 2};

        // Sort in descending order (greedy: take max cost first)
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // pointers for horizontal & vertical cuts
        int hp = 1, vp = 1; // number of horizontal & vertical pieces
        int cost = 0;

        // Process cuts until one list is exhausted
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // take horizontal cut
                cost += costHor[h] * vp;  // multiply cost by current vertical pieces
                hp++;                     // horizontal pieces increase
                h++;
            } else { // take vertical cut
                cost += costVer[v] * hp;  // multiply cost by current horizontal pieces
                vp++;                     // vertical pieces increase
                v++;
            }
        }

        // If horizontal cuts remain
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // If vertical cuts remain
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("Min cost of cuts = " + cost);
*/
        /*
        ================== DRY RUN ==================
        Input:
          n = 4, m = 6
          costVer = {2, 1, 3, 1, 4} -> sorted desc = {4, 3, 2, 1, 1}
          costHor = {4, 1, 2} -> sorted desc = {4, 2, 1}

        Initial:
          hp = 1, vp = 1, cost = 0

        Step 1: Compare costVer[0]=4 and costHor[0]=4
                Equal → take horizontal cut
                cost += 4 * vp(1) = 4
                hp = 2, h = 1
                cost = 4

        Step 2: Compare costVer[0]=4 and costHor[1]=2
                4 > 2 → take vertical cut
                cost += 4 * hp(2) = 8
                vp = 2, v = 1
                cost = 12

        Step 3: Compare costVer[1]=3 and costHor[1]=2
                3 > 2 → take vertical cut
                cost += 3 * hp(2) = 6
                vp = 3, v = 2
                cost = 18

        Step 4: Compare costVer[2]=2 and costHor[1]=2
                Equal → take horizontal cut
                cost += 2 * vp(3) = 6
                hp = 3, h = 2
                cost = 24

        Step 5: Compare costVer[2]=2 and costHor[2]=1
                2 > 1 → take vertical cut
                cost += 2 * hp(3) = 6
                vp = 4, v = 3
                cost = 30

        Step 6: costVer[3]=1 vs costHor[2]=1
                Equal → take horizontal cut
                cost += 1 * vp(4) = 4
                hp = 4, h = 3
                cost = 34

        Now horizontal cuts are finished.
        Remaining vertical cuts:
          cost += 1 * hp(4) = 4  → cost = 38
          cost += 1 * hp(4) = 4  → cost = 42

        Final Answer:
          Min cost of cuts = 42
        ===========================================
        */
	
	
	
	
//                     	JOB SEQUENCE PROBLEM
	/*
    static class job {
        int deadline;
        int profit;
        int id;

        public job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String args[]) {

        // job info: {deadline, profit}
        int jobsinfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<job> jobs = new ArrayList<>();

        // store jobs into objects
        for (int i = 0; i < jobsinfo.length; i++) {
            jobs.add(new job(i, jobsinfo[i][0], jobsinfo[i][1]));
        }

        // sort jobs in descending order of profit
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>(); // to store job IDs
        int time = 0; // keep track of scheduled jobs

        // Greedy: pick jobs one by one if deadline allows
        for (int i = 0; i < jobs.size(); i++) {
            job curr = jobs.get(i);
            if (curr.deadline > time) {  // can we fit this job before its deadline?
                seq.add(curr.id);        // take the job
                time++;                  // one more job scheduled
            }
        }

        // print results
        System.out.println("Max jobs = " + seq.size());
        System.out.print("Job sequence: ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print("J" + seq.get(i) + " ");
        }
        System.out.println();*/

        /*
        ================= DRY RUN =================
        Input:
          jobsinfo = {{4,20},{1,10},{1,40},{1,30}}
          → Jobs: J0(dead=4, profit=20), J1(dead=1, profit=10),
                  J2(dead=1, profit=40), J3(dead=1, profit=30)

        Step 1: Sort by profit (descending)
          → J2(40, d=1), J3(30, d=1), J0(20, d=4), J1(10, d=1)

        Step 2: Start with time=0, seq = {}

          - Take J2: deadline=1 > time=0 → YES
            seq={J2}, time=1

          - Take J3: deadline=1 > time=1 → NO
            skip

          - Take J0: deadline=4 > time=1 → YES
            seq={J2, J0}, time=2

          - Take J1: deadline=1 > time=2 → NO
            skip

        Step 3: Final results:
          Max jobs = 2
          Sequence = J2 J0
        ==========================================
        */
	
	
	
	
             //	indian coins question
	
	
//	public static void main(String args[]) {
//		Integer coins[] = {1,2,5,10,20,50,100,500,2000};
//		
//		Arrays.sort(coins,Comparator.reverseOrder());
//		
//		int count_of_coins =0;
//		int amount=590;
//		
//		ArrayList<Integer> ans = new ArrayList<>();
//		for(int i=0;i<coins.length;i++) {
//			if(coins[i]<amount) {
//				while(coins[i]<=amount) {
//					count_of_coins++;
//					ans.add(coins[i]);
//					amount-=coins[i];
//				}
//			}
//		}
//		System.out.println("total minimum coins used ="+count_of_coins);
//		for(int i=0;i<ans.size();i++) {
//			System.out.print(ans.get(i)+" ");
//		}
//		System.out.println();
//	}

	
	  // maximum chain length of pairs
	
//	public static void main(String args[]) {
//		int pairs[] [] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
//		
//		Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
//	
//		
//		int chainLen =1;
//		int chainEnd =pairs[0][1];
//		//last selected pair end //chain end
//		
//		for(int i=1;i<pairs.length;i++) {
//			if(pairs[i][0]>chainEnd) {
//				//last selected 
//				chainLen++;
//				chainEnd = pairs[i][1];
//				
//			}
//		}
//		System.out.println("max length of chain "+ chainLen);
//	}
	
	public static void main (String args[]) {
		int a []= {1,2,3};
		int b []= {2,1,3};
		
		
		Arrays.sort(a);
	Arrays.sort(b);
	
	int minDiff = 0;
	for(int i=0;i<a.length;i++) {
		minDiff+=Math.abs(a[i]-b[i]);
	}
	System.out.println("min absolute diff of pairs"+" "+minDiff);
 	}
}