/*** 
833 Medium
***/
class FindReplaceStrign {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        init(indexes, sources, targets);
        
        boolean[] status = new boolean[indexes.length];
        for (int i = 0; i < sources.length; i++) {
            String cur = sources[i];
            int index = S.indexOf(cur, indexes[i]);
            if (index != -1 && indexes[i] == index) status[i] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < S.length()) {
            if (j < indexes.length && i == indexes[j]) {
                if (status[j]) {
                    sb.append(targets[j]);
                    i += sources[j].length();
                } else {
                    sb.append(S.charAt(i));
                    i++;
                }
                j++;
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
    
    public void init(int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        Arrays.sort(indexes);
        String[] temp1 = new String[sources.length];
        String[] temp2 = new String[targets.length];
        for (int i = 0; i < sources.length; i++) {
            temp1[i] = sources[i];
            temp2[i] = targets[i];
        }
        for (int i = 0; i < indexes.length; i++) {
            int curIndex = map.get(indexes[i]);
            sources[i] = temp1[curIndex];
            targets[i] = temp2[curIndex];
        }
        return;
    }
    
}