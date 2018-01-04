package Recursion;

/**
 * Created by Goutam on 12/28/2017.
 */
public class WaterOverFlowProblem {

    public static float findWaterInGlass(float inputAtTop, int rownum,int colnum){
        return findWaterInGlassInternal(inputAtTop,1,1,rownum,colnum);
    }

    public static float findWaterInGlassInternal(float input,int currentRow,int currentCol, int requiredRown,int requiredColnum){
        if(requiredColnum>requiredRown) 
            throw new RuntimeException("requiredColnum>requiredRown");
        
        if(currentRow==requiredRown){
            if(currentCol==requiredColnum)
                return Math.min(input,1);
            else
                return 0;
        }else{
            // Pour water in right side and in left side equally
            float waterForNextLevel = (input-1)/2;
            if(waterForNextLevel>0){
                float waterFromLeftBranch= findWaterInGlassInternal(waterForNextLevel,currentRow+1,currentCol,requiredRown,requiredColnum) ;
                float waterFromRightBranch	= findWaterInGlassInternal(waterForNextLevel,currentRow+1,currentCol+1,requiredRown,requiredColnum);
                return Math.min(waterFromLeftBranch+waterFromRightBranch,1);
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int row = 2;
        int waterQuantity = 3;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("findWaterInGlass(" + waterQuantity + "," + i + "," + j + ")=" + findWaterInGlass(waterQuantity, i, j));
            }
        }
    }
}
