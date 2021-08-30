class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        for(char c : expression.toCharArray()){
            i++;
            // that should be an operator
            if(!Character.isDigit(c)){

                char op = c;

                String left =  expression.substring(0, i-1);
                String right = expression.substring(i);

                // System.out.println("left : " + left + " right: " + right);
                List<Integer> sumLeft = diffWaysToCompute(left);
                List<Integer> sumRight = diffWaysToCompute(right);

                for(int l : sumLeft){
                    for(int r : sumRight){
                        if(op == '+')
                            ans.add(l + r);
                        else if(op == '-')
                            ans.add(l - r);
                        else
                            ans.add(l * r);
                    }
                }
            }
        }

        if(ans.size() == 0) {
            // single number
            ans.add(Integer.parseInt(expression));
            return ans;
        }

        return ans;
    }
}
