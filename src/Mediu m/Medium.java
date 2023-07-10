// //Java Fast IO
// import java.io.*;
// import java.util.*;
//
// public class Medium {
//    static int size1;
//    static int size2;
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        size1 = 0;
//        size2 = 0;
//        //insert(,,++size);
//        //ind = tOut(nods).value;
//        int n = in.nextInt();
//        int[] num = new int[n+1];
//        for(int i = 1; i <= n; i++)num[i] = in.nextInt();
//        int[] left = new int[n+1];
//        int[] right = new int[n+1];
//        insertBig(left,num[1],++size1);
//        out.print(num[1]+" ");
//        for(int k = 2; k <= n; k++){
//            int temp = num[k];
//            if(temp<=left[1]){
//                insertBig(left,temp,++size1);
//                if(!(size1==size2||size1==size2+1)) {
//                    int t = tOutBig(left);
//                    insertSmall(right,t,++size2);
//                }
//                out.print(left[1]+" ");
//            }
//            else if(temp>=right[1]){
//                insertSmall(right,temp,++size2);
//                if(!(size1==size2||size1==size2+1)) {
//                    int t = tOutSmall(right);
//                    insertBig(left,t,++size1);
//                }
//                out.print(left[1]+" ");
//            }
//            else{
//                if(size1==size2){
//                    insertBig(left,temp,++size1);
//                    out.print(left[1]+" ");
//                }
//                else if(size1==size2+1){
//                    insertSmall(right,temp,++size2);
//                    out.print(left[1]+" ");
//                }
//            }
//        }
//
//        out.close();
//    }
//    public static void insertBig(int[] a, int b, int index){
//        a[index] = b;
//        int i = index/2;
//        while(i>0&&a[i]<a[index]){
//            int temp = a[index];
//            a[index] = a[i];
//            a[i] = temp;
//            i = i/2;
//            index = index/2;
//        }
//    }
//    public static void insertSmall(int[] a, int b, int index){
//        a[index] = b;
//        int i = index/2;
//        while(i>0&&a[i]>a[index]){
//            int temp = a[index];
//            a[index] = a[i];
//            a[i] = temp;
//            i = i/2;
//            index = index/2;
//        }
//    }
//    public static int tOutBig(int[] nods){
//        int top = nods[1];
//        nods[1] = nods[size1];
//        size1--;
//        int i = 1;
//        while(2*i+1<=size1){
//            int cur;
//            if(nods[2*i]>=nods[2*i+1])cur=2*i;
//            else cur=2*i+1;
//            int t = nods[i];
//            if(t<=nods[cur]){
//                nods[i]=nods[cur];
//                nods[cur]=t;
//                i=cur;
//            }
//            else break;
//        }
//        if(2*i<=size1){
//            if(nods[2*i]>=nods[i]){
//                int t = nods[i];
//                nods[i] = nods[2*i];
//                nods[2*i] = t;
//            }
//        }
//        return top;
//    }
//    public static int tOutSmall(int[] nods){
//        int top = nods[1];
//        nods[1] = nods[size2];
//        size2--;
//        int i = 1;
//        while(2*i+1<=size2){
//            int cur;
//            if(nods[2*i]<=nods[2*i+1])cur=2*i;
//            else cur=2*i+1;
//            int t = nods[i];
//            if(t>=nods[cur]){
//                nods[i]=nods[cur];
//                nods[cur]=t;
//                i=cur;
//            }
//            else break;
//        }
//        if(2*i<=size2){
//            if(nods[2*i]<=nods[i]){
//                int t = nods[i];
//                nods[i] = nods[2*i];
//                nods[2*i] = t;
//            }
//        }
//        return top;
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
