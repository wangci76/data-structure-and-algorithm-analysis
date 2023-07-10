// //Java Fast IO
// import java.io.*;
// import java.util.*;
//
// public class MMFH {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        int[] nums = new int[n+1];
//        nums[1] = in.nextInt();
//        int[] count = new int[n];
//        for(int i = 2; i < n+1; i++)count[i-1]=insert(nums,in.nextInt(),i);
//        for(int e: count)out.print(e+" ");
//
//        out.close();
//    }
//    public static int insert(int[] a, int b, int index){
//        a[index] = b;
//        int i = index/2;
//        int c = 0;
//        while(i>0&&a[i]<a[index]){
//            int temp = a[index];
//            a[index] = a[i];
//            a[i] = temp;
//            c++;
//            i = i/2;
//            index = index/2;
//        }
//        return c;
//    }
// }
//
// class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
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
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
// }
//
// class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
// }
