// //Java Fast IO
// import java.io.*;
// import java.util.*;

// public class StableMatching {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();

//        int n = in.nextInt();
//        HashMap<String, Integer> boysHash = new HashMap<String, Integer>();
//        HashMap<String, Integer> girlsHash = new HashMap<String, Integer>();
//        String[] bs = new String[n];
//        String[] gs = new String[n];
//        int[][] boyPre = new int[n][n];
//        int[][] girlPre = new int[n][n];

//        String s;
//        int key;
//        for(int i = 0; i < n; i++) {
//            s = in.next();
//            boysHash.put(s, i);
//            bs[i] = s;
//        }
//        for(int i = 0; i < n; i++) {
//            s = in.next();
//            girlsHash.put(s, i);
//            gs[i] = s;
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                s = in.next();
//                key = girlsHash.get(s);
//                boyPre[i][j] = key;
//            }
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                s = in.next();
//                key = boysHash.get(s);
//                girlPre[i][key] = j;
//            }
//        }

//        int[] pre = new int[n];
//        int[] hasMatched = new int[n];
//        for(int i = 0; i < n; i++)hasMatched[i] = n;
//        int[] freeBoy = new int[n];
//        int index = 0;
//        for(int i = 0; i < n; i++)
//            freeBoy[index++] = i;
//        while (index>0){
//            int man = freeBoy[--index];
//            int woman = boyPre[man][pre[man]];
//            if(hasMatched[woman]==n)
//                hasMatched[woman] = man;
//            else{
//                int anotherMan = hasMatched[woman];
//                if(girlPre[woman][anotherMan]<girlPre[woman][man]) {
//                    pre[man]++;
//                    freeBoy[index++] = man;
//                }
//                else {
//                    hasMatched[woman] = man;
//                    pre[anotherMan]++;
//                    freeBoy[index++] = anotherMan;
//                }
//            }
//        }
//        int[] ans = new int[n];
//        for(int i = 0; i < n; i++)
//            ans[hasMatched[i]] = i;
//        for(int i = 0; i < n; i++)
//            out.println(bs[i]+" "+gs[ans[i]]);

//        out.close();
//    }
// }




// class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");

//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }

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

//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }

//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }

//    public int nextInt() {
//        return Integer.parseInt(next());
//    }

//    public long nextLong() {
//        return Long.parseLong(next());
//    }
// }

// class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }

//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }

//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
// }
