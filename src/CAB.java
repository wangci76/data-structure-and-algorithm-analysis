////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class CAB {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        boolean gob = false;
//
//        int n = in.nextInt();
//        int m = in.nextInt();
//        nod[] nods = new nod[n+1];
//        for(int i = 1; i <= n; i++)
//            nods[i] = new nod(i);
//        for(int i = 1; i <= m; i++){
//            int p = in.nextInt();
//            int q = in.nextInt();
//            if(p==q)gob=true;
//            for(int j = 0; j < nods[p].outNeighbor.size(); j++){
//                if(nods[p].outNeighbor.get(j).index==q)gob=true;
//            }
//            nods[p].outNeighbor.add(nods[q]);
//            nods[q].outNeighbor.add(nods[p]);
//        }
//        nod[] stack = new nod[n];
//        int count = 0;
//        ArrayList<nod> roots = new ArrayList<>();
//        for(int r = 1; r <= n; r++){
//            nod root = nods[r];
//            if(root.color==0){
//                roots.add(root);
//                int peek = 0;
//                stack[peek++]=root;
//                root.color=1;
//                root.inCount=count;
//                count++;
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
//                        u.inCount=count;
//                        count++;
//                        u.color = 1;
//                        v = u;
//                    } else {
//                        peek--;
//                        v.outCount=count;
//                        count++;
//                        v.color = 2;
//                    }
//                }
//            }
//        }
//        for(nod e : roots){
//            nod[] queue = new nod[n];
//            int peek = 0;
//            int rear = 0;
//            queue[rear++] = e;
//            while(peek!=rear){
//                nod temp = queue[peek];
//                peek++;
//                temp.hasVisited=true;
//                for(int j = 0; j < temp.children.size(); j++){
//                    nod v = temp.children.get(j);
//                    if(!v.hasVisited){
//                        queue[rear++]=v;
//                        for(int k = 0; k < v.outNeighbor.size(); k++){
//                            if(v.outNeighbor.get(k).hasVisited&&v.outNeighbor.get(k)!=temp)gob=true;
//                        }
//                    }
//                }
//            }
//        }
//        if(!gob)out.println("Good");
//        else out.println("Bad");
//
//        out.close();
//    }
//}
//
//class nod{
//    int index;
//    int color;//0 means white, 1 yellow, 2 red
//    int inCount;
//    int outCount;
//    boolean hasVisited;
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
