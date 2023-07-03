////Java Fast IO
//import java.io.*;
//import java.util.*;
//
//public class PVZ {
//    public static void main(String[] args){
//        QReader input = new QReader();
//        QWriter out = new QWriter();
//
//        int n = input.nextInt();
//        int p = input.nextInt();
//        long con = 1;
//        for(int i = 0; i < p; i++)
//            con*=2;
//        int q = input.nextInt();
//        long[][] num = new long[5][n];
//        long[] h = new long[n];
//        long[] s = new long[n];
//        long[] hMs = new long[n];
//        for(int i = 0; i < n; i++){
//            num[0][i] = input.nextInt();
//            num[1][i] = input.nextInt();
//            num[2][i] = num[0][i] - num[1][i];
//            num[3][i] = num[0][i]*con - num[1][i];
//            num[4][i] = 0;
//        }
//
//        long sum = 0;
//        long min = 0;
//        boolean qHasMore = false;
//
//        if(q==0){
//            for(int i = 0; i < n; i++)
//                sum+=num[1][i];
//        }
//        else if(q<n){
//            sort(num,2);
//            for(int i = n - 1; i >= n - q; i--){
//                if(num[2][i]>0){
//                    num[4][i] = 1;
//                    sum+=num[0][i];
//                    num[3][i]=num[0][i]*con-num[0][i];
//                    min = num[0][i]-num[1][i];
//                    num[1][i] = num[0][i];
//                }
//                else {
//                    sum += num[1][i];
//                    qHasMore=true;
//                }
//            }
//            for(int i = n - q - 1; i >= 0; i--)
//                sum+=num[1][i];
//        }
//        else {
//            qHasMore=true;
//            for(int i = n - 1; i >= 0; i--){
//                if(num[2][i]>0){
//                    num[4][i] = 1;
//                    sum+=num[0][i];
//                    num[3][i] = num[0][i] * con - num[0][i];
//                    min = num[0][i] - num[1][i];
//                    num[1][i] = num[0][i];
//                }
//                else {
//                    sum += num[1][i];
//                }
//            }
//        }
//
//        if(p==0)out.println(sum);
//        else if(q==0)out.println(sum);
//        else if(qHasMore){
//            sort(num,3);
//            sum=sum+num[0][n-1]*con-num[1][n-1];
//            out.println(sum);
//        }
//        else {
//            long max = 0;
//            for(int i = 0 ; i < n; i++){
//                if(num[4][i]==1&&num[3][i]>max)max=num[3][i];
//                else if(num[4][i]==0&&num[3][i]-min>max)max=num[3][i]-min;
//            }
//            sum+=max;
//            out.println(sum);
//        }
//
//        out.close();
//    }
//
//    public static void sort(long[][] a,int w){
//        long[][] temp = new long[5][a[0].length];
//        ms(a,temp,0,a[0].length-1,w);
//    }
//    public static void ms(long[][] a, long[][] t, int be, int e,int w){
//        if(be<e){
//            int mid = (be + e) / 2;
//            ms(a, t, be, mid,w);
//            ms(a, t, mid + 1, e,w);
//            merge(a, t, be, mid, e,w);
//        }
//    }
//    public static void merge(long[][] a, long[][] t, int be, int mid, int e,int w){
//        int lp = be;
//        int rp = mid+1;
//        int p = be;
//        while(lp<=mid&&rp<=e){
//            if(a[w][lp]<=a[w][rp]) {
//                t[0][p] = a[0][lp];
//                t[1][p] = a[1][lp];
//                t[2][p] = a[2][lp];
//                t[3][p] = a[3][lp];
//                t[4][p] = a[4][lp];
//                p++;lp++;
//            }
//            else {
//                t[0][p] = a[0][rp];
//                t[1][p] = a[1][rp];
//                t[2][p] = a[2][rp];
//                t[3][p] = a[3][rp];
//                t[4][p] = a[4][rp];
//                p++;rp++;
//            }
//        }
//        while(lp<=mid) {
//            t[0][p] = a[0][lp];
//            t[1][p] = a[1][lp];
//            t[2][p] = a[2][lp];
//            t[3][p] = a[3][lp];
//            t[4][p] = a[4][lp];
//            p++;
//            lp++;
//        }
//        while(rp<=e) {
//            t[0][p] = a[0][rp];
//            t[1][p] = a[1][rp];
//            t[2][p] = a[2][rp];
//            t[3][p] = a[3][rp];
//            t[4][p] = a[4][rp];
//            p++;rp++;
//        }
//        while(be<=e){
//            a[0][be]=t[0][be];
//            a[1][be]=t[1][be];
//            a[2][be]=t[2][be];
//            a[3][be]=t[3][be];
//            a[4][be]=t[4][be];
//            be++;
//        }
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
