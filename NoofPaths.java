package Recursion;

/**
 * Created by Goutam on 12/21/2017.
 */
public class NoofPaths {
    private static int numberOfPaths(int x, int y){
        if(x == 1 || y == 1)
            return 1;
        return (numberOfPaths(x-1, y) + numberOfPaths(x, y-1));
        /*if Diagonal movement allowed, then we should consider numberOfPaths(x-1,y-1) along with above return*/
    }
    public static void main(String args[]){
        System.out.print("Total no of different paths: " + numberOfPaths(3,3));
    }
    
}
