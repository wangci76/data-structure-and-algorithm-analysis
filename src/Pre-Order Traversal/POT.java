// import java.util.ArrayList;
// import java.util.Scanner;
//
// public class POT {
//     public static void main(String[] args){
//         Scanner input = new Scanner(System.in);
//         int Q = input.nextInt();
//         for(int q = 0; q < Q; q++){
//             int N = input.nextInt();
//             int[] iq = new int[N];
//             int[] pq = new int[N];
//             for(int i = 0; i < N; i++)iq[i] = input.nextInt();
//             for(int i = 0; i < N; i++)pq[i] = input.nextInt();
//             find(iq,pq,0,N-1,N-1);
//             System.out.println();
//         }
//     }
//     public static void find(int[] iq, int[] pq, int s, int e, int r){
//         if(s<=e){
//             int i = s;
//             while (i<e&&iq[i]!=pq[r])i++;
//             System.out.print(iq[i]+" ");
//             find(iq,pq,s,i-1,r-(e-i)-1);
//             find(iq,pq,i+1,e,r-1);
//         }
//     }
// }
