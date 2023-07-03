////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class Huffman {
//    static int size;
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        size = 0;
//
//        nod[] nods = new nod[n+1];
//        //int[] ints = new int[n+1];
//        for(int i = 1; i < n+1; i++){
//            nod cur = new nod(in.nextInt());
//            insert(nods,cur,++size);
//        }
//        //Arrays.sort(ints);
//
////        for(int i = 1; i < n+1; i++){
////            nods[i] = new nod(ints[i]);
////        }
//
//            out.println(create(nods, n));
//
//
//
//        out.close();
//    }
//    public static void insert(nod[] a, nod b, int index){
//        a[index] = b;
//        int i = index/2;
//        while(i>0&&a[i].value>a[index].value){
//            nod temp = a[index];
//            a[index] = a[i];
//            a[i] = temp;
//            i = i/2;
//            index = index/2;
//        }
//    }
//    public static nod tOut(nod[] nods){
//        nod top = nods[1];
//        nods[1] = nods[size];
//        size--;
//        int i = 1;
//        while(2*i+1<=size){
//            int cur;
//            if(nods[2*i].value<=nods[2*i+1].value)cur=2*i;
//            else cur=2*i+1;
//            nod t = nods[i];
//            if(t.value>=nods[cur].value){
//                nods[i]=nods[cur];
//                nods[cur]=t;
//                i=cur;
//            }
//            else break;
//        }
//        if(2*i<=size){
//            if(nods[2*i].value<=nods[i].value){
//                nod t = nods[i];
//                nods[i] = nods[2*i];
//                nods[2*i] = t;
//            }
//        }
//        return top;
//    }
//    public static long create(nod[] nods,int n){
//        long sum = 0;
//        long ind = 0;
//        for(int dic = 1; dic <= (n-1)*2; dic++){
//            ind += tOut(nods).value;
//            if(dic%2==0){
//                nod s = new nod(ind);
//                sum+=ind;
//                {
//                    insert(nods, s, ++size);
//                }
//                ind = 0;
//            }
//        }
//        return sum;
//    }
//}
//class nod{
//    public long value;
//    public nod(long value){
//        this.value = value;
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
