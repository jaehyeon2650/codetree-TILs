import java.util.*;

public class Main {
    public static int n;
    public static int[] stairs=new int[1001];
    public static int up(int x){
        if(stairs[x]!=-1) return stairs[x];
        return stairs[x]=(up(x-1)+up(x-2))%10007;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        Arrays.fill(stairs,-1);
        stairs[0]=0;
        stairs[1]=1;
        stairs[2]=2;
        stairs[3]=3;
        System.out.println(up(n));
    }
}