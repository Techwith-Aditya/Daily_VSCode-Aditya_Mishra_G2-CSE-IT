import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> l=new ArrayList<>();
        if(nums.length<4)
        {
            return new ArrayList<>();
        }

        if(nums[0]==0 && nums[1]==0 && nums[2]==0 && nums[3]==0 && target==0)
        {
            l.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return l;
        }

        if(nums.length==4 && target>0)
        {
            if(nums[0]+nums[1]+nums[2]+nums[3]==target)
            {
                l.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
                return l;
            }
            else
            {
                return new ArrayList<>();
            }
        }
        
        if(nums.length>4)
        {
            Arrays.sort(nums);
            for(int i=0; i<nums.length-3; i++)
            {
                // remove duplicates...
                if(i>0 && nums[i]==nums[i-1])
                {
                    continue;
                }

                for(int j=i+1; j<nums.length-2; j++)
                {
                    // remove duplicates...
                    if(j>i+1 && nums[j]==nums[j-1]) 
                    {
                        continue;
                    }
                    int left=j+1;
                    int right=nums.length-1;

                    while(left<right)
                    {
                        long sum=(long)(nums[i]+nums[left]+nums[j]+nums[right]);
                        if(sum==target)
                        {
                            l.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
                        if(sum<target)
                        {
                            left++;
                        }
                        if(sum>target)
                        {
                            right--;
                        }
                    }
                }
            }
            return l;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        FourSum f=new FourSum();
        int[] nums={1,0,-1,0,-2,2};
        List<List<Integer>> l=new ArrayList<>();
        l=f.fourSum(nums, 0);
        System.out.println("Output: "+l);
    }
}
