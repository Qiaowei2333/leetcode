// lc 249
public class GroupShiftedStrings {
        // time O(len*m) len - strings size, m - avg len of each string
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> res = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            String[] newStrs = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                newStrs[i] = transform(strings[i]);
            }
            
            for (int i = 0; i < newStrs.length; i++) {
                String transedStr = newStrs[i];
                String realStr = strings[i];
                if (!map.containsKey(transedStr)) {
                    res.add(new ArrayList<>());
                    int idx = res.size() - 1;
                    map.put(transedStr, idx);
                }
                int idxInRes = map.get(transedStr);
                res.get(idxInRes).add(realStr);
            }
            return res;
        }
        
        private String transform(String s) {
            char[] charArr = s.toCharArray();
            int diff = charArr[0] - 'a';
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] - diff >= 'a') {
                    charArr[i] = (char) (charArr[i] - diff);
                }
                else {
                    charArr[i] = (char) (charArr[i] - diff + 26);
                }
            }
            return new String(charArr);
        }
}
