//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class NodeDist {
    int node ;
    int dist;
    
    NodeDist(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
    
    
    

    
    
}

class Solution
{
    
    static void mark_nei_dist(int src, PriorityQueue<NodeDist> pq, int[ ] ans , ArrayList<ArrayList<ArrayList<Integer>>> adj){
        
        for (ArrayList<Integer> node_dist :  adj.get(src) ){
                    
            int nei=node_dist.get(0);
            int nei_dist=node_dist.get(1);
            
            if (ans[src]+ nei_dist< ans[nei]){
                ans[nei]=ans[src]+ nei_dist;
                
                pq.add(new NodeDist(nei, ans[nei]));
                
                
            }
            
            
                    
        }
        
    }
    
    
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        
        
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        PriorityQueue<NodeDist> pq= new PriorityQueue<>((n1,n2)-> n1.dist-n2.dist);
        
        pq.add(new NodeDist(S,0));
        ans[S]=0;
        
        while (!pq.isEmpty()){
            NodeDist min_node= pq.poll();
            
            int src= min_node.node;
            
            if(vis[src]==true){
                continue;
            }
            
            vis[src]=true;
            
            
            
            mark_nei_dist(src, pq, ans, adj);
            
        }
        
        return ans ;
    }
}

