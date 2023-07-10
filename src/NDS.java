//Java Fast IO
import java.io.*;
import java.util.*;

public class NDS {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       int T = in.nextInt();
       for(int i = 0; i < T; i++) {
           int n = in.nextInt();
           nod head = new nod(1);
           nod cur = head;
           for (int j = 0; j < n; j++) {
               nod now = new nod(in.nextInt());
               cur.next = now;
               now.before = cur;
               cur = cur.next;
           }
           nod tail = new nod(100000);
           cur.next = tail;
           tail.before = cur;

           nod[] a = new nod[n];
           cur = head;
           for(int j = 0; j < n; j++){
               cur=cur.next;
               a[j]=cur;
           }
           boolean flag = true;
           while(flag){
               for (int j = 0; j < a.length; j++) {
                   nod e = a[j];
                   if (e.value > e.next.value) {
                       e.isDecreasing = true;
                       e.next.isDecreasing = true;
                   }
               }
               int count = 0;
               int tackle = 0;
               for (int j = 0; j < a.length; j++) {
                   cur = a[j];
                   if (cur.isDecreasing) {
                       count++;
                       if (!cur.before.isDecreasing&&cur.before!=head || !cur.next.isDecreasing&&cur.next!=tail)
                           tackle++;
                   }
               }
               nod[] b = new nod[count];
               nod[] c = new nod[tackle];
               int index = 0;
               int ferocity = 0;
               for (int j = 0; j < a.length; j++) {
                   cur = a[j];
                   if (cur.isDecreasing) {
                       b[index++] = cur;
                       if (!cur.before.isDecreasing&&cur.before!=head) c[ferocity++] = cur.before;
                       else if (!cur.next.isDecreasing&&cur.next!=tail) c[ferocity++] = cur.next;
                   }
               }
               for (int j = 0; j < count; j++) {
                   nod e = b[j];
                   e.before.next = e.next;
                   e.next.before = e.before;
                   e.isDeleted = true;
               }
               int embezzlement = 0;
               for (int j = 0; j < tackle; j++)
                   if (!c[j].isDeleted) embezzlement++;
               a = new nod[embezzlement];
               int blandishment = 0;
               for (int j = 0; j < tackle; j++)
                   if (!c[j].isDeleted) a[blandishment++] = c[j];
               if(c.length==0)flag=false;
           }
           cur = head;
           while (cur.next!=tail){
               cur=cur.next;
               out.print(cur.value+" ");
           }
           out.println("");
       }
       out.close();
   }
}

class nod{
   public int value;
   public nod next;
   public nod before;
   public boolean isDecreasing;
   public boolean isDeleted;
   public nod(int value){
       this.value = value;
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
