////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class MD {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        nod[] as = new nod[n];
//        for(int i = 0; i < n; i++){
//            int value = in.nextInt();
//            nod a = new nod(value);
//            as[i] = a;
//        }
//        nod[] bs = as.clone();
//        sort(as);
//
//        for(int i = 0; i < n-1; i++){
//            nod a = as[i];
//            nod b = as[i+1];
//            a.next = b;
//            b.before = a;
//        }
//
//        for(int i = 0; i < n-1; i++){
//            nod a = bs[i];
//            long p = 1000000000;
//            long q = 1000000000;
//            if(a.before!=null)p=Math.abs(a.value-a.before.value);
//            if(a.next!=null)q=Math.abs(a.value-a.next.value);
//            if(p<q)out.print(p+" ");
//            else out.print(q+" ");
//            if(a.before==null)a.next.before=null;
//            else if(a.next==null)a.before.next=null;
//            else {
//                a.before.next=a.next;
//                a.next.before=a.before;
//            }
//        }
//
//
//        out.close();
//    }
//
//    public static void sort(nod[] a){
//        nod[] temp = new nod[a.length];
//        ms(a,temp,0,a.length-1);
//    }
//    public static void ms(nod[] a, nod[] t, int be, int e){
//        if(be<e){
//            int mid = (be + e) / 2;
//            ms(a, t, be, mid);
//            ms(a, t, mid + 1, e);
//            merge(a, t, be, mid, e);
//        }
//    }
//    public static void merge(nod[] a, nod[] t, int be, int mid, int e){
//        int lp = be;
//        int rp = mid+1;
//        int p = be;
//        while(lp<=mid&&rp<=e){
//            if(a[lp].value<=a[rp].value) {
//                t[p] = a[lp];
//                p++;lp++;
//            }
//            else {
//                t[p] = a[rp];
//                p++;rp++;
//            }
//        }
//        while(lp<=mid) {
//            t[p] = a[lp];
//            p++;
//            lp++;
//        }
//        while(rp<=e) {
//            t[p] = a[rp];
//            p++;rp++;
//        }
//        while(be<=e){
//            a[be]=t[be];
//            be++;
//        }
//    }
//}
//
//class nod{
//    public long value;
//    nod next;
//    nod before;
//    public nod(int value){
//        this.value = value;
//    }
//}
//
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
