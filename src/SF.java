////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class SF {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        char[] codeTable = new char[26];
//        for(int i = 0; i < 26; i++)codeTable[i]=in.next().charAt(0);
//        String s = in.nextLine();
//        int len = s.length();
//        int mid = 0;
//        if(len%2==1)mid=len/2+1;
//        else mid=len/2;
//        int ans = 0;
//
//        int[][] map = new int[s.length()][26];
//        int next = 0;
//        map[0][s.charAt(0)-'a']=1;
//        for(int i = 1; i < mid; i++){
//            for(int j = 0; j < 26; j++){
//                if(s.charAt(i)=='a'+j)map[i][j]=i+1;
//                else map[i][j]=map[next][j];
//            }
//            next=map[next][s.charAt(i)-'a'];
//        }
//        for(int i = mid; i < s.length(); i++){
//            for(int j = 0; j < 26; j++){
//                if(codeTable[s.charAt(i)-'a']=='a'+j)map[i][j]=i+1;
//                else map[i][j]=map[next][j];
//            }
//            next=map[next][codeTable[s.charAt(i)-'a']-'a'];
//        }
//        //for(int k = mid; k < len; k++){
//            //force
//            /*int j = 0;
//            while(i+j<len){
//                char c = codeTable[s.charAt(i+j)-'a'];
//                if(s.charAt(j)!=c)break;
//                else j++;
//            }
//            if(i+j==len) {
//                ans = i;
//                break;
//            }*/
//
//        out.println(s.length()-next);
//
//        out.close();
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
