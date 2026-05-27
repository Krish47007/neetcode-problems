class Solution:
    
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        #Create adjacecny list
        adj = [ [] for _ in range(n)]

        #Build the adjacnecy list
        for a,b in edges:
            adj[a].append(b)
            adj[b].append(a)
        #Create visited array
        vis = [0] * n
        count = 0

        def dfs(curr):
            #Mark the current node as visited
            vis[curr] = 1
            #Traverse the adacent nodes
            for conn in adj[curr]:
                if vis[conn] == 0:
                    dfs(conn)
        
        for i in range(n):
            if vis[i] == 0:
                count += 1
                dfs(i)

        return count
