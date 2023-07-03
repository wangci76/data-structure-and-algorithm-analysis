import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int T = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = input.nextInt();
        }
        for(int i = 0; i < T; i++){
            int l = input.nextInt()-1;
            int r = input.nextInt()-1;
            int mid = (l+r)/2;
            int temp = r+l;
            while((a[mid]<b[temp-mid-1]||a[mid-1]>b[temp-mid])&&l<=r){
                mid=(l+r)/2;
                if(a[mid]<b[temp-mid-1])
                    l = mid +1;
                else if(a[mid-1]>b[temp-mid])
                    r = mid -1;
            }
            if(a[mid]<b[temp-mid])System.out.println(a[mid]);
            else System.out.println(b[temp-mid]);
        }
    }
}
