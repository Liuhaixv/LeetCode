package Level_286;
import static Level_286.Solution.INF;

public class Main {
    public static void main(String[] args) {
            int [][]rooms1 = {
                    {INF, INF, INF, INF, INF, INF, INF},
                    {INF, INF, INF, INF, INF, INF, INF},
                    {INF, INF, INF, INF, INF, INF, INF},
                    {INF, INF, INF, 0, INF, INF, INF},
                    {INF, INF, INF, INF, INF, INF, INF},
                    {INF, INF, INF, INF, INF, INF, INF},
                    {INF, INF, INF, INF, INF, INF, INF}
            };
        for(int[] x:rooms1){
            for(int y:x){
                if(y==INF)
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
                if(y==INF)
                    System.out.printf("INF"+" ");
                else
                System.out.printf(y+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
