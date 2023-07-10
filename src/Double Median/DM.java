// import java.util.Scanner;

// public class DM {
//     public static void main(String[] args){
//         Scanner input = new Scanner(System.in);
//         long n = input.nextLong();
//         int fuck = (int)n;
//         long[] arrays = new long[(int)n];
//         for(int i = 0; i < n; i++)
//             arrays[i] = input.nextLong();
//         long[] barry = radixSorting(arrays);
//         if(n % 2 == 1)
//             System.out.println(2*barry[(fuck)/2]);
//         else System.out.println(barry[(fuck-1)/2]+barry[(fuck-1)/2+1]);
//     }

//     public static long[] radixSorting(long[] arrays){
//         long max = arrays[0];
//         for(int i = 1; i < arrays.length; i++)
//             if(arrays[i]>max)max=arrays[i];
//         int bit = 1;
//         while(max>=10){
//             max/=10;
//             bit++;
//         }
//         int[] bucket = new int[10];
//         int radixForLoop = 1;
//         for(int i = 1; i <= bit; i++){
//             for(int j = 0; j < 10; j++)
//                 bucket[j] = 0;
//             for(int j = 0; j < arrays.length; j++){
//                 int num = (int)(arrays[j] / radixForLoop) % 10;
//                 bucket[num]++;
//             }
//             for(int j = 0; j < 9; j++)
//                 bucket[j+1] = bucket[j] + bucket[j+1];
//             long[] temp = new long[arrays.length];
//             for(int j = arrays.length - 1; j >= 0 ; j--){
//                 int num = (int)(arrays[j] / radixForLoop) % 10;
//                 temp[bucket[num]-1]=arrays[j];
//                 bucket[num]--;
//             }
//             for(int j = 0; j < arrays.length; j++)
//                 arrays[j] = temp[j];
//             radixForLoop *= 10;
//         }
//         return arrays;
//     }
// }
