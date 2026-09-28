class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> groups = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
           int[] charFreq = new int[26];
           for(int j = 0; j < strs[i].length(); j++) {
            charFreq[strs[i].charAt(j) - 'a']++;
           }

           List<Integer> freq = Arrays.stream(charFreq).boxed().toList();

           if(groups.containsKey(freq)) {
            groups.get(freq).add(strs[i]);
           }else {
            groups.put(freq, new ArrayList<>(List.of(strs[i])));
           }
        }

        List<List<String>> res = new ArrayList<>(groups.values());
        return res;
    }
}
