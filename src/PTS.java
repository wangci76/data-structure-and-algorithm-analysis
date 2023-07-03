////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class PTS {
//    public static void main(String[] args) {
//
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        long[] a = new long[n];
//        for(int i = 0; i < n; i++)
//            a[i] = in.nextLong();
//        long[] cost = new long[1];
//        sort(a,cost);
////        for(int i = 0; i < n; i++)
////            out.println(a[i]);
//        out.println(cost[0]);
//        out.close();
//    }
//    public static void sort(long[] a,long[] c){
//        long[] temp = new long[a.length];
//        ms(a,temp,0,a.length-1,c);
//    }
//    public static void ms(long[] a, long[] t, int be, int e,long[] c){
//        if(be<e){
//            int mid = (be + e) / 2;
//            ms(a, t, be, mid,c);
//            ms(a, t, mid + 1, e,c);
//            merge(a, t, be, mid, e,c);
//        }
//    }
//    public static void merge(long[] a, long[] t, int be, int mid, int e,long[] c){
//        int lp = be;
//        int rp = mid+1;
//        int p = be;
//        while(lp<=mid&&rp<=e){
//            if(a[lp]<=a[rp]) {
//                t[p] = a[lp];
//                p++;lp++;
//            }
//            else {
//                t[p] = a[rp];
//                p++;rp++;
//                c[0]+=t[p-1]*(mid+1-lp);
//            }
//        }
//        while(lp<=mid) {
//            t[p] = a[lp];
//            p++;
//            lp++;
//        }
//        while(rp<=e) {
//            t[p] = a[rp];
//            p++;rp++;
//        }
//        while(be<=e){
//            a[be]=t[be];
//            be++;
//        }
//    }
//}
//
//class QReader {
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
//}
//
//class QWriter implements Closeable {
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
//}
