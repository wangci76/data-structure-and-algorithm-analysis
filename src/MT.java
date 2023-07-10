//Java Fast IO
import java.io.*;
import java.util.*;

public class MT {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       int T = in.nextInt();
       for(int i = 0; i < T; i++){
           int n = in.nextInt();
           int k = in.nextInt();
           nod[] nods = new nod[n+1];
           for(int j = 1; j < n+1; j++)nods[j]=new nod(j);
           for(int j = 0; j < n-1; j++){
               int s1 = in.nextInt();
               int s2 = in.nextInt();
               nods[s1].subNods.add(nods[s2]);
               nods[s2].subNods.add(nods[s1]);
               nods[s1].weights.add(1);
               nods[s2].weights.add(1);
           }
           int[] where = new int[k];
           for(int j = 0; j < k; j++)where[j] = in.nextInt();
           for(int j = 0; j < k; j++)nods[where[j]].isIn=true;
           if(k!=1){
               int ans = 0;
               nod[] queue = new nod[n];
               nod cur = null;
               int max = 0;
               int peek = 0;
               int rear = 0;
               queue[rear++] = nods[where[0]];
               nods[where[0]].hasVisited = true;
               while (peek != rear) {
                   nod temp = queue[peek];

                   if (temp.path >= max && temp.isIn) {
                       max = temp.path;
                       cur = temp;
                   }
                   peek++;
                   for (int j = 0; j < temp.subNods.size(); j++) {
                       if (!temp.subNods.get(j).hasVisited) {
                           queue[rear++] = temp.subNods.get(j);
                           temp.subNods.get(j).hasVisited = true;
                           temp.subNods.get(j).path = temp.path + temp.weights.get(j);

                       }
                   }
               }
               //System.out.println(cur.index);

               for (int m = 1; m < nods.length; m++) {
                   nods[m].hasVisited = false;
                   nods[m].path = 0;
               }
               peek = 0;
               rear = 0;
               {
                   queue[rear++] = cur;
                   cur.hasVisited = true;
                   while (peek != rear) {
                       nod temp = queue[peek];

                       if (temp.path >= max && temp.isIn) {
                           max = temp.path;
                       }
                       peek++;
                       for (int j = 0; j < temp.subNods.size(); j++) {
                           if (!temp.subNods.get(j).hasVisited) {
                               queue[rear++] = temp.subNods.get(j);
                               temp.subNods.get(j).hasVisited = true;
                               temp.subNods.get(j).path = temp.path + temp.weights.get(j);

                           }
                       }

                   }
               }
               ans = max;

               if (ans % 2 == 0) {
                   out.println(ans / 2);
               } else out.println(ans / 2 + 1);
           }
           else out.println(0);
       }

       out.close();
   }

}
class nod{
   public int index;
   public boolean hasVisited;
   public boolean isIn;
   public int path;
   public ArrayList<nod> subNods = new ArrayList<>();
   public ArrayList<Integer> weights = new ArrayList<>();
   public nod(int index){
       this.index = index;
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
