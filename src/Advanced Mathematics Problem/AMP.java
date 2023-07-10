// import java.util.Scanner;

// public class AMP {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();
//         for(int i = 0; i < n; i++){
//             int b = input.nextInt();
//             double left = 0;
//             double right = b;
//             double mid = (left+right)/2;
//             double f = mid*Math.exp(mid/20)-b;
//             double abs = Math.abs(f);
//             while(abs>=0.01){
//                 mid = (left+right)/2;
//                 f = mid*Math.exp(mid/20)-b;
//                 abs = Math.abs(f);
//                 if(f>0)right = mid;
//                 else if(f < 0)left = mid;
//             }
//             System.out.printf("%.10f\n",mid);
//         }
//     }
// }
