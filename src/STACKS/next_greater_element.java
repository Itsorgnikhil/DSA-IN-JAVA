package STACKS;

import java.util.Stack;

public class next_greater_element {
    public static void main(String args[]) {
        
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nxtgen[] = new int[arr.length];
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nxtgen[i] = -1;
            } else {
                nxtgen[i] = arr[s.peek()];
            }
            s.push(i);
        }
        
        for (int i = 0; i < nxtgen.length; i++) {
            System.out.print(nxtgen[i] + " ");
        }
        System.out.println();
    }
}
