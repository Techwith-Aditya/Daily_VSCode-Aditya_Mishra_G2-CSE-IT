public class CheckIfPossibleToSurviveOnIsland {
    static int minimumDays(int S, int N, int M){
        if(M > N || (S > 6 && M * 7 > 6 * N)) 
        {
            return -1;
        }
        int noOfSundays=S/7;
        int noOfDaysSheCanBuyFood=S-noOfSundays;
        
        int totalUnitOfFoodSheCanBuy=noOfDaysSheCanBuyFood*N;
        
        int totalFoodRequiredToSurvive=S*M;
        
        if(totalFoodRequiredToSurvive > totalUnitOfFoodSheCanBuy)
        {
            return -1;
        }
        if(totalFoodRequiredToSurvive%N==0)
        {
            return totalFoodRequiredToSurvive/N;
        }
        else
        return (int)Math.ceil(totalFoodRequiredToSurvive/N)+1;
    }

    public static void main(String[] args) {
        int S=10;
        int N=9;
        int M=8;

        int ans=minimumDays(S, N, M);
        System.out.println(ans);
    }
}
