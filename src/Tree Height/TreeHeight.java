// //Java Fast IO
// import java.io.*;
// import java.math.BigInteger;
// import java.util.*;
//
// public class TreeHeight {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int n = in.nextInt();
//        ArrayList<BigInteger> list = new ArrayList<>();
//        BigInteger start = new BigInteger("2");
//        BigInteger two = new BigInteger("2");
//        BigInteger one = new BigInteger("1");
//        BigInteger a = start.subtract(one);
//        list.add(a);
//        for(int i = 0; i < 60; i++){
//            start = start.multiply(two);
//            BigInteger b = start.subtract(one);
//            list.add(b);
//        }
//        for(int i = 0; i < n; i++){
//            String str = in.nextLine();
//            BigInteger num = new BigInteger(str);
//            for(int j = 0; j < list.size(); j++) {
//                if (list.get(j).compareTo(num) != -1) {
//                    out.println(j+1);
//                    break;
//                }
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
