class Solution {
    public String frequencySort(String s) {
        // best approach counting sort
        int [] list = new int[128];
        char[] arr = s.toCharArray();

        for(char c: arr){
            list[c]++;
            // System.out.println("C: " + c + " freq: " + list[c]);
        }

        Character[] sorted = new Character[arr.length];
        for(int i = 0; i < arr.length; i++){
            sorted[i] = new Character(arr[i]);
        }

        Arrays.sort(sorted, new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                if(list[c1] == list[c2]) return c2 - c1;
                return list[c2] - list[c1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Character c: sorted) sb.append(c.charValue());


        return sb.toString();
    }
}
