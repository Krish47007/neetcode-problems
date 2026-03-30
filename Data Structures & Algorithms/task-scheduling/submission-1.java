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
       
       //Queue stores the taskCount and time when it will be available
       Queue<int[]> q = new LinkedList<>();
       int time = 0;

       while(!pq.isEmpty() || !q.isEmpty())
       {
           // Consume CPU time
            time++;
            //PQ has some element
            if(!pq.isEmpty())
            {
                //REduce count as we cosumed it in this cycle
                int taskCount = pq.poll() - 1;
                //If still needs processing
                if(taskCount != 0)
                {
                    //Add task and when it will be available
                    q.add(new int[]{taskCount,time + n});
                }
            }

            if(!q.isEmpty())
            {
                //If any task that is available in current time
                //Add it back to heap
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
