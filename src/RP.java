public class RP {
   public static void main(String[] args){
       QReader input = new QReader();
       int t = input.nextInt();
       QWriter out = new QWriter();
       for(int s = 0; s < t; s++){
           int an = input.nextInt();
           int bn = input.nextInt();
           {
               int[] a = new int[an];
               int[] b = new int[bn];
               int[] c = new int[an + bn];
               for (int l = 0; l < an; l++) {
                   a[l] = input.nextInt();
               }
               for (int l = 0; l < bn; l++) {
                   b[l] = input.nextInt();
               }
               int i = 0;
               int j = 0;
               int k = 0;
               long cnt = 0;
               while (i < an && j < bn) {
                   if (a[i] > b[j]) {
                       cnt+=an-i;
                       c[k] = b[j];
                       k++;
                       j++;
                   } else {
                       c[k] = a[i];
                       k++;
                       i++;
                   }
               }
               if (i < an) {
                   c[k] = a[i];
                   k++;
                   i++;
                   while (i < an) {
                       c[k] = a[i];
                       k++;
                       i++;
                   }
               }
               if (j < bn) {
                   while (j < bn) {
                       c[k] = b[j];
                       k++;
                       j++;
                   }
               }
               out.println(cnt);
               for (int l = 0; l < an + bn; l++) {
                   out.print(c[l] + " ");
               }
               out.print("\n");
           }
       }
       out.close();
   }
}
