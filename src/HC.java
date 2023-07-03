//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
////Java Fast IO
//import java.io.*;
//        import java.util.*;
//
//public class HC {
//    static long cost;
//    static int size2;
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        size2 = 0;
//        //insert(,,++size);
//        //ind = tOut(nods).value;
//        int n = in.nextInt();
//        int numOfPorts = 3*n*n+3*n+1;
//        int numOfEdges = 9*n*n+3*n;
//        nod[] nods = new nod[numOfPorts+1];
//        for(int i = 1; i <= numOfPorts; i++)nods[i] = new nod(0);
//        int ind = 1;
//        edge[] edges = new edge[numOfEdges+1];
//        int sdd = 1;
//
//        for(int i = 1; i <= 2*n+1; i++){
//            int ns = 2*n+1-Math.abs(i-n-1);
//            for(int j = 1; j <= ns; j++){
//                nod t = nods[ind++];
//                t.weight = in.nextLong();
//            }
//        }
//        ind = 1;
//        for(int i = 1; i <= 2*n+1; i++){
//            int ns = 2*n+1-Math.abs(i-n-1);
//            for(int j = 1; j <= ns; j++){
//                nod t = nods[ind];
//                nod next = null;
//                if(j<ns)next = nods[ind+1];
//                if(next!=null) {
//                    edges[sdd] = new edge(t.weight * next.weight, t, next);
//                    t.connections.add(edges[sdd]);
//                    next.connections.add(edges[sdd]);
//                    sdd++;
//                    next = null;
//                }
//
//                if(i<n+1)next = nods[ind+ns];
//                else if(i>=n+1&&i<2*n+1&&j>1)next = nods[ind+ns-1];
//                if(next!=null) {
//                    edges[sdd] = new edge(t.weight * next.weight, t, next);
//                    t.connections.add(edges[sdd]);
//                    next.connections.add(edges[sdd]);
//                    sdd++;
//                    next = null;
//                }
//
//                if(i<n+1)next = nods[ind+ns+1];
//                else if(i>=n+1&&i<2*n+1&&j<ns)next = nods[ind+ns];
//                if(next!=null) {
//                    edges[sdd] = new edge(t.weight * next.weight, t, next);
//                    t.connections.add(edges[sdd]);
//                    next.connections.add(edges[sdd]);
//                    sdd++;
//                    next = null;
//                }
//                ind++;
//            }
//        }
//
//
//        edge temp = edges[1];
//        for(int i = 2; i <= numOfEdges; i++)
//            if(edges[i].dist<temp.dist)temp=edges[i];
//        temp.ports[0].isRed = true;
//        temp.ports[1].isRed = true;
//        cost+=temp.dist;
//
//        edge[] f = new edge[numOfEdges+1];
//        nod left = temp.ports[0];
//        nod right = temp.ports[1];
//        for(int i = 0; i < left.connections.size(); i++){
//            edge e = left.connections.get(i);
//            if(!e.ports[0].isRed||!e.ports[1].isRed)insertSmall(f,e,++size2);
//        }
//        for(int i = 0; i < right.connections.size(); i++){
//            edge e = right.connections.get(i);
//            if(!e.ports[0].isRed||!e.ports[1].isRed)insertSmall(f,e,++size2);
//        }
//
//        while(size2>0){
//            temp = tOutSmall(f);
//            if(!temp.ports[0].isRed||!temp.ports[1].isRed){
//                cost += temp.dist;
//            }
//
//            for (int i = 0; i < 2; i++) {
//                nod port = temp.ports[i];
//                if(!port.isRed){
//                    port.isRed = true;
//                    for (int j = 0; j < port.connections.size(); j++) {
//                        edge v = port.connections.get(j);
//                        v.isIn = v.ports[0].isRed && v.ports[1].isRed;
//                        if(!v.isIn)insertSmall(f,v,++size2);
//                    }
//                }
//            }
//
//        }
//        out.println(cost);
//
//        out.close();
//    }
//
//    public static void insertSmall(edge[] a, edge b, int index){
//        a[index] = b;
//        int i = index/2;
//        while(i>0&&a[i].dist>a[index].dist){
//            edge temp = a[index];
//            a[index] = a[i];
//            a[i] = temp;
//            i = i/2;
//            index = index/2;
//        }
//    }
//
//    public static edge tOutSmall(edge[] nods){
//        edge top = nods[1];
//        nods[1] = nods[size2];
//        size2--;
//        int i = 1;
//        while(2*i+1<=size2){
//            int cur;
//            if(nods[2*i].dist<=nods[2*i+1].dist)cur=2*i;
//            else cur=2*i+1;
//            edge t = nods[i];
//            if(t.dist>=nods[cur].dist){
//                nods[i]=nods[cur];
//                nods[cur]=t;
//                i=cur;
//            }
//            else break;
//        }
//        if(2*i<=size2){
//            if(nods[2*i].dist<=nods[i].dist){
//                edge t = nods[i];
//                nods[i] = nods[2*i];
//                nods[2*i] = t;
//            }
//        }
//        return top;
//    }
//}
//
//class nod{
//    long weight;
//    boolean isRed;
//    ArrayList<edge> connections = new ArrayList<>();
//    public nod(long index){
//        this.weight = index;
//    }
//}
//
//class edge{
//    long dist;
//    nod[] ports = new nod[2];
//    boolean isIn;
//    public edge(long dist, nod x, nod y){
//        this.dist = dist;
//        this.ports[0] = x;
//        this.ports[1] = y;
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
//
//
//
