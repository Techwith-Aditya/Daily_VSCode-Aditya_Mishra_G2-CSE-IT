import java.util.*;

public class BFSGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()) 
        {
            int node=q.poll();
            bfs.add(node);

            for(int neighbor : adj.get(node)) 
            {
                if(vis[neighbor]==false) 
                {
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0; i<V; i++) 
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


        BFSGraph b=new BFSGraph();
        ArrayList<Integer> bfsResult = b.bfsOfGraph(V, adj);

        System.out.println("BFS Traversal: " + bfsResult);
    }
}
