

class Solution:
    # Function to construct and return cost of MST for a graph
    # represented using adjacency matrix representation
    '''
    V: nodes in graph
    edges: adjacency list for the graph
    S: Source
    '''
    
    def chk_neg_cycle(self, edges, dist):
        for edge in edges:
            src=edge[0]
            dest= edge[1]
            wt=edge[2]
            
            if dist[src]!=sys.maxsize and dist[src]+wt < dist[dest]:
                return True
        
        return False


    
    def bellman_ford(self, V, edges, S):
        #code here
        dist=[int(1e8) for i in range(V)] # 1e8 == 10^8
        dist[S]=0
        
        
        for i in range(V-1):
            for edge in edges:
                src=edge[0]
                dest= edge[1]
                wt=edge[2]
                
                if dist[src]!=sys.maxsize and dist[src]+wt < dist[dest]:
                    dist[dest]=dist[src]+wt
                
        
        if self.chk_neg_cycle(edges, dist):
            return [-1]
        else :
            return dist
            
        

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        V,E = map(int,input().strip().split())
        edges = []
        for i in range(E):
            u,v,w = map(int,input().strip().split())
            edges.append([u,v,w])
        S=int(input())
        ob = Solution()
        
        res = ob.bellman_ford(V,edges,S)
        for i in res:
            print(i,end=" ")
        print()
# } Driver Code Ends
