//Java Fast IO
import java.io.*;
import java.util.*;

public class SE {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       String s = in.nextLine();
       String str = "*#";
       for(int i = 0; i < s.length(); i++)str=str+s.charAt(i)+"#";
       int len = 0;

       int center = -1;
       int mx = -1;
       int[] p = new int[str.length()];
       for(int i = 0; i < str.length(); i++){
           if(i<mx){
               int rev = 2 * center - i;
               int minL = Math.min(mx-i,p[rev]);
               len = find(str,i-minL,i+minL);
           }
           else len = find(str,i,i);
           p[i]=len;
           if(i+len>mx){
               mx=i+len;
               center=i;
           }
       }

       for(int i : p)if(i>len)len=i;

       out.println(len);

       out.close();
   }
   public static int find(String s1,int left, int right){
       while(left>=0 && right<s1.length() && s1.charAt(left)==s1.charAt(right)){
           left--;
           right++;
       }
       return (right-left-2)/2;
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
