class Solution {
    public int leastInterval(char[] tasks, int n) {

       int[] count = new int[26];

        //Count the frequency of each task
       for(char t : tasks)
       {
        count[t - 'A']++;
       }
       
       //Max Heap
       PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
       //Store the count in max heap with most frequent task at top 
       for(int c : count)
       {
            if(c > 0)
                pq.add(c);
       }

       Queue<int[]> q = new LinkedList<>();
       int time = 0;

       while(!pq.isEmpty() || !q.isEmpty())
       {
            time++;
            if(!pq.isEmpty())
            {
                int taskCount = pq.poll() - 1;
                if(taskCount != 0)
                {
                    q.add(new int[]{taskCount,time + n});
                }
            }

            if(!q.isEmpty())
            {
                int[] qTop = q.peek();
                if(qTop[1] == time)
                {
                    q.remove();
                    pq.add(qTop[0]);
                }
            }
       }

       return time;
        
    }
}
