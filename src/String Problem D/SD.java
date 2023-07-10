// //Java Fast IO
// import java.io.*;
// import java.util.*;
//
// public class SD {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//
//        if(s1.length()!=s2.length())out.println("No");
//        else {
//            String s3 = s2+s2;
//            int[][] map = new int[s1.length()][26];
//            int next = 0;
//            map[0][s1.charAt(0)-'a']=1;
//            for(int i = 1; i < s1.length(); i++){
//                for(int j = 0; j < 26; j++){
//                    if(s1.charAt(i)=='a'+j)map[i][j]=i+1;
//                    else map[i][j]=map[next][j];
//                }
//                next=map[next][s1.charAt(i)-'a'];
//            }
//
//            int q = 0;
//            boolean flag = true;
//            for(int i = 0; i < s3.length()-1; i++){
//                q = map[q][s3.charAt(i)-'a'];
//                if (q == s1.length()){
//                    out.println("Yes");
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                out.println("No");
//            }
//        }
//
//        out.close();
//    }
// }
//
// class QReader {
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
// }
//
// class QWriter implements Closeable {
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
// }
