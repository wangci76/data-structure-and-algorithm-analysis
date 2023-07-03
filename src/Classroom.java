////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class Classroom {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int T = in.nextInt();
//        for(int i = 0; i < T; i++){
//            int n = in.nextInt();
//            String s = in.next();
//            if(n%2==1){
//                out.println("NO");
//            }
//            else {
//                char[] stack = new char[n];
//                if(isNice(s,stack,n))out.println("YES");
//                else out.println("NO");
//            }
//        }
//
//        out.close();
//    }
//    public static boolean isNice(String s,char[] stack,int n){
//        int index = 0;
//
//        for(int i = 0; i < n; i++){
//            char c = s.charAt(i);
//            if(c=='{'||c=='('||c=='[')stack[index++]=c;
//            else {
//                if(index==0)return false;
//                else {
//                    char left = stack[--index];
//                    if(!(left=='{'&&c=='}'||left=='('&&c==')'||left=='['&&c==']'))
//                        return false;
//                }
//            }
//        }
//
//        if(index==0)return true;
//        else return false;
//    }
//}
//
//class Chain{
//    public long pos;
//    public Chain next;
//    public Chain chain;
//    public Chain before;
//    public boolean isCheck;
//    public Chain(long pos){
//        this.pos=pos;
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
