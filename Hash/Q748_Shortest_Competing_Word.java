class Solution {

    // // 1 prime number for each letter ...
    // private final int [] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
    // public String shortestCompletingWord(String licensePlate, String[] words) {
    //     long charProduct = getCharProduct(licensePlate.toLowerCase());
    //     String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
    //     for(String word : words)
    //         if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
    //             shortest = word;
    //     return shortest;
    // }
    // private long getCharProduct(String plate) {
    //     long product = 1L;
    //     for(char c : plate.toCharArray()) {
    //         int index = c - 'a';
    //         if (0 <= index && index <= 25)
    //             product *= primes[index];
    //     }
    //     return product;
    // }

    // traditional method use hashtables/array...
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //Store count of letters in LicensePlate
        int[] licensePlateCount = new int[26];

        //To store all words which meet the criteria
        ArrayList<String> res = new ArrayList<>();
        //To find min length word that meets the criteria
        int min = Integer.MAX_VALUE;

        //Add char count for each char in LicensePlate
        for(Character c:licensePlate.toCharArray()) {
            if(Character.isLetter(c)) {
                licensePlateCount[Character.toLowerCase(c) - 'a']++;
            }
        }

        //Add char count for each word in words
        for(String word : words) {
            int[] wordCharCount = new int[26];
            boolean flag = true;

            for(Character c:word.toCharArray()) {
                wordCharCount[Character.toLowerCase(c) - 'a']++;
            }

            //Eliminate words that don't satisfy the criteria
            for(int i = 0; i<26;i++) {
                if(licensePlateCount[i] > wordCharCount[i]) flag = false;
            }

            //Add words satisfying criteria to res and calculate min word length
            if(flag) {
                res.add(word);
                if(word.length() < min) min = word.length();
            }
        }

        //Return 1st word in array meeting all criteria
        for(int i = 0; i < res.size();i++) {
            if(res.get(i).length() == min) return res.get(i);
        }

        //If not found, return -1 (or whatever interviewer expects)
        return "-1";
    }
}
