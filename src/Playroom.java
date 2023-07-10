//Java Fast IO
import java.io.*;
import java.util.*;

public class Playroom {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       String s = in.next();
       long[] score = new long[s.length()];
       int index = 0;
       for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(c=='(')index++;
           else {
               if(s.charAt(i-1)=='('){
                   score[index-1]=(score[index-1]+1)%514329;
                   index--;
               }
               else {
                   score[index-1]=(score[index-1]+2*score[index])%514329;
                   score[index]=0;
                   index--;
               }
           }
       }
       out.println(score[0]);

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
