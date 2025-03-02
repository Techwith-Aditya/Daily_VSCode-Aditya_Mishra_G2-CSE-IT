public class NoOfTriangles {
    
    static int countTriangles(int[][] graph, boolean isDirected) {
        int V=graph.length;
        int count_Triangle=0;

        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                for(int k=0; k<V; k++)
                {
                    if(graph[i][j]==1 && graph[j][k]==1 && graph[k][i]==1)
                    {
                        count_Triangle++;
                    }
                }
            }
        }

        if(isDirected) 
        {
            count_Triangle=count_Triangle/3;
        } 
        else 
        {
            count_Triangle=count_Triangle/6;
        }

        return count_Triangle;
    }

    public static void main(String[] args) {
        int[][] graph={
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        boolean isDirected=false;
        System.out.println("Number of triangles: " + countTriangles(graph, isDirected));
    }
}
