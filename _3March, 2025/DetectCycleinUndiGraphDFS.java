import java.util.*;

public class DetectCycleinUndiGraphDFS {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        for(int i=0; i<V; i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i, -1, vis, adj))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;
        for(int adjacent:adj.get(node))
        {
            if(vis[adjacent]==0)
            {
                if(dfs(adjacent, node, vis, adj))
                {
                    return true;
                }
                else if(adjacent!=parent) 
                {
                    return true;
                }
            }
        }
        return false;
    }    

    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<=V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        boolean ans=isCycle(V, adj);
        System.out.println(ans);
    }
}
