
//Java Fast IO
import java.io.*;
import java.util.*;

public class IoS {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();
       int T = in.nextInt();
       for(int t = 0; t < T; t++){
           int n = in.nextInt();
           long[] a = new long[n];
           long[] b = new long[n];
           for(int i = 0; i < n; i++)
               a[i] = in.nextLong();
           for(int i = 0; i < n; i++)
               b[i] = a[i];
           long count1 = ins(b,n);
           long[] num = sel(a,n);
           for(int i = 0; i < n; i++)
               out.print(num[i]+" ");
           out.println("");
           if(count1<=num[n])
               out.println("Insertion Sort wins!");
           else out.println("Selection Sort wins!");
//            for(int i = 0; i < n; i++)
//                out.println(a[i]);
           }
       out.close();
   }

   public static long[] sel(long[] a,int n){
       long[] re = new long[n+1];
       long count = 0;
       long temp;
       for(int i = 0; i < n-1; i++){
           int k = i;
           for(int j = i+1; j < n; j++){
               if(a[j]<a[k])k=j;
               count++;
           }
           if(k!=i){
               temp=a[i];
               a[i]=a[k];
               a[k]=temp;
               count++;
           }
       }
       for(int i = 0; i < n; i++)
           re[i]=a[i];
       re[n]=count;
       return re;
   }

   public static long ins(long[] a, int n){
       long count = 0;
       long temp;
       for(int i = 1; i < n; i++) {
           int k = i;
           for (int j = i - 1; j >= 0; j--) {
               count++;
               if (a[k] < a[j]) {
                   temp = a[k];
                   a[k] = a[j];
                   a[j] = temp;
                   count++;
                   k = j;
               } else break;
           }
       }
       return count;
   }
}

class QReader {
   private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   private StringTokenizer tokenizer = new StringTokenizer("");

   private String innerNextLine() {
       try {
           return reader.readLine();
       } catch (IOException e) {
           return null;
       }
   }

   public boolean hasNext() {
       while (!tokenizer.hasMoreTokens()) {
           String nextLine = innerNextLine();
           if (nextLine == null) {
               return false;
           }
           tokenizer = new StringTokenizer(nextLine);
       }
       return true;
   }

   public String nextLine() {
       tokenizer = new StringTokenizer("");
       return innerNextLine();
   }

   public String next() {
       hasNext();
       return tokenizer.nextToken();
   }

   public int nextInt() {
       return Integer.parseInt(next());
   }

   public long nextLong() {
       return Long.parseLong(next());
   }
}

class QWriter implements Closeable {
   private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

   public void print(Object object) {
       try {
           writer.write(object.toString());
       } catch (IOException e) {
           return;
       }
   }

   public void println(Object object) {
       try {
           writer.write(object.toString());
           writer.write("\n");
       } catch (IOException e) {
           return;
       }
   }

   @Override
   public void close() {
       try {
           writer.close();
       } catch (IOException e) {
           return;
       }
   }
}
