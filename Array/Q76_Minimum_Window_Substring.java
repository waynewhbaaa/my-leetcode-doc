// class Solution {
//     public String minWindow(String s, String t) {
//         if(s.length() < t.length()) return "";
//         String str = new String(t);
//         if(s.equals(t)) return s;
//
//         // sliding window approach
//         int minLength = Integer.MAX_VALUE;
//         int finI = 0, finJ = 0;
//         HashMap<Character, Integer> count = new HashMap<>();
//
//         for(int x = 0; x < t.length(); x++){
//             count.put(t.charAt(x), count.getOrDefault(t.charAt(x), 0) + 1);
//         }
//
//
//         int i = 0;
//         for(int j = 0; j < s.length(); j++){
//             // case: when current char could be referenced in the target str
//             if(str.indexOf(s.charAt(j)) != -1) str = str.replaceFirst(String.valueOf(s.charAt(j)), "");
//
//             // case: repetitive char founded. used to skip the overlapped early occurence of characters
//             if(t.indexOf(s.charAt(j)) != -1) count.put(s.charAt(j), count.get(s.charAt(j)) - 1);
//
//             while(str.length() == 0){
//                 int length = j - i + 1;
//                 if(minLength >= length) {minLength = length; finI = i; finJ = j;}
//                 char c = s.charAt(i++);
//                 if(count.containsKey(c)){
//                     if(count.get(c) >= 0) str += c;
//                     count.put(c, count.get(c) + 1);
//                 }
//             }
//         }
//
//         return minLength == Integer.MAX_VALUE ? "" : s.substring(finI, finJ + 1);
//     }
// }

//faster version: Replace all the string search/replace with int calc for faster performance

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        String str = new String(t);
        if(s.equals(t)) return s;

        // sliding window approach
        int minLength = Integer.MAX_VALUE;
        int finI = 0, finJ = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for(int x = 0; x < t.length(); x++){
            count.put(t.charAt(x), count.getOrDefault(t.charAt(x), 0) + 1);
        }


        int i = 0;
        int matched = t.length();
        for(int j = 0; j < s.length(); j++){
            // case: when current char could be referenced in the target str

            // case: repetitive char founded. used to skip the overlapped early occurence of characters
            if(t.indexOf(s.charAt(j)) != -1) {
                count.put(s.charAt(j), count.get(s.charAt(j)) - 1);
                if(count.get(s.charAt(j)) >= 0) matched--;
            }

            while(matched == 0){
                int length = j - i + 1;
                if(minLength >= length) {minLength = length; finI = i; finJ = j;}
                char c = s.charAt(i++);
                if(count.containsKey(c)){
                    if(count.get(c) == 0) matched++;
                    count.put(c, count.get(c) + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(finI, finJ + 1);
    }
}
