import java.util.Scanner;

public class MSE {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int s = 0; s < T; s++){
            long n = input.nextLong();
            long m = input.nextLong();

            long min = -(long)Math.pow(10,10);
            long max = (long)Math.pow(10,15);
            long mid;
            long aAns=0;
            while(min<=max){
                long cnt=0;
                mid = (min+max)/2;
                for (long j = 1; j <= n; j++) {
                    long left = 1;
                    long right = n;
                    long midD;
                    long gg;
                    long ans=0;
                    while(left<=right){
                        midD=(left+right)/2;
                        gg=midD * midD + 12345 * midD + j * j - 12345 * j + midD * j;
                        if(gg<=mid) {
                            left = midD + 1;
                            ans=midD;
                        }
                        else {
                            right = midD-1;
                        }
                    }
                    cnt+=ans;
                }
                if(cnt>=m){
                    aAns=mid;
                    max=mid-1;
                }
                else{
                    min=mid+1;
                }
            }
            System.out.println(aAns);
        }
    }
}




