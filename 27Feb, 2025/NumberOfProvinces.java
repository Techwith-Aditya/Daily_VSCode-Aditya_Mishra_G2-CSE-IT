public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int vis[]=new int[n];
        int count=0;
                
        for(int i=0; i<n; i++) 
        {
            if(vis[i]==0) 
            {
                count++;
                dfs(i, isConnected, vis);
            }
        }  
        return count;
    }

    private static void dfs(int node, int[][] isConnected, int vis[]) {
        vis[node]=1;
        for(int i=0; i<isConnected.length; i++) 
        {
            if(isConnected[node][i]==1 && vis[i]==0) 
            {
                dfs(i, isConnected, vis);
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat={
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };
        int ans=findCircleNum(mat);
        System.out.println(ans);
    }
}
