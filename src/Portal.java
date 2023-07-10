//Java Fast IO
import java.io.*;
import java.util.*;

public class Portal {
   static int size2;
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       size2 = 0;
       //insert(,,++size);
       //ind = tOut(nods).value;
       int n = in.nextInt();
       int m = in.nextInt();
       int p = in.nextInt();
       int k = in.nextInt()+1;
       nod[][] nods = new nod[n+1][k+1];
       for(int i = 1; i <= n; i++)
           for(int j = 1; j <= k; j++)nods[i][j] = new nod();
       for(int i = 1; i <= m+p; i++){
           int u = in.nextInt();
           int v = in.nextInt();
           long w = 0;
           if(i<=m)w = in.nextLong();
           if(i<=m){
               for(int j = 1; j <= k; j++){
                   nods[u][j].outNeighbors.add(nods[v][j]);
                   nods[u][j].distance.add(w);
                   nods[u][j].isPortal.add(0);
               }
           }
           else{
               for(int j = 1; j <= k-1; j++){
                   nods[u][j].outNeighbors.add(nods[v][j+1]);
                   nods[u][j].distance.add(w);
                   nods[u][j].isPortal.add(1);
               }
           }
       }
       int begin = in.nextInt();
       int end = in.nextInt();
       nods[begin][1].dist = 0;
       nod[] tree = new nod[k*(n+m+1)];
       for(int i = 1; i <= n; i++)
           for(int j = 1; j <= k; j++)
               insertSmall(tree,nods[i][j],++size2);
       while(size2>0){
           nod v = tOutSmall(tree);
           if(!v.hasOut&&v.dist<Long.MAX_VALUE){
               v.hasOut = true;
               for (int j = 0; j < v.outNeighbors.size(); j++) {
                   nod u = v.outNeighbors.get(j);
                   long d = v.distance.get(j);
                   long w = v.dist + d;
                   if (w < u.dist) {
                       u.dist = w;
                       insertSmall(tree, u, ++size2);
                   }
               }
           }
       }

       long cost = Long.MAX_VALUE;
       for(int i = 1; i <= k; i++)if(nods[end][i].dist<cost)cost=nods[end][i].dist;
       out.println(cost);

       out.close();
   }

   public static void insertSmall(nod[] a, nod b, int index){
       a[index] = b;
       int i = index/2;
       while(i>0&&a[i].dist>a[index].dist){
           nod temp = a[index];
           a[index] = a[i];
           a[i] = temp;
           i = i/2;
           index = index/2;
       }
   }

   public static nod tOutSmall(nod[] nods){
       nod top = nods[1];
       nods[1] = nods[size2];
       size2--;
       int i = 1;
       while(2*i+1<=size2){
           int cur;
           if(nods[2*i].dist<=nods[2*i+1].dist)cur=2*i;
           else cur=2*i+1;
           nod t = nods[i];
           if(t.dist>=nods[cur].dist){
               nods[i]=nods[cur];
               nods[cur]=t;
               i=cur;
           }
           else break;
       }
       if(2*i<=size2){
           if(nods[2*i].dist<=nods[i].dist){
               nod t = nods[i];
               nods[i] = nods[2*i];
               nods[2*i] = t;
           }
       }
       return top;
   }
}

class nod{
   long dist = Long.MAX_VALUE;
   boolean hasOut;
   ArrayList<nod> outNeighbors = new ArrayList<>();
   ArrayList<Long> distance = new ArrayList<>();
   ArrayList<Integer> isPortal = new ArrayList<>();
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
