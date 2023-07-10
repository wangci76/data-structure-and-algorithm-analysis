// import java.util.Arrays;
// import java.util.Scanner;
//
// public class MagicNumber {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         Long l, r;
//         long[] num = new long[15625 * 4];
//         char[] a;
//         char[] b;
//         long p, q;
//         for (int i = 0; i < 15625; i++) {
//             a = Long.toString(i, 5).toCharArray();
//             b = new char[a.length];
//             for (int j = 0; j < a.length; j++) {
//                 switch (a[j]) {
//                     case '2':
//                         a[j] = '6';
//                         break;
//                     case '3':
//                         a[j] = '8';
//                         break;
//                     case '4':
//                         a[j] = '9';
//                         break;
//                 }
//             }
//             for (int j = 0; j < a.length; j++) {
//                 b[j] = a[a.length - 1 - j];
//                 if(a[a.length - 1 - j]=='6')b[j]='9';
//                 if(a[a.length - 1 - j]=='9')b[j]='6';
//             }
//             num[4 * i] = Long.parseLong(String.valueOf(a) + String.valueOf(b));
//             num[4 * i + 1] = Long.parseLong(String.valueOf(a) + "0" + String.valueOf(b));
//             num[4 * i + 2] = Long.parseLong(String.valueOf(a) + "1" + String.valueOf(b));
//             num[4 * i + 3] = Long.parseLong(String.valueOf(a) + "8" + String.valueOf(b));
//         }
//         num[2]=1;
//         num[3]=8;
//         Arrays.sort(num);
// //        for (int i = 0; i < 15625*4; i++) {
// //            System.out.println(num[i]);
// //        }
//         while(input.hasNext()){
//             l=input.nextLong();
//             r=input.nextLong();
//             p=0l;
//             q=0l;
//             for(int i = 0; i < 15625*4; i++){
//                 if(num[i]>=l) {
//                     p = num[i];
//                     break;
//                 }
//             }
//             for(int i = 0; i < 15625*4; i++){
//                 if(num[15625*4-1-i]<=r) {
//                     q = num[15625*4-1-i];
//                     break;
//                 }
//             }
//
//             System.out.println(p+" "+q);
//         }
//     }
// }
//
