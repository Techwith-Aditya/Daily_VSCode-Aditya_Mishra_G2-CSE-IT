import java.util.*;

public class RatMaze {
   public static ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        String path = "";
        
        if (mat[0][0]== 0) // not a valid starting point, so returns a empty list...
        {
            return ans;
        }
        
        solve(0, 0, mat, n, ans, visited, path);
        return ans;
    }
    
    private static boolean isSafe(int newx, int newy, boolean[][] visited, int[][] mat, int n) {
        if (newx >= 0 && newx < n && newy >= 0 && newy < n && !visited[newx][newy] && mat[newx][newy] == 1) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    private static void solve(int x, int y, int[][] mat, int n, ArrayList<String> ans, boolean[][] visited, String path) {
        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }
        
        visited[x][y] = true;

        // Down
        if (isSafe(x + 1, y, visited, mat, n)) 
        {
            solve(x + 1, y, mat, n, ans, visited, path + 'D');
        }

        // Left
        if (isSafe(x, y - 1, visited, mat, n)) 
        {
            solve(x, y - 1, mat, n, ans, visited, path + 'L');
        }

        // Right
        if (isSafe(x, y + 1, visited, mat, n)) 
        {
            solve(x, y + 1, mat, n, ans, visited, path + 'R');
        }

        // Up
        if (isSafe(x - 1, y, visited, mat, n)) 
        {
            solve(x - 1, y, mat, n, ans, visited, path + 'U');
        }

        visited[x][y] = false;
    } 

    public static void main(String[] args) {
        int[][] given={
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };
        ArrayList<String> ans=findPath(given);
        System.out.println(ans);
    }
}
