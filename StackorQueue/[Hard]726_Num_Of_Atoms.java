// Method 1: recursion using map
// O(N2) time and O(n) space
// class Solution {
//     int i = 0;
//     public String countOfAtoms(String formula) {
//         Map<String, Integer> map = counting(formula);
//         StringBuilder ans = new StringBuilder();
//         for(String name: map.keySet()){
//             ans.append(name);
//             int num = map.get(name);
//             if(num > 1) ans.append("" + num);
//         }

//         return ans.toString();
//     }

//     private Map<String, Integer> counting(String str){

//         Map <String, Integer> store = new TreeMap<>();
//         int size = str.length();
//         while(i < size && str.charAt(i) != ')'){
//             if(str.charAt(i) == '('){
//                 i++;
//                 Map<String, Integer> temp = counting(str);
//                 int count = getCount(str);
//                 for(Map.Entry<String, Integer> entry: temp.entrySet()){
//                     store.put(entry.getKey(), store.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
//                 }
//             }
//             else{
//                 String name = getName(str);
//                 store.put(name, store.getOrDefault(name, 0) + getCount(str));
//             }
//         }

//         i++;
//         return store;
//     }

//     // helper function to getName
//     private String getName(String str){
//         String name = "";
//         while(i < str.length() && Character.isLetter(str.charAt(i)) && (name == "" || Character.isLowerCase(str.charAt(i))) ) name += str.charAt(i++);

//         return name;
//     }

//     private int getCount(String str){
//         String num = "";
//         while(i < str.length() && Character.isDigit(str.charAt(i))) num += str.charAt(i++);
//         return num == "" ? 1 : Integer.parseInt(num);
//     }
// }

// method 2: Use stack
class Solution {
    int i = 0;
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap());

        int size = formula.length();
        while(i < size){
            if(formula.charAt(i) == '('){
                stack.push(new TreeMap());
                i++;
            }
            else if(formula.charAt(i) == ')'){
                Map<String, Integer> top = stack.pop();
                i++;
                int num = getCount(formula);
                System.out.println("Num; " + num);
                for(String s: top.keySet()){
                    int val = top.get(s);
                    stack.peek().put(s, stack.peek().getOrDefault(s, 0) + val * num);
                }

            }
            else{
                String name = getName(formula);
                int num = getCount(formula);
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + num);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String name: stack.peek().keySet()){
            ans.append(name);
            int num = stack.peek().get(name);
            if(num > 1) ans.append("" + num);
        }

        return ans.toString();
    }

    private String getName(String str){
        String name = "";
        while(i < str.length() && Character.isLetter(str.charAt(i)) && (name == "" || Character.isLowerCase(str.charAt(i))) ) name += str.charAt(i++);

        return name;
    }

    private int getCount(String str){
        String num = "";
        while(i < str.length() && Character.isDigit(str.charAt(i))) num += str.charAt(i++);
        return num == "" ? 1 : Integer.parseInt(num);
    }

}
