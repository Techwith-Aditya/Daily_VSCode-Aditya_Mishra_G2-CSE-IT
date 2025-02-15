public class PosNegAlternate {
    public static int[] rearrangeArray(int[] nums) {
        int[] rearranged=new int[nums.length];
        int[] positives=new int[nums.length/2+1];
        int[] negatives=new int[nums.length/2+1];

        int pos=0, neg=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
            {
                positives[pos++]=nums[i];
            }
            if(nums[i]<0)
            {
                negatives[neg++]=nums[i];
            }
        }

        int index=0;
        for(int i=0; i<nums.length/2; i++)
        {
            rearranged[index++]=positives[i];
            rearranged[index++]=negatives[i];
        }
        for(int i=0; i<rearranged.length; i++)
        {
            System.out.print(rearranged[i]);
            if(i!=rearranged.length-1)
            {
                System.out.print(",");
            }
        }
        return rearranged;
    }

    public static void main(String[] args) {
        int[] a={3,1,-2,-5,2,-4,5,-9};
        rearrangeArray(a);
    }
}
