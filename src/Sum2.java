////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class Sum2 {
//    static long sum = 0;
//    static long s = 0;
//    static int n;
//    static int m;
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int T = in.nextInt();
//        for(int t = 1; t <= T; t++){
//            s = 0;
//            n = in.nextInt();
//            m = in.nextInt();
//            nod[][] mat = new nod[n+2][m+2];
//            for(int row = 0; row <= n+1; row++)
//                for(int col = 0; col <= m+1; col++)
//                    mat[row][col] = new nod((row-1)*m+col,-1);
//            for(int row = 1; row <= n; row++) {
//                for (int col = 1; col <= m; col++) {
//                    mat[row][col].value = in.nextLong();
//                    mat[row][col].children.add(mat[row-1][col-1]);
//                    mat[row][col].children.add(mat[row][col-1]);
//                    mat[row][col].children.add(mat[row+1][col-1]);
//                    mat[row][col].children.add(mat[row+1][col]);
//                    mat[row][col].children.add(mat[row+1][col+1]);
//                    mat[row][col].children.add(mat[row][col+1]);
//                    mat[row][col].children.add(mat[row-1][col+1]);
//                    mat[row][col].children.add(mat[row-1][col]);
//                }
//            }
//            DFS(mat, mat[1][1]);
//            out.println(s);
//        }
//
//        out.close();
//    }
//
//    public static void DFS(nod[][] nods, nod v){
//        if(v.value!=-1){
//            boolean canBeChosen = true;
//            int col = (v.index - 1) % m + 1;
//            int row = (v.index - col) / m + 1;
//            for (int i = 0; i < v.children.size(); i++) {
//                if (v.children.get(i).hasVisited) {
//                    canBeChosen = false;
//                    break;
//                }
//            }
//            if (canBeChosen) {
//                v.hasVisited = true;
//                sum += v.value;
//                if(sum>s)s=sum;
//                if (col == m) DFS(nods, nods[row + 1][1]);
//                else DFS(nods, nods[row][col + 1]);
//                v.hasVisited = false;
//                sum -= v.value;
//            }
//            if (col == m) DFS(nods, nods[row + 1][1]);
//            else DFS(nods, nods[row][col + 1]);
//        }
//    }
//}
//
//class nod{
//    int index;
//    long value;
//    boolean hasVisited;
//    ArrayList<nod> children = new ArrayList<>();
//    public nod(int index, long value){
//        this.index=index;
//        this.value=value;
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
