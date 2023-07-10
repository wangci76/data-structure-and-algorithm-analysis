////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class CC {
//   public static void main(String[] args) {
//       QReader in = new QReader();
//       QWriter out = new QWriter();
//       int n = in.nextInt();
//       int p = in.nextInt();
//       int q = in.nextInt();
//
//       Chain head = new Chain(0);
//       Chain cur = head;
//       Chain[] as = new Chain[n];
//       //O(n)
//       for(int i = 0; i < n; i++){
//           Chain a = new Chain(in.nextInt());
//           cur.next = a;
//           cur = cur.next;
//           as[i] = a;
//       }
//       Chain tail = new Chain(0);
//       cur.next = tail;
//
//       Chain rec;
//       for(int i = 0; i < p; i++){
//           int a = in.nextInt();
//           int b = in.nextInt();
//           cur = head;
//           cur=as[a-1];
//           rec = head;
//           rec=as[b-1];
//           while(cur.chain != null)
//               cur = cur.chain;
//           cur.chain = rec;
//           rec.before = cur;
//       }
//
//       cur = head;
//       while (cur.next!=tail){
//           cur = cur.next;
//           rec = cur;
//           if(cur.before==null){
//               int count = 1;
//               while(rec.chain!=null&&count<q){
//                   rec=rec.chain;
//                   count++;
//               }
//               if(count==q)out.print(rec.weight+" ");
//           }
//       }
//
//       out.close();
//   }
//}
//
//class Chain{
//   public int weight;
//   public Chain next;
//   public Chain before;
//   public Chain chain;
//   public Chain(int weight){
//       this.weight=weight;
//   }
//}
//
//class QReader {
//   private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//   private StringTokenizer tokenizer = new StringTokenizer("");
//
//   private String innerNextLine() {
//       try {
//           return reader.readLine();
//       } catch (IOException e) {
//           return null;
//       }
//   }
//
//   public boolean hasNext() {
//       while (!tokenizer.hasMoreTokens()) {
//           String nextLine = innerNextLine();
//           if (nextLine == null) {
//               return false;
//           }
//           tokenizer = new StringTokenizer(nextLine);
//       }
//       return true;
//   }
//
//   public String nextLine() {
//       tokenizer = new StringTokenizer("");
//       return innerNextLine();
//   }
//
//   public String next() {
//       hasNext();
//       return tokenizer.nextToken();
//   }
//
//   public int nextInt() {
//       return Integer.parseInt(next());
//   }
//
//   public long nextLong() {
//       return Long.parseLong(next());
//   }
//}
//
//class QWriter implements Closeable {
//   private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//   public void print(Object object) {
//       try {
//           writer.write(object.toString());
//       } catch (IOException e) {
//           return;
//       }
//   }
//
//   public void println(Object object) {
//       try {
//           writer.write(object.toString());
//           writer.write("\n");
//       } catch (IOException e) {
//           return;
//       }
//   }
//
//   @Override
//   public void close() {
//       try {
//           writer.close();
//       } catch (IOException e) {
//           return;
//       }
//   }
//}
