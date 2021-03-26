class Solution {
    public int balancedString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int len = s.length();
        int avg = len / 4;
        int Count = 0;

        Map<Character, Integer> extraMap = new HashMap<>();
        for (char ch : freq.keySet()) {
            extraMap.put(ch, 0);
            int sub = freq.get(ch) - avg;
            if (sub > 0) {
                Count += sub;
                extraMap.put(ch, sub);
            }
        }

        if (Count == 0) return 0;
        int res = len;
        int left = 0, right = 0;
        while (right < len) {
            char rCh = s.charAt(right);
            if (extraMap.get(rCh) > 0) {
                Count--;
            }
            extraMap.put(rCh, extraMap.get(rCh) - 1);
            right++;
            while (Count == 0) {
                res = Math.min(res, right - left);
                char lCh = s.charAt(left);
                if (extraMap.get(lCh) >= 0) {
                    Count++;
                }
                extraMap.put(lCh, extraMap.get(lCh) + 1);
                left++;
            }
        }
        return res;
    }
}
