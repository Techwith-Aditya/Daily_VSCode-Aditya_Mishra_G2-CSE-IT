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
