// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.Scanner;
// import java.util.function.IntFunction;
//
// public class One {
//     public static void main(String[] args){
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();
// //        int n = 1000;
//         long[] l = new long[n];
//         for(int i = 0; i < n; i++) {
//             l[i] = input.nextLong();
// //            l[i] = i+1;
//         }
//         int count = 1;
//         long k;
//         int[] r = new int[n];
//         for(int i = 0; i < n; i++){
//             count = 1;
//             k = l[i]-1;
//             while(k>=3){
//                 count++;
//                 k = k / 3 - 1;
//             }
//             r[i] = count;
//             //System.out.println(r[i]);
//         }
//         long g = 0;
//         String str;
//         char[][] w = new char[n][];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j <= r[i]-1;j++){
//                g +=(long) Math.pow(3,j);
//             }
//             str = Long.toString(l[i]-g,3);
//             //System.out.println(str);
//             g = 0;
//             w[i] = new char[r[i]];
//             for(int j = 0;j < r[i];j++){
//                 w[i][j] = '0';
//             }
//             for(int j = 0;j< str.length();j++){
//                 w[i][r[i]-1-j]=str.charAt(str.length()-1-j);
//             }
//             for(int j = 0; j < r[i]; j++){
//                 if(w[i][j]=='2')w[i][j]='6';
//                 if(w[i][j]=='1')w[i][j]='3';
//                 if(w[i][j]=='0')w[i][j]='2';
//             }
// //            w[i] = str.toCharArray();
//
//
//             System.out.println(w[i]);
//         }
//
//     }
//     public static String tran(long l){
//         long n = l;
//         long r = 1;
//         long q = 0;
//         String s = "";
//         while (r != 0){
//             q = n % 3;
//             if(q == 0)
//                 s = "2" + s;
//             else if(q==1)
//                 s = "3" + s;
//             else if(q==2)
//                 s = "6" + s;
//             r = n / 3;
//         }
//         return s;
//     }
// }
