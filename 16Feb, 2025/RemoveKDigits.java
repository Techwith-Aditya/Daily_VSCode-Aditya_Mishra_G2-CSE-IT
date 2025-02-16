import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        for(int i=0; i<num.length(); i++)
        {
            while(!s.isEmpty() && k>0 && s.peek() > num.charAt(i)) // Stack is character. To direct comparison done...agr integer hota to -'0' krte...
            {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }
        while(k>0)
        {
            s.pop();
            k--;
        }
        if(s.isEmpty())
        {
            return "0";
        }

        String result="";
        while(!s.isEmpty())
        {
            result=result+s.peek();
            s.pop();
        }
        while(result.length()!=0 && result.charAt(result.length()-1)=='0')
        {
            result=result.substring(0, result.length()-1); // second parameter in substring(start, end) is exclusive—it does not include the character at end index...
        }

        StringBuilder finalString = new StringBuilder(result);
        finalString.reverse();
        if(finalString.length()==0)
        {
            return "0";
        }
        return finalString.toString();
    }

    public static void main(String[] args) {
        System.out.print("Enter input string: ");
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        System.out.print("Enter number of digit to be removed: ");
        int k=sc.nextInt();
        String ans=removeKdigits(input, k);
        System.out.println("The minimum number is: "+ans);
        sc.close();
    }
}
