import java.util.*;

public class abcd {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        int N=5; // No of nodes...
        int M=6; // No of edges...

        for(int i=0; i<=N; i++)
        {
            a.add(new ArrayList<Integer>());
        }

        a.get(1).add(2);
        a.get(2).add(1);
        
        a.get(1).add(3);
        a.get(3).add(1);
        
        a.get(2).add(5);
        a.get(5).add(2);
        
        a.get(2).add(4);
        a.get(4).add(2);

        a.get(3).add(4);
        a.get(4).add(3);

        a.get(4).add(5);
        a.get(5).add(4);

        for(int i=1; i<=N; i++)
        {
            System.out.print("Node "+i+" is connected with: ");
            for(int j=0; j<a.get(i).size(); j++)
            {
                System.out.print(a.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}
