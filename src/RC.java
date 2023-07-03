////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class RC {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        int m = in.nextInt();
//        //check[][] checks = new check[100000][100000];
//        int[][] edges = new int[m][2];
//        for(int i = 0; i < m; i++){
//            int u = in.nextInt();
//            int v = in.nextInt();
////            nods[v].outNeighbor.add(nods[u]);
////            sec[u].outNeighbor.add(sec[v]);
//            edges[i][0] = u;
//            edges[i][1] = v;
//        }
//        int ans = Integer.MAX_VALUE;
//        int le = 1;
//        int ri = m;
//        int mid;
//        while(le<=ri){
//            mid = (le+ri)/2;
//            if(check(n,mid,edges)){
//                ans=mid;
//                ri = mid-1;
//            }
//            else le = mid+1;
//        }
//        if(ans<Integer.MAX_VALUE)
//        out.println(ans);
//        else out.println(-1);
//
//        out.close();
//    }
//    public static boolean check(int n, int mid, int[][] edges){
//        nod[] nods = new nod[n+1];
//        nod[] sec = new nod[n+1];
//        for(int i = 1; i <= n; i++) {
//            nods[i] = new nod(i);
//            sec[i] = new nod(i);
//        }
//        for(int i = 0; i < mid; i++){
//            int u = edges[i][0];
//            int v = edges[i][1];
//            nods[v].outNeighbor.add(nods[u]);
//            sec[u].outNeighbor.add(sec[v]);
//        }
//        return isC(n,nods,sec);
//    }
//
//    public static boolean isC(int n, nod[] nods, nod[] sec){
//        nod[] stack = new nod[n];
//        nod[] qu = new nod[n+1];
//        int ke = n;
//        for(int r = 1; r <= n; r++){
//            nod root = nods[r];
//            if(root.color==0){
//                int peek = 0;
//                stack[peek++]=root;
//                root.color=1;
//                nod v = root;
//                while (peek > 0) {
//                    v = stack[peek-1];
//                    int size = v.outNeighbor.size();
//                    nod u = null;
//                    boolean vHasWhiteOutNeighbor = false;
//                    for (int i = 0; i < size; i++) {
//                        if (v.outNeighbor.get(i).color == 0) {
//                            vHasWhiteOutNeighbor = true;
//                            u = v.outNeighbor.get(i);
//                            break;
//                        }
//                    }
//                    if (vHasWhiteOutNeighbor) {
//                        v.children.add(u);
//                        stack[peek++] = u;
//                        u.color = 1;
//                        v = u;
//                    } else {
//                        peek--;
//                        qu[ke--] = v;
//                        v.color = 2;
//                    }
//                }
//            }
//        }
//        ArrayList<nod> roots = new ArrayList<>();
//        //for(int i = 1; i <= n; i++)out.println(qu[i].index);
//        stack = new nod[n];
//        for(int r = 1; r <= n; r++){
//            nod root = sec[qu[r].index];
//            if(root.color==0){
//                roots.add(root);
//                int peek = 0;
//                stack[peek++]=root;
//                root.color=1;
//                nod v = root;
//                while (peek > 0) {
//                    v = stack[peek-1];
//                    int size = v.outNeighbor.size();
//                    nod u = null;
//                    boolean vHasWhiteOutNeighbor = false;
//                    for (int i = 0; i < size; i++) {
//                        if (v.outNeighbor.get(i).color == 0) {
//                            vHasWhiteOutNeighbor = true;
//                            u = v.outNeighbor.get(i);
//                            break;
//                        }
//                    }
//                    if (vHasWhiteOutNeighbor) {
//                        v.children.add(u);
//                        stack[peek++] = u;
//                        u.color = 1;
//                        v = u;
//                    } else {
//                        peek--;
//                        v.color = 2;
//                    }
//                }
//            }
//        }
//        return roots.size()==1;
//    }
//}
//
//class check{
//    boolean hasCheck;
//}
//
//class whi{
//    int in;
//    int out;
//}
//
//
//class nod{
//    int index;
//    int color;//0 means white, 1 yellow, 2 red
//    int which;
//    ArrayList<nod> outNeighbor = new ArrayList<>();
//    ArrayList<nod> children = new ArrayList<>();
//    public nod(int index){
//        this.index=index;
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
