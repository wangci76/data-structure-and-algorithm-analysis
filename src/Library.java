//Java Fast IO
import java.io.*;
import java.util.*;

public class Library {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       while(in.hasNext()){
           int n = in.nextInt();
           nod[][] nods = new nod[n][2];
           int T = in.nextInt();
           nod[][] tails = new nod[n][2];

           for(int i = 0; i < T; i++){
               int num = in.nextInt();
               if(num==1){
                   int u = in.nextInt()-1;
                   int w = in.nextInt();
                   int val = in.nextInt();
                   one(u,w,val,nods,tails);
               }
               else if(num==2){
                   int u = in.nextInt()-1;
                   int w = in.nextInt();
                   two(u,w,nods,tails,out);
               }
               else {
                   int u = in.nextInt()-1;
                   int v = in.nextInt()-1;
                   int w = in.nextInt();
                   int flag = twoWithoutOutput(v,w,nods,tails);
                   while(flag!=-1){
                       one(u,1,flag,nods,tails);
                       flag=twoWithoutOutput(v,w,nods,tails);
                   }
               }
           }
       }

       out.close();
   }
   public static void one(int u, int w, int val, nod[][] nods, nod[][] tails){
       nod temp = new nod(val);
       if(w==0){
           if(nods[u][0]==null) {
               nods[u][0] = temp;
               tails[u][0] = temp;
           }
           else {
               nods[u][0].next = temp;
               temp.before = nods[u][0];
               nods[u][0]=temp;
           }
       }
       else{
           if(nods[u][1]==null){
               nods[u][1]=temp;
               tails[u][1]=temp;
           }
           else {
               nods[u][1].before=temp;
               temp.next=nods[u][1];
               nods[u][1]=temp;
           }
       }
   }
   public static void two(int u, int w, nod[][] nods, nod[][] tails, QWriter out){
       if(w==0){
           if(nods[u][0]==null&&nods[u][1]==null)out.println(-1);
           else if(nods[u][0]!=null){
               out.println(nods[u][0].value);
               if(nods[u][0].before!=null) {
                   nods[u][0] = nods[u][0].before;
                   nods[u][0].next = null;
               }
               else {
                   nods[u][0] = null;
                   tails[u][0] = null;
               }
           }
           else{
               out.println(tails[u][1].value);
               if(tails[u][1].before!=null) {
                   tails[u][1] = tails[u][1].before;
                   tails[u][1].next=null;
               }
               else {
                   tails[u][1] = null;
                   nods[u][1] = null;
               }
           }
       }
       else{
           if(nods[u][0]==null&&nods[u][1]==null)out.println(-1);
           else if(nods[u][1]!=null){
               out.println(nods[u][1].value);
               if(nods[u][1].next!=null) {
                   nods[u][1] = nods[u][1].next;
                   nods[u][1].before=null;
               }
               else {
                   nods[u][1] = null;
                   tails[u][1] = null;
               }
           }
           else {
               out.println(tails[u][0].value);
               if(tails[u][0].next!=null) {
                   tails[u][0] = tails[u][0].next;
                   tails[u][0].before = null;
               }
               else {
                   tails[u][0] = null;
                   nods[u][0] = null;
               }
           }
       }
   }
   public static int twoWithoutOutput(int u, int w, nod[][] nods, nod[][] tails) {
       int i = 0;
       if (w == 0) {
           if (nods[u][0] == null && nods[u][1] == null) i = -1;
           else if (nods[u][0] != null) {
               i = nods[u][0].value;
               if (nods[u][0].before != null) {
                   nods[u][0] = nods[u][0].before;
                   nods[u][0].next=null;
               }
               else {
                   nods[u][0] = null;
                   tails[u][0] = null;
               }
           } else{
               i = tails[u][1].value;
               if (tails[u][1].before != null) {
                   tails[u][1] = tails[u][1].before;
                   tails[u][1].next=null;
               }
               else {
                   tails[u][1] = null;
                   nods[u][1] = null;
               }
           }
       } else {
           if (nods[u][0] == null && nods[u][1] == null) i = -1;
           else if (nods[u][1] != null) {
               i = nods[u][1].value;
               if (nods[u][1].next != null) {
                   nods[u][1] = nods[u][1].next;
                   nods[u][1].before = null;
               }
               else {
                   nods[u][1] = null;
                   tails[u][1] = null;
               }
           } else{
               i = tails[u][0].value;
               if (tails[u][0].next != null) {
                   tails[u][0] = tails[u][0].next;
                   tails[u][0].before = null;
               }
               else {
                   tails[u][0] = null;
                   nods[u][0] = null;
               }
           }
       }
       return i;
   }
}

class nod{
   public int value;
   public nod next;
   public nod before;
   public nod(int value){
       this.value=value;
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
