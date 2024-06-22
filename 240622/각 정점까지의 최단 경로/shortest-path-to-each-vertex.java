import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int x;
        int edge;
        public Pair(int x,int edge){
            this.x=x;
            this.edge=edge;
        }

        @Override
        public int compareTo(Pair o) {
            return edge-o.edge;
        }
    }

    public static int n;
    public static int m;
    public static int k;
    public static int[] d;
    public static Vector<Vector<Pair>> v=new Vector<>();

    public static void solution(){
        d[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(k,d[k]));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(d[cur.x]!=cur.edge) continue;
            for(Pair next:v.get(cur.x)){
                if(d[next.x]<=d[cur.x]+next.edge) continue;
                d[next.x]=d[cur.x]+ next.edge;
                pq.add(new Pair(next.x,d[next.x]));
            }
        }
        for(int i=1;i<=n;i++){
            if(d[i]==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(d[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        k=scan.nextInt();
        for(int i=0;i<=n;i++){
            v.add(new Vector<>());
        }
        d=new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c= scan.nextInt();
            v.get(a).add(new Pair(b,c));
            v.get(b).add(new Pair(a,c));
        }
        solution();
    }
}