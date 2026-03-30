class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        for(char ch : tasks)
        {
            count[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int c : count)
        {
            if(c > 0)
                pq.add(c);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty())
        {
            time++; //cpu cycle
            if(!pq.isEmpty())
            {
                int curr = pq.poll();
                curr--;
                if(curr > 0)
                    q.add(new int[]{curr,time+n});
            }
            if(!q.isEmpty())
            {
                int[] topQ = q.peek();
                if(topQ[1] == time)
                {
                    q.poll();
                    pq.add(topQ[0]);
                }
            }
        }

        return time;
    }
}
