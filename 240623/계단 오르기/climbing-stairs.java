import java.util.*;

public class Main {
    public static int n;
    public static int[] stairs=new int[46];
    public static int up(int x){
        if(stairs[x]!=-1) return stairs[x];
        return stairs[x]=up(x-2)+up(x-3);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        Arrays.fill(stairs,-1);
        stairs[0]=0;
        stairs[1]=0;
        stairs[2]=1;
        stairs[3]=1;
        System.out.println(up(n));
    }
}