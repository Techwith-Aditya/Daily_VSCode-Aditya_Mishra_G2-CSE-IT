import java.util.*;

public class DFSGraph {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[adj.size()+1];
        vis[0]=true;
        ArrayList<Integer> a=new ArrayList<>();
        dfs(0, vis, adj, a);
        return a;
    }
    
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> a) {
        vis[node]=true;
        a.add(node);
        
        for(Integer item:adj.get(node))
        {
            if(vis[item]==false)
            {
                dfs(item, vis, adj, a);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0; i<5; i++) 
        {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        DFSGraph d=new DFSGraph();
        ArrayList<Integer> bfsResult = d.dfsOfGraph(adj);

        System.out.println("DFS Traversal: " + bfsResult);
    }
}
