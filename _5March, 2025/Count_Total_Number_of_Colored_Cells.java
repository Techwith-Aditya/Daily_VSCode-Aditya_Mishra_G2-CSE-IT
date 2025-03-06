class Solution {
    public long coloredCells(int n) {
        if(n==1)
        {
            return 1;
        }
        // Given cells representation at 1,2,3 minutes ko dekho...
        // at 1st minute, (1^2 + 0^2 = 1 cell)
        // at 2nd minute, (2^2 + 1^2 = 5 cells)
        // at 3rd minute, (3^2 + 2^2 = 13 cells)
        return (long)(Math.pow(n,2)+Math.pow(n-1,2));
    }
}
