import java.util.Scanner;

public class FNP {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        int c = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 1; j <= 32; j++){
                int b = (int) Math.pow(2,j) - a[i];
                int left = i+1;
                int right = n - 1;
                int mid;
                while(left<=right){
                    mid = (left+right)/2;
                    if(a[mid]<b)left = mid+1;
                    else if(a[mid]>b)right = mid-1;
                    else if(a[mid]==b) {
                        c++;
                        if(mid == 0 ){
                            for(int k = mid + 1; k < n; k++){
                                if(a[k]==a[mid])c++;
                                else break;
                            }
                        }
                        else if(mid == n-1){
                            for(int k = mid - 1; k >= 0; k--){
                                if(a[k]==a[mid])c++;
                                else break;
                            }
                        }
                        else {
                            for(int k = mid + 1; k < n; k++){
                                if(a[k]==a[mid])c++;
                                else break;
                            }
                            for(int k = mid - 1; k > i; k--){
                                if(a[k]==a[mid])c++;
                                else break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(c);
    }
}
