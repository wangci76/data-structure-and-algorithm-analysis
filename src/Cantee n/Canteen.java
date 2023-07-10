// //Java Fast IO
// import java.io.*;
// import java.util.*;
//
// public class Canteen {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        int T = in.nextInt();
//        String[] foodStack = new String[100000];
//        int stackIndex = 0;
//        String[] favorites = new String[100000];
//        int queuePeek = 0;
//        int queueRear = 0;
//        for(int i = 0; i < T; i++){
//            String str = in.nextLine();
//            String[] s = str.split(" ");
//            if(s[0].equals("NewComer"))favorites[queueRear++]=s[1];
//            else if(s[0].equals("NewFood"))foodStack[stackIndex++]=s[1];
//            else if(stackIndex!=0&&queuePeek<queueRear){
//                if(foodStack[stackIndex-1].equals(favorites[queuePeek])){
//                    stackIndex--;
//                    queuePeek++;
//                }
//                else
//                    favorites[queueRear++]=favorites[queuePeek++];
//            }
//        }
//
//        int numbersOfQueue = queueRear-queuePeek;
//        int count = 0;
//        boolean flag = true;
//        while(flag){
//            numbersOfQueue=queueRear-queuePeek;
//            if(favorites[queuePeek].equals(foodStack[stackIndex-1])){
//                stackIndex--;
//                queuePeek++;
//                count=0;
//            }
//            else {
//                favorites[queueRear++] = favorites[queuePeek++];
//                count++;
//            }
//
//            if(stackIndex==0||favorites[queuePeek]==null||count==numbersOfQueue){
//                flag = false;
//            }
//        }
//
//        if(stackIndex==0||favorites[queuePeek]==null)
//            out.println("Qi Fei!");
//        else out.println(numbersOfQueue);
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
