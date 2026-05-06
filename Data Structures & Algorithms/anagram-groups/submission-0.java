class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> result = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            if (!result.containsKey(freqMap)) {
                result.put(freqMap, new ArrayList<>());
            }
            result.get(freqMap).add(s);
        }
        List<List<String>> output = new ArrayList<>();
        for (Map<Character, Integer> freq : result.keySet()) {
            output.add(result.get(freq));
        }
        return output;
    }
}
