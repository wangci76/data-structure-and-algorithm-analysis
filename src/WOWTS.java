////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class WOWTS {
//    static int size;
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        size = 0;
//        //insert(,,++size);
//        //ind = tOut(nods).value;
//        int na = in.nextInt();
//        int nb = in.nextInt();
//        int k = in.nextInt();
//        nod[] a = new nod[na+1];
//        int[] t = new int[nb+1];
//        nod[] b = new nod[nb+1];
//        for(int i = 1; i <= na; i++){
//            nod cur = new nod(in.nextInt());
//            a[i] = cur;
//        }
//        for(int i = 1; i <= nb; i++)t[i]=in.nextInt();
//        Arrays.sort(t);
//        for(int i = 1; i <= nb; i++){
//            nod cur = new nod(t[i]);
//            b[i] = cur;
//        }
//        nod[] heap = new nod[na+1];
//        for(int i = 1; i <= na; i++){
//            nod cur = new nod(a[i].value*b[1].value);
//            cur.whicha = i;
//            cur.whichb = 1;
//            insert(heap,cur,++size);
//        }
//        for(int i = 1; i <= k; i++){
//            nod cur = tOut(heap);
//            int qa = cur.whicha;
//            int qb = cur.whichb;
//            if(qb<nb){
//                nod temp = new nod(a[qa].value*b[qb+1].value);
//                temp.whicha=qa;
//                temp.whichb=qb+1;
//                insert(heap,temp,++size);
//            }
//            out.print(cur.value+" ");
//        }
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
//}
//class nod{
//    public long value;
//    public int whicha;
//    public int whichb;
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
