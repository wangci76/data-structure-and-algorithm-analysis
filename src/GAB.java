//Java Fast IO
import java.io.*;
import java.util.*;

public class GAB {
   static boolean up = false;
   public static void main(String[] args) {
       QReader in = new QReader();
       QWriter out = new QWriter();

       long count = 0;
       nod ha = null;
       nod hb = null;

       int M = in.nextInt();
       for(int i = 0; i < M; i++){
           int k = in.nextInt();
           int value = in.nextInt();
           nod temp = new nod(value);
           nod p1 = new nod(0);
           nod p2 = new nod(0);

           if(k==1){
               if(hb==null){
                   if (ha != null) ha = insertion(ha, temp);
                   else ha = temp;
               }
               else {
                   nod pre = preSearch(hb,p1,temp);
                   nod post = postSearch(hb,p2,temp);
                   int pr = Math.abs(pre.value-temp.value);
                   int po = Math.abs(post.value-temp.value);
                   if(pre.value==0) {
                       count+=po;
                       hb = deletion(hb, post);
                   }
                   else if(post.value==0){
                       count+=pr;
                       hb = deletion(hb,pre);
                   }
                   else if(post.value== pre.value) {
                       count+=pr;
                       hb = deletion(hb, pre);
                   }
                   else if(pr>po){
                       count+=po;
                       hb = deletion(hb, post);
                   }
                   else {
                       count+=pr;
                       hb = deletion(hb,pre);
                   }
               }
           }
           if(k==0){
               if(ha==null){
                   if (hb != null) hb = insertion(hb, temp);
                   else hb = temp;
               }
               else {
                   nod pre = preSearch(ha,p1,temp);
                   nod post = postSearch(ha,p2,temp);
                   int pr = Math.abs(pre.value-temp.value);
                   int po = Math.abs(post.value-temp.value);
                   if(pre.value==0) {
                       count+=po;
                       ha = deletion(ha, post);
                   }
                   else if(post.value==0){
                       count+=pr;
                       ha = deletion(ha,pre);
                   }
                   else if(post.value== pre.value) {
                       count += pr;
                       ha = deletion(ha, pre);
                   }
                   else if(pr>po){
                       count+=po;
                       ha = deletion(ha, post);
                   }
                   else {
                       count+=pr;
                       ha = deletion(ha,pre);
                   }
               }
           }
       }

       out.println(count);

       out.close();
   }
   //O(h),更新所有节点的高度,this method is too slow
//    public static int getHeight(nod e){
//        if(e==null)return 0;
//        else {
//            e.height=Math.max(getHeight(e.left), getHeight(e.right))+1;
//            return e.height;
//        }
//    }

   //O(1)，return balance factor
   public static int getFactor(nod e){
       if(e==null)return 0;
       else {
           int lh=0;
           int rh=0;
           if(e.left!=null)lh=e.left.height;
           if(e.right!=null)rh=e.right.height;
           return lh-rh;
       }
   }

   //O(1), turn left and turn right
   public static nod turnLeft(nod u){
       nod newRoot = u.right;
       u.right=newRoot.left;
       if(newRoot.left!=null)newRoot.left.father=u;
       newRoot.left=u;
       u.father=newRoot;
       //u left and newRoot left change
       setHeight(u);
       setHeight(newRoot);
       return newRoot;
   }
   public static nod turnRight(nod u){
       nod newRoot = u.left;
       u.left=newRoot.right;
       if(newRoot.right!=null)newRoot.right.father=u;
       newRoot.right=u;
       u.father=newRoot;
       //u left and newRoot left change
       setHeight(u);
       setHeight(newRoot);
       return newRoot;
   }

   //O(1),四种平衡化操作
   //LL
   public static nod bal1(nod e){
       //return the new root(e.left)
       return turnRight(e);
   }

   //RR
   public static nod bal3(nod e){
       return turnLeft(e);
   }

   //LR
   public static nod bal2(nod e){
       nod newLeft = turnLeft(e.left);
       newLeft.father=e;
       e.left=newLeft;
       return turnRight(e);
   }

   //RL
   public static nod bal4(nod e){
       nod newRight = turnRight(e.right);
       newRight.father=e;
       e.right=newRight;
       return turnLeft(e);
   }

   //O(h),balance
   public static nod balance(nod e){
       //getHeight(e);
       int facE = getFactor(e);
       int facL = getFactor(e.left);
       int facR = getFactor(e.right);
       nod cur = e;
       //cur is the newest root
       nod father = e.father;
       //father is the higher level root
       //LL,包含同样高
       if(facE==2&&facL>=0)cur=bal1(e);
           //LR
       else if(facE==2)cur=bal2(e);
           //RR，包含同样高
       else if(facE==-2&&facR<=0)cur=bal3(e);
           //RL
       else if(facE==-2)cur=bal4(e);
       if(father!=null){
           if (e.value > father.value) father.right = cur;
           else father.left = cur;
           cur.father = father;
       }
       else cur.father=null;
       return cur;
   }

   //Insertion,need to carefully manager tree height
   public static nod insertion(nod u, nod e){
       if(e.value<u.value){
           if(u.left!=null) {
               nod root = insertion(u.left, e);
               //complete the insertion in the lower level
               u.left=root;
               root.father=u;
           }
           else {
               u.left=e;
               e.father=u;
           }
       }
       //we assume that there are no same values
       else{
           if(u.right!=null) {
               nod root = insertion(u.right, e);
               u.right=root;
               root.father=u;
           }
           else {
               u.right=e;
               e.father=u;
           }
       }
       //In the lowest level, the tree height of e / u.child is 1(initial value)
       setHeight(u);
       //返回平衡之后的root,复杂度为当前高度
       return balance(u);
   }

   public static void setHeight(nod u){
       if(u.right!=null&&u.left!=null)u.height= Math.max(u.right.height,u.left.height)+1;
       else if(u.right!=null)u.height=u.right.height+1;
       else if(u.left!=null)u.height=u.left.height+1;
       else u.height=1;
   }

   //Deletion
   //assume that p exist in the tree
   public static nod deletion(nod u, nod p){
       if(p.value==u.value){
           //找到待删除结点p
           if(u.left==null&&u.right==null){
               //it is a leaf
               if(u.father!=null){
                   if (u.value > u.father.value) {
                       u.father.right = null;
                       u.father = null;
                   } else {
                       u.father.left = null;
                       u.father = null;
                   }
               }
               return null;
           }
           else{
               if(u.left==null){
                   //it only has right child
                   if(u.father!=null){
                       if (u.value > u.father.value) {
                           u.father.right = u.right;
                           u.right.father=u.father;
                       }
                       else {
                           u.father.left = u.right;
                           u.right.father=u.father;
                       }
                   }
                   else u.right.father=null;
                   u=u.right;
               }
               else if(u.right==null){
                   //u only has left child
                   if(u.father!=null){
                       if (u.value > u.father.value) {
                           u.father.right = u.left;
                           u.left.father=u.father;
                       }
                       else {
                           u.father.left = u.left;
                           u.left.father = u.father;
                       }
                   }
                   else u.left.father=null;
                   u=u.left;
               }
               else {
                   //牺牲一点复杂度先把后继找出来, it certainly exists
                   nod part = new nod(Integer.MIN_VALUE);
                   //因为是整型，设定成+1，以免返回root
                   nod q = new nod(u.value+1);
                   nod next = postSearch(u,part,q);

                   nod father = u.father;
                   nod temp = del(u,u,next);
                   //temp is the new root, it equals next and it should replace u
                   if(father!=null){
                       if (u.value > father.value) {
                           father.right = temp;
                           temp.father = father;
                       } else {
                           father.left = temp;
                           temp.father = father;
                       }
                   }
                   else temp.father=null;
                   u=temp;
                   //height of temp has been set in del
               }
           }
       }
       else if(p.value>u.value){
           //p在右子树
           nod temp = deletion(u.right,p);
           if(temp!=null){
               u.right = temp;
               temp.father = u;
           }
           setHeight(u);
       }
       else {
           //p在左子树
           nod temp = deletion(u.left,p);
           if(temp!=null) {
               u.left = temp;
               temp.father = u;
           }
           setHeight(u);
       }
       return balance(u);
   }

   //针对后继的子方法
   public static nod del(nod ini, nod u, nod p){
       if(p.value==u.value){
           up = true;
           //最底层循环
           //找到待删除后继p
           //取代
           if(ini.father!=null){
               if (ini.value > ini.father.value) ini.father.right = u;
               else ini.father.left = u;
           }
           if((ini.left!=null)&&(ini.left!=p))ini.left.father=u;
           if((ini.right!=null)&&(ini.right!=p))ini.right.father=u;
           //删除
           if(u.right!=null&&u.father!=null){
               if(u.value>u.father.value) {
                   u.father.right = u.right;
                   u.right.father=u.father;
               }
               else {
                   u.father.left = u.right;
                   u.right.father=u.father;
               }
           }
           else if (u.right!=null)u.right.father=null;
           else if(u.father!=null){
               if(u.value>u.father.value)u.father.right=null;
               else u.father.left=null;
           }
           nod right = u.right;
           u.father=ini.father;
           u.left=ini.left;
           u.right=ini.right;
           if(right!=null)return balance(right);
           else return null;
       }
       else if(p.value>u.value){
           //p在右子树
           nod temp = del(ini, u.right, p);
           if(!(u==ini&&up)){
               u.right = temp;
               if (temp != null) temp.father = u;
               setHeight(u);
           }
           else {
               p.right = temp;
               if (temp != null) temp.father = p;
               setHeight(p);
               up=false;
               u=p;
           }
       }
       else {
           //p在左子树
           nod temp = del(ini, u.left, p);
           if(!(u==ini&&up)){
               u.left = temp;
               if (temp != null) temp.father = u;
               setHeight(u);
           }
           else {
               p.left = temp;
               if (temp != null) temp.father = p;
               setHeight(p);
               up=false;
               u=p;
           }
       }
       return balance(u);
   }

   //查找后继并完成deletion的后继操作，返回的是root,p的初始value为Integer.Min_Value
   public static nod preSearch(nod u, nod p, nod q){
       if(u==null)return p;//因为必然存在后继，所以p不会是初始值
       else if(u.value==q.value){
           p=u;
           return p;
       }
       else if(u.value>q.value)return preSearch(u.left,p,q);
       else {
           p=u;
           return preSearch(u.right,p,q);
       }
   }

   //做题 找前序
   public static nod postSearch(nod u, nod p, nod q){
       if(u==null)return p;
       else if(u.value==q.value){
           p=u;
           return p;
       }
       else if(u.value<q.value)return postSearch(u.right,p,q);
       else {
           p=u;
           return postSearch(u.left,p,q);
       }
   }
}
class nod{
   public int value;
   public int height=1;
   public nod father;
   public nod left;
   public nod right;
   public nod(int value){
       this.value=value;
   }
}

class QReader {
   private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   private StringTokenizer tokenizer = new StringTokenizer("");

   private String innerNextLine() {
       try {
           return reader.readLine();
       } catch (IOException e) {
           return null;
       }
   }

   public boolean hasNext() {
       while (!tokenizer.hasMoreTokens()) {
           String nextLine = innerNextLine();
           if (nextLine == null) {
               return false;
           }
           tokenizer = new StringTokenizer(nextLine);
       }
       return true;
   }

   public String nextLine() {
       tokenizer = new StringTokenizer("");
       return innerNextLine();
   }

   public String next() {
       hasNext();
       return tokenizer.nextToken();
   }

   public int nextInt() {
       return Integer.parseInt(next());
   }

   public long nextLong() {
       return Long.parseLong(next());
   }
}

class QWriter implements Closeable {
   private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

   public void print(Object object) {
       try {
           writer.write(object.toString());
       } catch (IOException e) {
           return;
       }
   }

   public void println(Object object) {
       try {
           writer.write(object.toString());
           writer.write("\n");
       } catch (IOException e) {
           return;
       }
   }

   @Override
   public void close() {
       try {
           writer.close();
       } catch (IOException e) {
           return;
       }
   }
}
