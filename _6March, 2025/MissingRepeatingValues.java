public class MissingRepeatingValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int totalElements=0;
        for(int[] row:grid) 
        {
            totalElements=totalElements+row.length;
        }
        int[] count=new int[totalElements+1];
        for(int[] row:grid) 
        {
            for(int num:row) 
            {
                count[num]++;
            }
        }
        int repeating=-1, missing=-1;
        for(int i=1; i<=totalElements; i++) 
        {
            if(count[i]==2)
            {
                repeating=i;
            } 
            else if(count[i]==0) 
            {
                missing=i;
            }
        }
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[][] given= {
            {9,1,7},
            {8,9,2},
            {3,4,2}
        };
        int[] ans=findMissingAndRepeatedValues(given);
        for(int i=0; i<ans.length; i++)
        {
            if(i==0)
            {
                System.out.print("[");
            }
            System.out.print(+ans[i]);
            if(i!=ans.length-1)
            {
                System.out.print(",");
            }
            if(i==ans.length-1)
            {
                System.out.print("]");
            }
        }
    }    
}
