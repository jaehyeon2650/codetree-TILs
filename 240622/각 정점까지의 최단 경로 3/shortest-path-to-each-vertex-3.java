import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        public int y;
        public int edge;
        public Pair(int y,int edge){
            this.y=y;
            this.edge=edge;
        }

        @Override
        public int compareTo(Pair o) {
            return edge-o.edge;
        }
    }
    public static int n;
    public static int m;
    public static Vector<Vector<Pair>> v=new Vector<>();
    public static int[] d;

    public static void solution(){
        d[1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(d[cur.y]!=cur.edge) continue;
            for(Pair next:v.get(cur.y)){
                if(d[next.y]<=d[cur.y]+next.edge) continue;
                d[next.y]=d[cur.y]+next.edge;
                pq.add(new Pair(next.y,d[next.y]));
            }
        }
        for(int i=2;i<=n;i++){
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
        for(int i=0;i<=n;i++){
            v.add(new Vector<>());
        }
        d=new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=scan.nextInt();
            v.get(a).add(new Pair(b,c));
        }
        solution();
    }
}