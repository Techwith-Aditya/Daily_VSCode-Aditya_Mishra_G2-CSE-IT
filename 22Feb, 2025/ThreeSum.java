import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++)
        {
            // If nums[i] == nums[i-1], it means the current number nums[i] has already been considered as the first element in a previous iteration...
            if(i>0 && nums[i]==nums[i-1]) 
            {
                continue;
            }

            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    // Important: .asList
                    l.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1])
                    {
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        right--;
                    }
                    left++;
                    right--;
                }

                if(sum<0)
                {
                    left++;
                }
                if(sum>0)
                {
                    right--;
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        ThreeSum t=new ThreeSum();
        int[] a={-1,0,1,2,-1,-4};
        List<List<Integer>> l=new ArrayList<>();
        l=t.threeSum(a);
        System.out.println("Result: "+l);
    }
}
