import java.util.*;
class Pair {
    int first;
    int second;
    int time;
    Pair(int first, int second, int time) {
        this.first=first;
        this.second=second;
        this.time=time;
    }
}
class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int countFresh=0;
        int[][] vis=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i, j, 0));
                }

                if(grid[i][j]==1)
                {
                    countFresh++;
                }
            }
        }

        int time=0;
        int[] possibleRowMoves={-1,0,+1,0};
        int[] possibleColMoves={0,+1,0,-1};
        int count=0; // tracks how many fresh oranges have rotted during the BFS traversal
        while(!q.isEmpty()) {
            int nx=q.peek().first; // q k ith part ko retrieve krne k liye...
            int ny=q.peek().second; // q k jth part ko retrieve krne k liye...
            int t=q.peek().time; // q se time retrieve krne k liye...
            time=Math.max(time, t);
            q.remove();

            for(int i=0; i<4; i++)
            {
                int nrow=nx+possibleRowMoves[i];
                int ncol=ny+possibleColMoves[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol]=2;
                    count++;
                }
            }
        }
        if(count!=countFresh)
        {
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] mat={
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int ans=orangesRotting(mat);
        System.out.println(ans);
    }
}
