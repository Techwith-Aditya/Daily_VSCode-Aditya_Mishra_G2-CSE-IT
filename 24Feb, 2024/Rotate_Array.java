public class RotateArray {
    static void rotateArr(int arr[], int d) {
        int n=arr.length;
        d=d%n;

        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    static void reverse(int arr[], int start, int end) {
        while(start<end) 
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a={2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d=3;
        rotateArr(a, d);
        for(int i=0; i<a.length; i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
