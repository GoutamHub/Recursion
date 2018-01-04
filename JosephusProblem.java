package Recursion;

/**
 * Created by Goutam on 12/28/2017.
 */
public class JosephusProblem {
    
    private static int recursiveSol(int n, int k){
        if(n==1)
            return 1;
        
        return (recursiveSol(n-1, k)+k-1)%n + 1;
    }
    
    private static int iterativeSol(int n, int k){
        int result = 0;		// when n = 1
        for(int i = 2; i <= n; i++)
        {
            result = (result + k) % i;
        }
        return result+1;
    }
    
    public static void main(String args[]){
        int n = 7;
        int k = 3;
        System.out.println("The Last person to survive at position: " + recursiveSol(n, k));
        System.out.println("The Last person to survive at position: " + iterativeSol(n, k));
    }
}
