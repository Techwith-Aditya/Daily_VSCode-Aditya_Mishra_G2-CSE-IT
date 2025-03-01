import java.util.*;
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first=first;
        this.second=second;
    }
}
public class NoOfIslandGraph{
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] vis=new int[n][m];
        int count=0;
        
        for(int row=0; row<n; row++)
        {
            for(int col=0; col<m; col++)
            {
                if(vis[row][col]==0 && grid[row][col]=='1') 
                {
                    count++;
                    bfs(row, col, vis, grid);
                    
                }
            }
        }
        return count;
    }
    
    static void bfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row, col));
        int n=grid.length;
        int m=grid[0].length;
        
        while(!q.isEmpty())
        {
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            
            for(int rowChange=-1; rowChange<=1; rowChange++)
            {
                for(int colChange=-1; colChange<=1; colChange++)
                {
                    int nrow=r+rowChange;
                    int ncol=c+colChange;
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0)
                    {
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] mat={
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };

        int ans=numIslands(mat);
        System.out.println(ans);
    }
}
