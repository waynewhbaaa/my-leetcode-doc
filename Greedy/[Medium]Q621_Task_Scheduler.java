class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] list = new int[26];

        for(char c: tasks){
            list[c - 'A']++;
        }


        // greedy, starts using the most count first.
        int max=list[0];
        int count=0;

        // find the max count of the letter
        for(int i=0;i<26;i++)
        {
            if(max<list[i])
            {
                max=list[i];
            }
        }

        // count the number of max number
        for(int i=0;i<26;i++)
        {
            if(max==list[i])
            {
                count++;
            }
        }

        return Math.max(tasks.length, (max-1)*(n+1)+count);
    }
}
