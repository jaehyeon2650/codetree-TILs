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
    public static int[] d;
    public static Vector<Vector<Pair>> v=new Vector<>();

    public static void solution(){
        d[n]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(n,d[n]));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(d[cur.x]!=cur.edge) continue;
            for(Pair next:v.get(cur.x)){
                if(d[next.x]<=d[cur.x]+next.edge) continue;
                d[next.x]=d[cur.x]+ next.edge;
                pq.add(new Pair(next.x,d[next.x]));
            }
        }
        int manx=0;
        for(int i=1;i<n;i++){
            manx=Math.max(d[i],manx);
        }
        System.out.println(manx);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        for(int i=0;i<=n;i++){
            v.add(new Vector<>());
        }
        d=new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c= scan.nextInt();
            v.get(b).add(new Pair(a,c));
        }
        solution();
    }
}