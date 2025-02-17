import java.util.*;

public class LegoBricks {
    static int minRepaintingCost(int[] bricks) {
        Arrays.sort(bricks);
        int cost=0;
        for(int i=1; i <bricks.length; i++) 
        {
            if(bricks[i]==bricks[i-1]) 
            {
                int newColor=bricks[i-1]+1;
                cost=cost+Math.abs(bricks[i]-newColor);
                bricks[i]=newColor;
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of Lego bricks: ");
        int N=sc.nextInt();
        int[] bricks=new int[N];
        for(int i=0; i<N; i++) 
        {
            System.out.print("Enter the brick "+(i+1)+": ");
            bricks[i]=sc.nextInt();
        }

        System.out.println(minRepaintingCost(bricks));
        sc.close();
    }
}
