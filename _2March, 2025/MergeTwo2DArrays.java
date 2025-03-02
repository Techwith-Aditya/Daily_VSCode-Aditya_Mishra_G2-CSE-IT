import java.util.ArrayList;

public class MergeTwo2DArrays {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> a=new ArrayList<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i][0]==nums2[j][0])
            {
                a.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0])
            {
                a.add(nums1[i]);
                i++;
            }
            else
            {
                a.add(nums2[j]);
                j++;
            }
        }

        while(i<nums1.length)
        {
            a.add(nums1[i]);
            i++;
        }

        while(j<nums2.length)
        {
            a.add(nums2[j]);
            j++;
        }

        // return a.toArray(new int[a.size()][]);
        int[][] result=new int[a.size()][];
        for(int index=0; index<a.size(); index++)
        {
            result[index]=a.get(index);
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] given1={
            {1,2},
            {2,3},
            {4,5}
        };

        int[][] given2={
            {1,4},
            {3,2},
            {4,1}
        };

        int[][] ans=mergeArrays(given1, given2);
        for(int i=0; i<ans.length; i++)
        {
            for(int j=0; j<2; j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
