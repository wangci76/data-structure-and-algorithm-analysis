import java.util.Scanner;

public class force {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int[] a = new int[n];
        int length = 0;
        for(int i = 0; i < n; i++)a[i]=input.nextInt();
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for (int j = 0;j < n-i+1; j++){
                for(int l = 0; l < i ; l++){
                    if(a[j+l]-a[j]>k)flag=false;
                }
            }
            if(flag){
                length=i;
                break;
            }
        }
        System.out.println(length);
    }
}
