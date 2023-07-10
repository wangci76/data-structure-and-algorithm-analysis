//Java Fast IO
import java.io.*;
import java.util.*;

public class VD {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();


       int n = in.nextInt();
       int m = in.nextInt();
       nod[] cities = new nod[n+1];
       for(int i = 1; i <= n ;i++)cities[i]=new nod();
       for(int i = 1; i <= m; i++){
           int s = in.nextInt();
           int e = in.nextInt();
           int length = in.nextInt();
           cities[s].subNods.add(cities[e]);
           cities[s].weights.add(length);
       }
       nod[] queue = new nod[2*n];
       int peek = 0;
       int rear = 0;
       queue[rear++] = cities[1];
       cities[1].hasVisited=true;
       int count = Integer.MAX_VALUE;
       while(peek!=rear){
           nod temp = queue[peek];
           if(temp==cities[n]&&temp.path<count)count=temp.path;
           peek++;
           for(int j = 0; j < temp.subNods.size(); j++){
               if(temp.subNods.get(j)!=null&&!temp.subNods.get(j).hasVisited){
                   if(temp.weights.get(j)==1){
                       queue[rear++] = temp.subNods.get(j);
                       temp.subNods.get(j).hasVisited = true;
                       temp.subNods.get(j).path = temp.path + 1;
                   }
                   else{
                       nod mid = new nod();
                       queue[rear++] = mid;
                       mid.hasVisited=true;
                       mid.subNods.add(temp.subNods.get(j));
                       mid.weights.add(1);
                       temp.subNods.set(j,mid);
                       mid.path=temp.path+1;
                   }
               }
           }
       }
       if(count<Integer.MAX_VALUE)out.println(count);
       else out.println(-1);

//        nod[] nods = new nod[n];
//        int num = in.nextInt();
//
//        for(int i = 0; i < n; i++)
//            nods[i] = new nod();
//        for(int i = 0; i < n-1; i++){
//            int p = in.nextInt()-1;
//            int q = in.nextInt()-1;
//            int k = in.nextInt();
//            nods[p].subNods.add(nods[q]);
//            nods[q].subNods.add(nods[p]);
//            nods[p].weights.add(k);
//            nods[q].weights.add(k);
//        }
//        nod[] queue = new nod[n];
//        int peek = 0;
//        int rear = 0;
//        queue[rear++] = nods[0];
//        nods[0].hasVisited=true;
//        int count = 0;
//        while(peek!=rear){
//            nod temp = queue[peek];
//            peek++;
//            for(int j = 0; j < temp.subNods.size(); j++){
//                if(!temp.subNods.get(j).hasVisited){
//                    queue[rear++]=temp.subNods.get(j);
//                    temp.subNods.get(j).hasVisited=true;
//                    temp.subNods.get(j).path=temp.path+ temp.weights.get(j);
//                    if(temp.subNods.get(j).path==num&&temp.subNods.get(j).subNods.size()==1)count++;
//                }
//            }
//        }
//        out.println(count);

       out.close();
   }
}
class nod{
   ArrayList<nod> subNods = new ArrayList<>();
   ArrayList<Integer> weights = new ArrayList<>();
   public boolean hasVisited;
   public int len;
   public int path;
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
