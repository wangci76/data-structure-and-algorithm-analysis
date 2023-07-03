//Arrays.copy用时很长



import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Three {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random in=new Random();
        int n = input.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int m =input.nextInt();
        int x = 0;
        for(int i = 0; i < m; i++){
            x = input.nextInt();
            met(array,x,0,array.length);
        }
    }
    public static void met(int[] array, int x, int left,int right){
        int mid = (left+right)/2;
        if(array[mid]==x)System.out.println("YES");
        else if(right-left==1)System.out.println("NO");
        else if(array[mid]>x){
//            int[] ar = Arrays.copyOfRange(array,0,mid);
            right = mid;
            met(array,x,left,right);
        }
        else if(array[mid]<x){
            //int[] ar = Arrays.copyOfRange(array, mid, array.length);
            left = mid;
            met(array, x,left,right);
        }
    }
}