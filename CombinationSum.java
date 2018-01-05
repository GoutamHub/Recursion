package Recursion;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Goutam on 12/29/2017.
 */
public class CombinationSum {

    static void findNumbers(List<Integer> ar, int sum, List<List<Integer>> res, List<Integer> r, int i) {
        // If current sum becomes negative
        if (sum < 0)
            return;

        // if we get exact answer
        if (sum == 0) {
            res.add(new ArrayList<Integer>(r));
            return;
        }

        // Recur for all remaining elements that
        // have value smaller than sum.
        while (i < ar.size() && sum - ar.get(i) >= 0) {

            // Till every element in the array starting
            // from i which can contribute to the sum
            r.add(ar.get(i)); // add them to list
            
            // recur for next numbers
            findNumbers(ar, sum - ar.get(i), res, r, ++i);
            /*If Duplicate count is allow, then above call should be with i and have to put i++ in below line*/;
            
            // remove number from list (backtracking)
            r.remove(r.size() - 1);
        }
    }
    
    
    //Returns all combinations of ar[] that have given sum
    public static List<List<Integer>> combinationSum(List<Integer> ar, int sum) {
        // sort input array
        Collections.sort(ar);
        List<Integer> r = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        findNumbers(ar, sum, res, r, 0);
        return res;
    }
    
    public static void main(String args[]){
        //Set<Integer> ar = new HashSet<>();
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(10);
        ar.add(1);
        ar.add(2);
        ar.add(7);
        ar.add(1);
        ar.add(6);
        ar.add(5);
        
        
        
        
        int sum = 8;
        List<List<Integer>> result = combinationSum(new ArrayList<Integer>(ar), sum);
        
        if(result.isEmpty()){
            System.out.println("Empty");
        }

        for (int i = 0; i < result.size(); i++) {
                System.out.print(" ( ");
                List<Integer> innerList = result.get(i);
                for (int j = 0; j < innerList.size(); j++) {
                    System.out.print(innerList.get(j) + " ");
                }
                System.out.print(")");
        }
    }
}
