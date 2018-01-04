package Recursion;

/**
 * Created by Goutam on 12/20/2017.
 */
public class FloodFill {
    private static void floodfill(int screen[][], int x, int y, int prevC, int newC) {
        if(x<0 || x>=8 || y<0 || y>=8)
            return;
        
        if(screen[x][y] != prevC)
            return;
        
        screen[x][y] = newC;
        
        floodfill(screen, x-1, y, prevC, newC);
        floodfill(screen, x+1, y, prevC, newC);
        floodfill(screen, x, y+1, prevC, newC);
        floodfill(screen, x, y-1, prevC, newC);
    }
    
    private static void floodfill(int screen[][], int x, int y, int newC){
        int prevC = screen[x][y];

        if(prevC == newC)
            return;

        floodfill(screen, x, y, prevC, newC);
    }
    
    public static void main(String args[]){
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        
        int x=4;
        int y=4;
        int newC = 3;
        floodfill(screen, x, y, newC);
        
        System.out.println("Updated Screen with New Color:");
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(screen[i][j] + ", ");
            System.out.print("\n");
        }
    }
}
