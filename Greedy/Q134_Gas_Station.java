class Solution {

    // Method 1: Globally Simulation (Not greedy)
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int gSum = 0;
//         int cSum = 0;

//         int restGas = Integer.MAX_VALUE;
//         int curSum = 0;
//         for(int i = 0; i < gas.length; i++){
//             gSum += gas[i];
//             cSum += cost[i];

//             curSum = gSum - cSum;

//             restGas = Math.min(restGas, curSum);
//         }

//         // situation 1: If the gas in total can not fill up the required cost then no solution
//         if(gSum < cSum) return -1;
//         // situation 2: If the gas in total can be filled up from the beginning, return 0
//         if(restGas >= 0) return 0;

//         //situation 3: If the value has negative, find the minimum
//         for(int i = gas.length - 1; i >= 0; i--){
//             restGas += gas[i] - cost[i];
//             if(restGas >= 0) return i;
//         }

//         return -1;
//     }

    // Method 2: Greedy
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int restGas = 0;
            int start = 0;

            for(int i = 0; i < gas.length; i++){
                sum += gas[i] - cost[i];
                restGas += gas[i] - cost[i];

                if(restGas < 0) { start = i + 1; restGas = 0;}
            }

            if(sum < 0) return -1;
            return start;
        }
}
