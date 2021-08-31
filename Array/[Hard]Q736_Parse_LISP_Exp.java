class Solution {
    HashMap<String, Stack<Integer>> stack = new HashMap<>();
    int i = 0;

    public int evaluate(String expression) {
        String[] list = parse(expression);
        return eval(expression, stack, list, i);
    }

    public int eval(String expression, HashMap<String, Stack<Integer>> stack, String[] list, int i){

        if(Character.isDigit(expression.charAt(0))) return Integer.valueOf(expression);

        if(notKeyWord(expression) && Character.isLowerCase(expression.charAt(0))) return stack.get(expression).pop();

        // we need a parser then compiler?

        int ans = 0;
        // add
        if(list[i].equals("add")){
            System.out.println("add " + i + "list: " + list[i+2]);
            ans = eval(list[i+1], stack, list, ++i) + eval(list[i+1], stack, list, ++i);
            return ans;
        }
        // mul
        else if(list[i].equals("mult")){
            System.out.println("mult" + i + "list2 : " + list[i+2]);
            ans = eval(list[i+1], stack, list, ++i) * eval(list[i+1], stack, list, ++i);
        }
        // let
        else{
            i++;
            int old_i = i;
            while(i < list.length){
                System.out.println("list[i] : " + list[i] + " i : " + i);

                if(i == list.length - 1) {
                    // could not fetched furthur. Return the value then
                    ans = eval(list[i], stack, list, i);
                    return ans;
                }

                String var = list[i++];
                System.out.println("Var : " + var + " before " + i);
                if(!notKeyWord(var)){
                    System.out.println("more function? at " + i);
                    ans += eval(expression, stack, list, i);
                }

                Integer val;
                if(notKeyWord(list[i]))
                    val = Integer.parseInt(list[i++]);
                else{
                    System.out.println("i before add in let? " + i);
                    val = eval(expression, stack, list, i);
                    System.out.println("i after add in let? " + i);
                }

                System.out.println("variable" + var + " val" + val);
                Stack <Integer> s = stack.getOrDefault(var, new Stack<>());
                s.push(val);
                stack.put(var, s);
                System.out.println("Final i:" + i);
            }

            ans += eval(expression, stack, list, i);
            System.out.print("Ans: " + ans);
        }
        return ans;

    }

    private boolean notKeyWord(String exp){
        if(exp.equals("add") || exp.equals("mult") || exp.equals("let")) return false;
        return true;
    }

    public String[] parse(String expression){
        // cut first and last element
        String exp = expression.substring(1, expression.length() - 1);

        String [] list = exp.split(" ");
        for(int i = 0; i < list.length; i++){
            String str = list[i];
            str = str.replaceAll("[()]", "");
            list[i] = str;
        }

        return list;
    }
}
