package Recursion;

/**
 * Created by Goutam on 12/22/2017.
 */
public class FindOptimal {
    
    private static int findOptimal(int N){
        if(N<=6)
            return N;
        
        int maxNo = 0;
        
        for(int b=N-3; b>=1; b--){
            int currNo = (N-b-1)*findOptimal(b);
            if(currNo>maxNo)
                maxNo = currNo;
        }
        return maxNo;
    }
    
    public static void main(String args[]){
        System.out.print("The maximum no of A's which can be print on the screen : " + findOptimal(7));
    }
}
