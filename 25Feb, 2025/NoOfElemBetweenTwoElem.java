import java.util.*;

public class NoOfElemBetweenTwoElem {
    public static int getCount(ArrayList<Integer> arr, int num1, int num2) {
        int num1FoundAt=-1;
        int num2FoundAt=-1;
        for(int i=0; i<arr.size(); i++)
        {
            if(arr.get(i)==num1 && num1FoundAt==-1)
            {
                num1FoundAt=i;
            }
            if(arr.get(i)==num2)
            {
                num2FoundAt=i;
            }
        }
        if(num1FoundAt>num2FoundAt)
        {
            return 0;
        }
        
        return (num2FoundAt-num1FoundAt-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(4);
        a.add(2);
        a.add(1);
        a.add(10);
        a.add(6);
        int num1=4;
        int num2=6;

        int ans=getCount(a, num1, num2); 
        System.out.println(ans);       
    }
}
