import java.util.*;

public class Main {
    public static int n;
    public static int[] fibo=new int[46];
    public static int fiboSolution(int x){
        if(fibo[x]!=-1) return fibo[x];
        return fibo[x]=fiboSolution(x-1)+fiboSolution(x-2);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        Arrays.fill(fibo,-1);
        fibo[1]=1;
        fibo[2]=1;
        System.out.println(fiboSolution(n));
    }
}