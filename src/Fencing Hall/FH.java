// //Java Fast IO
// import java.io.*;
// import java.util.*;
//
// public class FH {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//
//        {
//            int k = in.nextInt();
//            int n = in.nextInt();
//            long length = 0;
//            if(k!=0){
//                nod head = new nod(0, -1);
//                nod cur = head;
//                for (int i = 0; i < n; i++) {
//                    nod temp = new nod(in.nextInt(), i);
//                    cur.next = temp;
//                    temp.before = cur;
//                    cur.nextForMax = temp;
//                    temp.beforeForMax = cur;
//                    cur.nextForMin = temp;
//                    temp.beforeForMin = cur;
//                    cur = cur.next;
//                }
//                nod tail = new nod(0, n);
//                cur.next = tail;
//                tail.before = cur;
//                cur.nextForMax = tail;
//                tail.beforeForMax = cur;
//                cur.nextForMin = tail;
//                tail.beforeForMin = cur;
//
//                cur = head;
//                nod rec, val, mob;
//                boolean flag = true;
//                while (cur.next != tail) {
//                    cur = cur.next;
//
//
//                    rec = cur;
//                    while (rec.beforeForMax != head) {
//                        rec = rec.beforeForMax;
//                        if (rec.value < cur.value) {
//                            rec.beforeForMax.nextForMax = rec.nextForMax;
//                            rec.nextForMax.beforeForMax = rec.beforeForMax;
//                        } else break;
//                    }
//                    rec = cur;
//                    while (rec.beforeForMin != head) {
//                        rec = rec.beforeForMin;
//                        if (rec.value > cur.value) {
//                            rec.beforeForMin.nextForMin = rec.nextForMin;
//                            rec.nextForMin.beforeForMin = rec.beforeForMin;
//                        } else break;
//                    }
//                    rec = cur;
//                    while (rec.beforeForMax != head) rec = rec.beforeForMax;
//                    long max = rec.value;
//                    val = cur;
//                    while (val.beforeForMin != head) val = val.beforeForMin;
//                    long min = val.value;
//                    long ans = max - min;
//
//
//
//                    while (ans > k) {
//                        flag=false;
//                        if (rec.pos > val.pos) {
//                            mob = head.next;
//                            if (length < cur.pos - mob.pos) {
//                                length = cur.pos - mob.pos;
//                            }
//                            while (mob != val) {
//                                mob.before.next = mob.next;
//                                mob.next.before = mob.before;
//                                mob = mob.next;
//                            }
//                            val.before.next = val.next;
//                            val.next.before = val.before;
//                            val.nextForMin.beforeForMin = val.beforeForMin;
//                            val.beforeForMin.nextForMin = val.nextForMin;
//                        } else {
//                            mob = head.next;
//                            if (length < cur.pos - mob.pos) {
//                                length = cur.pos - mob.pos;
//                            }
//                            while (mob != rec) {
//                                mob.before.next = mob.next;
//                                mob.next.before = mob.before;
//                                mob = mob.next;
//                            }
//                            if (rec.pos != val.pos) {
//                                rec.before.next = rec.next;
//                                rec.next.before = rec.before;
//                            }
//                            rec.nextForMax.beforeForMax = rec.beforeForMax;
//                            rec.beforeForMax.nextForMax = rec.nextForMax;
//                        }
//                        rec = cur;
//                        while (rec.beforeForMax != head) rec = rec.beforeForMax;
//                        max = rec.value;
//                        val = cur;
//                        while (val.beforeForMin != head) val = val.beforeForMin;
//                        min = val.value;
//                        ans = max - min;
//                    }
//                }
//                if(flag)length=n;
//            }
//            else {
//                int[] a = new int[n];
//                int count = 0;
//                for(int i = 0; i < n; i++){
//                    a[i] = in.nextInt();
//                }
//                for(int i = 1; i < n; i++){
//                    if(a[i]==a[i-1])count++;
//                    else {
//                        if(count+1>length)length=count+1;
//                        count=0;
//                    }
//                }
//            }
//
//            out.println(length);
//        }
//
//        out.close();
//    }
// }
// class nod{
//    public long value;
//    public long pos;
//    public nod next;
//    public nod before;
//    public nod nextForMax;
//    public nod beforeForMax;
//    public nod nextForMin;
//    public nod beforeForMin;
//    public nod(long value, long pos){
//        this.value = value;
//        this.pos = pos;
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
