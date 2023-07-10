// //Java Fast IO
// import java.io.*;
// import java.util.*;

// public class NA {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        long[] a = new long[n];
//        for(int i = 0; i < n; i++)
//            a[i] = in.nextLong();
//        long[] b = radixSorting(a);
//        long temp;
//        for(int i = 1; i < n-2; i++){
//            if(a[i]==(a[i-1]+a[i+1])/2){
//                temp=a[i+1];
//                a[i+1]=a[i+2];
//                a[i+2]=temp;
//            }
//        }
//        for(int i = 0; i < n; i++)
//            out.println(a[i]);
//        out.close();
//    }

//    public static long[] radixSorting(long[] arrays){
//        long max = arrays[0];
//        for(int i = 1; i < arrays.length; i++)
//            if(arrays[i]>max)max=arrays[i];
//        int bit = 1;
//        while(max>=10){
//            max/=10;
//            bit++;
//        }
//        int[] bucket = new int[10];
//        int radixForLoop = 1;
//        for(int i = 1; i <= bit; i++){
//            for(int j = 0; j < 10; j++)
//                bucket[j] = 0;
//            for(int j = 0; j < arrays.length; j++){
//                int num = (int)(arrays[j] / radixForLoop) % 10;
//                bucket[num]++;
//            }
//            for(int j = 0; j < 9; j++)
//                bucket[j+1] = bucket[j] + bucket[j+1];
//            long[] temp = new long[arrays.length];
//            for(int j = arrays.length - 1; j >= 0 ; j--){
//                int num = (int)(arrays[j] / radixForLoop) % 10;
//                temp[bucket[num]-1]=arrays[j];
//                bucket[num]--;
//            }
//            for(int j = 0; j < arrays.length; j++)
//                arrays[j] = temp[j];
//            radixForLoop *= 10;
//        }
//        return arrays;
//    }
// }

// class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");

//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }

//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }

//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }

//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }

//    public int nextInt() {
//        return Integer.parseInt(next());
//    }

//    public long nextLong() {
//        return Long.parseLong(next());
//    }
// }

// class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }

//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }

//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
// }
