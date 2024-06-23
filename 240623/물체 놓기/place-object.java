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
    public static int[] visited;
    public static Vector<Vector<Pair>> v=new Vector<>();
    public static void solution(){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        d[0]=0;
        pq.add(new Pair(0,d[0]));
        int total=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(visited[cur.x]!=1){
                visited[cur.x]=1;
                total+=cur.weight;
                for(Pair next:v.get(cur.x)){
                    if(d[next.x]<=next.weight) continue;
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
        Arrays.fill(d,Integer.MAX_VALUE);
        visited=new int[n+1];
        for(int i=0;i<=n;i++){
            v.add(new Vector<>());
        }
        for(int i=1;i<=n;i++){
            int a=scan.nextInt();
            v.get(0).add(new Pair(i,a));
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