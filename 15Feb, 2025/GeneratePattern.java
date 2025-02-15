public class GeneratePattern {
    public static void printPattern(String str) {
        int count=0;
        StringBuilder result=new StringBuilder();
        for(int i=0; i<str.length(); i++) 
        {
            if(str.charAt(i)=='1') 
            {
                count++;
            } 
            else 
            {
                if(count>0) 
                {
                    result.append(count);
                    count=0;
                }
                result.append(str.charAt(i));
            }
        }
        if(count>0) 
        {
            result.append(count);
        }
        System.out.println(result.toString());
    }

    public static void generatePattern(char[] str, int index) {
        if(index==str.length) 
        {
            printPattern(new String(str));
            return;
        }
        char temp=str[index];
        generatePattern(str, index+1);
        // Jb recursion lgate h, tb current state (the index value) call stack me push kr di jati h...
        // When the function completes or hits base case, the stack pops the last call and come on to the pichhli wali state...
        // So, it automatically comes to 2 after encountering a return from 3...
        str[index]='1';
        generatePattern(str, index+1);
        str[index]=temp; 
    }

    public static void main(String[] args) {
        String input = "GMAT";
        generatePattern(input.toCharArray(), 0);
    }
}
