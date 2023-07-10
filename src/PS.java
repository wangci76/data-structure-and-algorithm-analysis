public class PS {
   public static void main(String[] args){
       QReader input = new QReader();
       QWriter out = new QWriter();

       long n = input.nextLong();
       long m = input.nextLong();

       node head = new node(2000000000,2000000000);

       node cur;
       cur = head;
       for(long i = 0; i < n; i++){
           node a = new node(input.nextLong(),input.nextLong());
           cur.next = a;
           cur = cur.next;
       }
       node tail = new node(-2000000000,-2000000000);
       cur.next = tail;

       cur = head;
       for(long i = 0; i < m; i++){
           long coe2 = input.nextLong();
           long exp2 = input.nextLong();

           while(cur.next.exp>=exp2){
               cur = cur.next;
           }
           if(cur.exp==exp2){
               cur.coe+=coe2;
           }
           else {
               node a = new node(coe2,exp2);
               a.next=cur.next;
               cur.next = a;
           }
       }
       long cnt = 0;
       cur = head.next;
       while(cur!=tail){
           if(cur.coe!=0){
               cnt++;
           }
           cur=cur.next;
       }

       cur = head.next;
       out.println(cnt);
       while(cur!=tail){
           if(cur.coe!=0){
               out.println(cur.coe+" "+cur.exp);
           }
           cur=cur.next;
       }

       out.close();
   }

}

class node{
   public long coe;
   public long exp;
   node next;

   public node(long coe,long exp){
       this.coe = coe;
       this.exp = exp;
   }
}
