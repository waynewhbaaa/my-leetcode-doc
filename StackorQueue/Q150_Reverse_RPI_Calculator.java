class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String n = String.valueOf(a+b);
                stack.push(n);
            }
            else if(s.equals("-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String n = String.valueOf(b-a);
                stack.push(n);
            }
            else if(s.equals("*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String n = String.valueOf(a*b);
                stack.push(n);
            }
            else if(s.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String n = String.valueOf(b/a);
                stack.push(n);
            }
            else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
