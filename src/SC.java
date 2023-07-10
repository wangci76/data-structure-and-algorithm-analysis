//Java Fast IO
import java.io.*;
import java.util.*;

public class SC {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       String str = in.next();
       int n = str.length();
       char[] chars = str.toCharArray();
       int[] next = new int[n];
       int i = 0;
       int j = 0;
       while(i<n){
           if(i==0){
               next[i]=0;
               i++;
           }
           else if(chars[i]==chars[j]){
               j++;
               next[i]=j;
               i++;
           }
           else {
               if(j!=0){
                   j = next[j - 1];
               }
               else{
                   next[i]=0;
                   i++;
               }
           }
       }
       for(int k = 0; k < n; k++)
           out.println(next[k]);

       out.close();
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
