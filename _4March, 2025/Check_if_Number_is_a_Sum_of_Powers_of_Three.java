class Solution {
    public static boolean checkPowersOfThree(int n) {
        while(n>0) 
        {
            if(n%3==2) 
            {
                return false;
            }
            n=n/3;
        }
        return true;
    }
    public static void main(String[] args) {
        int n=12;
        int ans=checkPowersOfThree(n);
        System.out.println(n);
    }
}
