//Java Fast IO
import java.io.*;
import java.util.*;

public class Knight {
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       int t = in.nextInt();
       nod[][] nods = new nod[9][9];
       for(int i = 1; i <= 8; i++){
           for(int j = 1; j <= 8; j++){
               nods[i][j]=new nod();
           }
       }
       for(int i = 1; i <= 8; i++){
           for(int j = 1; j <= 8; j++){
               if(i>=2&&j>=3)nods[i][j].subNods.add(nods[i-1][j-2]);
               if(i>=3&&j>=2)nods[i][j].subNods.add(nods[i-2][j-1]);
               if(i>=3&&j<=7)nods[i][j].subNods.add(nods[i-2][j+1]);
               if(i>=2&&j<=6)nods[i][j].subNods.add(nods[i-1][j+2]);
               if(i<=7&&j<=6)nods[i][j].subNods.add(nods[i+1][j+2]);
               if(i<=6&&j<=7)nods[i][j].subNods.add(nods[i+2][j+1]);
               if(i<=6&&j>=2)nods[i][j].subNods.add(nods[i+2][j-1]);
               if(i<=7&&j>=3)nods[i][j].subNods.add(nods[i+1][j-2]);
           }
       }
       for(int c = 1; c <= t; c++){
           for(int i = 1; i <= 8; i++) {
               for (int j = 1; j <= 8; j++) {
                   nods[i][j].hasVisited = false;
                   nods[i][j].path=0;
               }
           }
           String start = in.next();
           String end = in.next();
           int si = (start.charAt(0)-'a')+1;
           int sj = (start.charAt(1)-'1')+1;
           int ei = (end.charAt(0)-'a')+1;
           int ej = (end.charAt(1)-'1')+1;
           nod[] queue = new nod[64];
           int peek = 0;
           int rear = 0;
           queue[rear++] = nods[si][sj];
           nods[si][sj].hasVisited=true;
           int count = 100;
           while(peek!=rear){
               nod temp = queue[peek];
               if(temp==nods[ei][ej]&&temp.path<count)count=temp.path;
               peek++;
               for(int j = 0; j < temp.subNods.size(); j++){
                   if(temp.subNods.get(j)!=null&&!temp.subNods.get(j).hasVisited){
                       queue[rear++]=temp.subNods.get(j);
                       temp.subNods.get(j).hasVisited=true;
                       temp.subNods.get(j).path=temp.path+1;
                   }
               }
           }
           out.println(count);
       }
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
