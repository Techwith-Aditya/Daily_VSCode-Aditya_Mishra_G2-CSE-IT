// Distance of nearest cell having 1
import java.util.*;
class Node{
    int first;
    int second;
    int third;
    Node(int first, int second, int third) {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
public class DistanceOfNearestOneOrZero {
    public static int[][] nearest(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int vis[][]=new int[n][m];
        int dist[][]=new int [n][m];
        
        Queue<Node> q=new LinkedList<Node>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }
        
        int[] possibleRowMoves={-1, 0, +1, 0};
        int[] possibleColMoves={0, +1, 0, -1};
        
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            
            dist[row][col]=steps;
            for(int i=0; i<4; i++)
            {
                int nrow=row+possibleRowMoves[i];
                int ncol=col+possibleColMoves[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] given={
            {1,0,1},
            {1,1,0},
            {1,0,0}
        };

        int[][] ans=nearest(given);
        for(int i=0; i<ans.length; i++)
        {
            for(int j=0; j<ans[0].length; j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}

// 542. 01 Matrix of Leetcode: (return the distance of the nearest 0 for each cell)
// only one change in condition if(grid[i][j]==0)...
