import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        public int x;
        public int weight;
        public Pair(int x,int weight){
            this.x=x;
            this.weight=weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight-o.weight;
        }
    }
    public static int n;
    public static int[] d;
    public static int start;
    public static int[] visited;
    public static Vector<Vector<Pair>> v=new Vector<>();
    public static void solution(){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(start,d[start]));
        int total=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(visited[cur.x]!=1){
                visited[cur.x]=1;
                total+=cur.weight;
                for(Pair next:v.get(cur.x)){
                    if(d[next.x]<next.weight) continue;
                    d[next.x]=next.weight;
                    pq.add(new Pair(next.x, d[next.x]));
                }
            }
        }
        System.out.println(total);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        d=new int[n+1];
        visited=new int[n+1];
        for(int i=0;i<=n;i++){
            v.add(new Vector<>());
        }
        int maxn=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            d[i]=scan.nextInt();
            if(maxn>d[i]){
                maxn=d[i];
                start=i;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int a=scan.nextInt();
                if(a==0) continue;
                v.get(i).add(new Pair(j,a));
            }
        }
        solution();
    }
}