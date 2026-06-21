class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = [ [] for _ in range(n)]

        for a,b in edges:
            adj[a].append(b)
            adj[b].append(a)
        
        vis = [False] * n
        count = 0

        def dfs(curr):
            vis[curr] = True

            for conn in adj[curr]:
                if not vis[conn]:
                    dfs(conn)

        for i in range(n):
            if not vis[i]:
                count += 1
                dfs(i)
        
        return count
