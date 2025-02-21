public class BuySellStock_II {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        for(int i=1; i<prices.length; i++)
        {
            // jb tk profit aa rha h, add krte jao...
            if(prices[i]>prices[i-1])
            {
                maxprofit=maxprofit + prices[i]-prices[i-1];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        BuySellStock_II b=new BuySellStock_II();
        int[] prices={1,2,3,4,5};
        int ans=b.maxProfit(prices);
        System.out.println("Output: "+ans);
    }
}
