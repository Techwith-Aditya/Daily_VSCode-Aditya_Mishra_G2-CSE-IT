import java.util.*;

public class KbitsFlip {
    public int minKBitFlips(String s, int k) {
        char[] arr=s.toCharArray();
        int count=0;

        for(int i=0; i<=arr.length-k; i++) 
        {
            if(arr[i]=='0') 
            {
                for(int j=i; j<i+k; j++) 
                {
                    if(arr[j]=='0') 
                    {
                        arr[j]='1';
                    } 
                    else 
                    {
                        arr[j]='0';
                    }
                }
                count++;
            }
        }

        for(int i=0; i<arr.length; i++) 
        {
            if(arr[i]=='0') 
            {
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s=sc.next();
        System.out.print("Enter k: ");
        int k=sc.nextInt();
        sc.close();

        KbitsFlip sol=new KbitsFlip();
        System.out.println(sol.minKBitFlips(s, k));
    }
}
