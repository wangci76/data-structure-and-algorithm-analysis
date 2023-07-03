import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
//        long n = 0;
//        for(long i = 1; i <= 1000000; i++){
//            n += i*(i+1)/2;
//        }
        long k ;//= 1000000;
        long g ;//= (k*(k+1)*(2*k+1))/12+(k*(k+1))/4;
//        System.out.println(n);
//        System.out.println(g);

        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        for(int j = 0; j < i; j++){
            k = input.nextLong();
            g = ((k*(k+1)*(2*k+1))+(k*(k+1))*3)/12;
            System.out.println(g);
        }
    }
}
