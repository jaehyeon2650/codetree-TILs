import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[] unf;
    public static int find(int x){
        if(unf[x]==x) return x;
        else return unf[x]=find(unf[x]);
    }
    public static void union(int x,int y){
        int a=find(x);
        int b=find(y);
        if(a!=b) unf[a]=b;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        unf=new int[n+1];
        for(int i=1;i<=n;i++){
            unf[i]=i;
        }
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=scan.nextInt();
            if(a==1){
                int check1=find(b);
                int check2=find(c);
                if(check2==check1){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }else{
                union(b,c);
            }
        }
    }
}