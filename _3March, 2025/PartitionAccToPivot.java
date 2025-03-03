public class PartitionAccToPivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] ans=new int[nums.length];
        int index=0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]<pivot)
            {
                ans[index++]=nums[i];
            }
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==pivot)
            {
                ans[index++]=nums[i];
            }
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>pivot)
            {
                ans[index++]=nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] given={9,12,5,10,14,3,10};
        int[] ans=pivotArray(given, 10);
        for(int i=0; i<ans.length; i++)
        {
            System.out.print(ans[i]);
            if(i!=ans.length-1)
            {
                System.out.print(",");
            }
        }
    }
}
