import java.util.*;

public class MinStepsByKnight {
    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int[][] MOVES = {
            {1, 2}, 
            {1, -2}, 
            {-1, 2}, 
            {-1, -2},
            
            {2, 1}, 
            {2, -1}, 
            {-2, 1}, 
            {-2, -1}
        };
        
        int x1=KnightPos[0]-1;
        int y1=KnightPos[1]-1;
        
        int x2=TargetPos[0]-1;
        int y2=TargetPos[1]-1;
        
        boolean[][] vis=new boolean[N][N];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x1, y1, 0});
        vis[x1][y1]=true;

        while (!q.isEmpty()) 
        {
            int[] curr=q.poll();
            
            int x=curr[0];
            int y=curr[1];
            int moves=curr[2];

            if(x==x2 && y==y2) 
            {
                return moves;
            }

            for(int[] move:MOVES) 
            {
                int nx=x+move[0], ny=y+move[1];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !vis[nx][ny]) 
                {
                    vis[nx][ny]=true;
                    q.add(new int[]{nx, ny, moves+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] knightPos={3, 10};
        int[] targetPos={4, 4};
        int result=minStepToReachTarget(knightPos, targetPos, 10);
        System.out.println("Minimum moves required: "+result);
    }
}
