import java.util.*;

public class CycleDetectionInDirectedGraph {
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int[] visited=new int[adj.size()];
        int[] pathVisited=new int[adj.size()];
        
        for(int i=0; i<adj.size(); i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i, adj, visited, pathVisited)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[node]=1;
        pathVisited[node]=1;
        
        for(int i:adj.get(node))
        {
            if(visited[i]==0)
            {
                if(dfs(i,adj,visited,pathVisited)==true)
                {
                    return true;
                }
            }
            else if(pathVisited[i]==1)
            {
                return true;
            }
        }
        
        pathVisited[node]=0;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<4; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);

        boolean ans=isCyclic(adj);
        System.out.println(ans);
    }
}
