////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class TE {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int T = in.nextInt();
//        for(int t = 1; t <= T; t++){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            long[] a = new long[n+1];
//            long[] b = new long[n+1];
//            for(int index = 1; index <= n; index++){
//                a[index] = in.nextLong();
//                b[index] = in.nextLong();
//            }
//            nod[] nods = new nod[n+1];
//            for(int index = 1; index <= n; index++)nods[index] = new nod(index);
//            for(int i = 0; i < m; i++){
//                int u = in.nextInt();
//                int v = in.nextInt();
//                nods[u].children.add(nods[v]);
//                nods[v].father.add(nods[u]);
//                nods[v].fathers++;
//            }
//            nod[] queue = new nod[n];
//            int rear = 0;
//            while(rear<n){
//                for (int i = 1; i <= n; i++) {
//                    if (nods[i].fathers == 0&&!nods[i].hasVisited) {
//                        queue[rear++] = nods[i];
//                        nods[i].hasVisited=true;
//                        for (int j = 0; j < nods[i].children.size(); j++)
//                            nods[i].children.get(j).fathers--;
//                    }
//                }
//            }
//            for(int i = 0;i < n; i++){
//                nod v = queue[i];
//                for(int j = 0; j < v.father.size();j++)
//                    v.sum+=(v.father.get(j).sum+a[v.father.get(j).index])%(Math.pow(10,9)+7);
//            }
//            long s = 0;
//            for(int i = 1; i <= n; i++) {
//                s += (nods[i].sum * b[i]) % (Math.pow(10, 9) + 7);
//                s = s%(1000000007);
//            }
//            out.println(s);
//        }
//
//        out.close();
//    }
//    public static void reV(nod v){
//        v.hasVisited=false;
//        if(v.children.size()!=0)
//            for(int i = 0; i < v.children.size(); i++)
//                reV(v.children.get(i));
//    }
//}
//
//class nod{
//    int index;
//    boolean hasVisited;
//    long sum;
//    int fathers;
//    ArrayList<nod> father = new ArrayList<>();
//    ArrayList<nod> children = new ArrayList<>();
//    public nod(int index){
//        this.index = index;
//    }
//}
//
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//}
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
