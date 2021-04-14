class Solution {
//    public void removeExtraSpace(StringBuilder a){

//         int i = 0;

//         for(i = 0; i < a.length();){
//             //remove the staring spaces
//             if(i == 0 & a.charAt(i) == ' '){
//                 a.deleteCharAt(i);
//             }
//             //remove multiple space in the string
//             else if(i - 1 > 0 && a.charAt(i) == a.charAt(i - 1) && a.charAt(i) == ' '){
//                 a.deleteCharAt(i);
//             }
//             else {
//                 i++;
//                 continue;
//             }
//         }

//         //remove extra end space (only remove 1 since multiple has been cut down one)
//         if(i - 1 > 0 && a.charAt(i - 1) == ' '){
//             a.deleteCharAt(i - 1);
//         }

//     }

//     public void reverseString(StringBuilder s, int start, int end){
//         int i = start, j = end;
//         while(i < j){
//             char a = s.charAt(i);
//             s.setCharAt(i, s.charAt(j));
//             s.setCharAt(j, a);
//             i++;
//             j--;
//         }
//     }

     public String reverseWords(String s) {

//         StringBuilder str = new StringBuilder(s);
//         // remove the extra space
//         removeExtraSpace(str);

//         // reverse the string
//         reverseString(str, 0, str.length() - 1);

//         int start= 0, end = 0;
//         // reverse the every single word
//         for(int i = 0; i < str.length(); i++){
//             //find start of the word
//             if(i > 0 && str.charAt(i) != ' ' && str.charAt(i-1) == ' '){
//                 start = i;
//             }

//             // find the end of a word in the middle
//             if(i > 0 && str.charAt(i-1) != ' ' && str.charAt(i) == ' '){
//                 end = i - 1;
//                 reverseString(str, start, end);
//             }

//             //last word at end of the string
//             if(i == str.length() - 1 && str.charAt(i)  != ' '){
//                 end = i;
//                 reverseString(str, start, end);
//             }
//         }

//         return str.toString();
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

}
