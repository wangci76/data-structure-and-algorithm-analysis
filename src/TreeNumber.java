//Java Fast IO
import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class TreeNumber {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       int T = in.nextInt();
       for(int t = 0; t < T; t++){
           char[] preStr = in.nextLine().toCharArray();
           char[] postStr = in.nextLine().toCharArray();
           int[] pre = new int[preStr.length];
           int[] post = new int[postStr.length];
           int[] pos1 = new int[26];
           int[] pos2 = new int[26];
           for(int i = 0; i < post.length; i++){
               pre[i] = preStr[i] - 'A';
               post[i] = postStr[i] - 'A';
               pos2[post[i]] = i;
               pos1[pre[i]] = i;
           }

           int[] count = new int[1];
           judge(count, pre,post, pos1,pos2,0, pre.length-1, 0, pre.length-1);
           if(count[0]!=-1){
               out.println((int) Math.pow(2, count[0]));
           }
           else out.println("0");
       }



       out.close();
   }
   public static void judge(int[]count,int[] pre,int[]post,int[]pos1,int[]pos2, int preL, int preR, int postL, int postR){
       if(preR-preL!=postR-postL){
           count[0]=-1;
           return;
       }
       if(preL==preR){
           return;
       }
       else if(postL>postR||preL>preR)return;
       if(pre[preL]==post[postR]){
           if(pre[preL+1]==post[postR-1]){
               count[0]++;
               judge(count,pre,post,pos1,pos2,preL+1,preR,postL,postR-1);
           }
           else {
               judge(count,pre,post,pos1,pos2,preL+1,pos1[post[postR-1]]-1,postL,pos2[pre[preL+1]]);
               judge(count,pre,post,pos1,pos2,pos1[post[postR-1]],preR,pos2[pre[preL+1]]+1,postR-1);
           }
       }
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
