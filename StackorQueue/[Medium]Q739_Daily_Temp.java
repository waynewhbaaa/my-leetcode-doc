class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> stack = new Stack<>();
        int [] ans = new int[temperatures.length];
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i] < temperatures[stack.peek()]){
                stack.push(i);
            }
            else if(temperatures[i] == temperatures[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return ans;
    }

}
