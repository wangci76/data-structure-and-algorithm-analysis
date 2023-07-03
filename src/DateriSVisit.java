////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class DateriSVisit {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        nod[] nods = new nod[n];
//        for(int i = 0; i < n; i++)
//            nods[i] = new nod(i);
//
//        int[] num = new int[10000];
//        for(int i = 0; i < n-1; i++){
//            int j = in.nextInt()-1;
//            int k = in.nextInt()-1;
//            nods[j].children.add(nods[k]);
//            nods[k].children.add(nods[j]);
//            num[j]++;
//            num[k]++;
//        }
//        int count = 0;
//        for(int i = 1; i < 10000; i++)
//            if(num[i]==1)count++;
//        int[] a = new int[count];
//        for(int i = 0; i < count; i++)
//            a[i] = in.nextInt()-1;
//        int[] depth = new int[1];
//        depth[0] = 1;
//        String[] s = new String[1];
//        String s1 = "";
//        s[0] = "";
//        find(depth,nods[0],nods[a[0]],0,s);
//        for(int i = 0; i < n; i++)
//            nods[i].hasVisited=false;
//        s1=s1+s[0];
//        s[0] = "";
//        for(int i = 0; i < count-1; i++){
//            find(depth,nods[a[i]],nods[a[i+1]],a[i],s);
//            for(int j = 0; j < n; j++)
//                nods[j].hasVisited=false;
//            s1=s1+s[0];
//            s[0] = "";
//        }
//        find(depth,nods[a[count-1]],nods[0],a[count-1],s);
//        s1=s1+s[0];
//        if(depth[0]!=2*n-1)out.println(-1);
//        else out.println("1 "+s1);
//
//        out.close();
//    }
//    public static boolean find(int[] depth, nod e, nod target, int ind,String[] s){
//        if(e.index!=ind) {
//            depth[0]++;
//        }
//        e.hasVisited=true;
//
//        if(e==target) {
//            if(e.index!=ind){
//                s[0] = (e.index + 1) + " " + s[0];
//            }
//            return true;
//        }
//
//        if(e.children.size()==1&&e.index!=ind){
//            depth[0]--;
//            return false;
//        }
//
//        for(nod en : e.children){
//            if(!en.hasVisited){
//                if(find(depth,en,target,ind,s)){
//                    if(e.index!=ind){
//                        s[0] = (e.index + 1) + " " + s[0];
//                    }
//                    return true;
//                }
//            }
//        }
//
//        depth[0]--;
//        return false;
//
//    }
//}
//class nod{
//    public int index;
//    public boolean hasVisited;
//    public ArrayList<nod> children = new ArrayList<>();
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
