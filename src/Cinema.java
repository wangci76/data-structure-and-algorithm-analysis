////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class Cinema {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        int p = in.nextInt();
//        int q = in.nextInt();
//        int[] queueOne = new int[p];
//        int[] queueTwo = new int[q];
//        int q1 = 0;
//        int q2 = 0;
//        int[] time = new int[n];
//        int count = 0;
//
//        for(int i = 0; i < p; i++)
//            queueOne[i] = in.nextInt();
//        for(int i = 0; i < q; i++)
//            queueTwo[i] = in.nextInt();
//        while (q1<p&&q2<q){
//            count++;
//            time[queueOne[q1]-1]=count;
//            time[queueTwo[q2]-1]=count;
//            q1++;
//            q2++;
//            while (q1<p&&time[queueOne[q1]-1]!=0)q1++;
//            while (q2<q&&time[queueTwo[q2]-1]!=0)q2++;
//        }
//        while(q1<p){
//            count++;
//            time[queueOne[q1]-1]=count;
//            q1++;
//            while (q1<p&&time[queueOne[q1]-1]!=0)q1++;
//        }
//        while (q2<q){
//            count++;
//            time[queueTwo[q2]-1]=count;
//            q2++;
//            while (q2<q&&time[queueTwo[q2]-1]!=0)q2++;
//        }
//        for(int i = 0; i < n; i++)
//            out.print(time[i]+" ");
//
//        out.close();
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
