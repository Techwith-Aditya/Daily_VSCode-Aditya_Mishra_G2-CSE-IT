import java.util.*;
class Pair {
    int current;
    int  parent;
    Pair(int current, int parent) {
        this.current=current;
        this.parent=parent;
    }
}

public class DetectCycleinUndiGraph {
     public static boolean check(int source, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[source]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(source, -1));
        while(!q.isEmpty())
        {
            int node=q.peek().current;
            int parent=q.peek().parent;
            q.remove();

            for(int adjacent:adj.get(node))
            {
                if(vis[adjacent]==false)
                {
                    vis[adjacent]=true;
                    q.add(new Pair(adjacent, node));
                }
                else if(parent!=adjacent)
                {
                    return true;
                }
            }
        }
        return false;
     }

     public static boolean iscycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V+1];
        // JAVA already itself initialises to false to every index...
        // for(int i=0; i<=V; i++)
        // {
        //     vis[i]=false;
        // }
        for(int i=1; i<=V; i++)
        {
            if(vis[i]==false)
            {
                if(check(i, V, adj, vis))
                {
                    return true;
                }
            }
        }
        return false;
     }

     public static void main(String[] args) {
        int V=7;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<=V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(3).add(6);
        adj.get(6).add(3);

        adj.get(5).add(7);
        adj.get(7).add(5);

        adj.get(6).add(7);
        adj.get(7).add(6);

        boolean ans=iscycle(V, adj);
        System.out.println(ans);
     }
}
