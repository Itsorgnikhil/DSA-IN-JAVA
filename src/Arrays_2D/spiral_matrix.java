package Arrays_2D;

import java.util.Scanner;

public class spiral_matrix {
public static void spiral(int arr[][]) {
	int n=arr.length;
	int m=arr[0].length;
int start_row = 0;
int start_col = 0;
int end_row = n-1;
int end_col = m-1;

while(start_row<=end_row && start_col<=end_col) {
	// top part
	for(int j = start_col;j<=end_col;j++) {
		System.out.print(arr[start_row][j]+" ");
	}
		//right part
		for(int i=start_row+1;i<=end_row;i++) {
			System.out.print(arr[i][end_col]+" ");
		}
		//bottom part
		for(int j=end_col-1;j>=start_col;j--) {
			if(start_row==end_row) {
				break;
		}
			System.out.print(arr[end_row][j]+" ");
	}
		for(int i=end_row-1;i>=start_row+1;i--) {
			if(start_col==end_col) {
				break;
			}
			System.out.print(arr[i][start_col]+" ");
		}
		start_col++;
		start_row++;
		end_col--;
		end_row--;
}
	
	System.out.println();
	
}
public static void main(String args[]) {
	int arr[][] = {{1,2,3,4,5,},
		          {6,7,8,9,10,},
		         {11,12,13,14,15,},
		         {16,17,18,19,20},
		         {21,22,23,24,25}};
	spiral(arr);
}

}

