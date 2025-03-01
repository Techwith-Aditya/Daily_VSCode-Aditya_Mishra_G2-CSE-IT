public class FloodFillGraph {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int[][] ans=image;
        
        int[] possibleRowMovements={-1, 0, +1, 0};
        int[] possibleColMovements={0, +1, 0, -1};
        dfs(sr, sc, ans, image, color, possibleRowMovements, possibleColMovements, initialColor);
        return ans;
    }

    static void dfs(int row, int col, int[][] ans, int[][] image, int color, int[] possibleRowMovements, int[] possibleColMovements, int initialColor) {
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0; i<4; i++)
        {
            int nrow=row+possibleRowMovements[i];
            int ncol=col+possibleColMovements[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initialColor && ans[nrow][ncol]!=color)
            {
                dfs(nrow, ncol, ans, image, color, possibleRowMovements, possibleColMovements, initialColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image={
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr=1;
        int sc=1;
        int color=2;
        int[][] ans=floodFill(image, sr, sc, color);
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
