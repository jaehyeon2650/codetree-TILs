import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        public int v1;
        public int v2;
        public int weight;
        public Edge(int v1,int v2,int weight){
            this.v1=v1;
            this.v2=v2;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight-o.weight;
        }
    }

    public static int n;
    public static int m;
    public static int[] unf;
    public static ArrayList<Edge> edges=new ArrayList<>();

    public static int find(int x){
        if(unf[x]==x) return x;
        else return unf[x]=find(unf[x]);
    }
    public static void union(int x,int y){
        int a=find(x);
        int b=find(y);
        if(a!=b) unf[a]=b;
    }
    public static void solution(){
        int total=0;
        for(Edge e:edges){
            if(find(e.v1)!=find(e.v2)){
                total+=e.weight;
                union(e.v1,e.v2);
            }
        }
        System.out.println(total);
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
            edges.add(new Edge(a,b,c));
        }
        Collections.sort(edges);
        solution();
    }
}