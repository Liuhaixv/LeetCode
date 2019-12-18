package Level_286_Unsolved;

public class Main {
    public static void main(String[] args) {
        int [][]rooms1 = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        int [][]rooms2 = {
                {2147483647,-1,0,2147483647},
                {-1,-1,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}};
        for(int[] x:rooms1){
            for(int y:x){
                if(y==2147483647)
                    System.out.printf("INF"+" ");
                else
                    System.out.printf(y+" ");
            }
            System.out.println();
        }
        System.out.println();

        new Solution().wallsAndGates(rooms1);

        for(int[] x:rooms1){
            for(int y:x){
                if(y==2147483647)
                    System.out.printf("INF"+" ");
                else
                System.out.printf(y+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
