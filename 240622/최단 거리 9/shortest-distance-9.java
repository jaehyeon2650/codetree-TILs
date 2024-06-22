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
    public static int[] come;
    public static int xx;
    public static int yy;
    public static Vector<Vector<Pair>> v=new Vector<>();

    public static void solution(){
        d[xx]=0;
        come[xx]=-1;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(xx,d[xx]));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(d[cur.x]!=cur.edge) continue;
            for(Pair next:v.get(cur.x)){
                if(d[next.x]<=d[cur.x]+next.edge) continue;
                d[next.x]=d[cur.x]+ next.edge;
                come[next.x]=cur.x;
                pq.add(new Pair(next.x,d[next.x]));
            }
        }
        System.out.println(d[yy]);
        int cur=come[yy];
        Stack<Integer> st=new Stack<>();
        st.push(yy);
        while(cur!=xx){
            st.push(cur);
            cur=come[cur];
        }
        st.push(xx);
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
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
        come=new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        Arrays.fill(come,0);
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c= scan.nextInt();
            v.get(a).add(new Pair(b,c));
        }
        xx=scan.nextInt();
        yy=scan.nextInt();
        solution();
    }
}