//Java Fast IO
import java.io.*;
import java.util.*;

public class COG {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       int n = in.nextInt();
       int m = in.nextInt();

       Student head = new Student(0);
       Student cur;
       cur = head;
       for(int i = 1; i <= n; i++){
           Student a = new Student(i);
           cur.next=a;
           cur = cur.next;
       }
       Student tail = new Student(n+1);
       cur.next=tail;

       while(head.next!=tail){
           cur=head;
           while(cur.next!=tail){
               out.print(cur.next.pos+" ");
               cur.next=cur.next.next;
               for(int i = 0; i < m-1; i++){
                   if(cur.next==tail)break;
                   cur=cur.next;
               }
           }
       }

       out.close();
   }
}

class Student{
   public int pos;
   public Student next;
   public Student(int pos){
       this.pos=pos;
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
