/***
911 Medium
***/
class TopVotedCandidate {
    Map<Integer, Integer> timeToVote;
    Map<Integer, Integer> candidateToVote;
    int[] timeForVote;
    int mostVoteCandidate;
    public TopVotedCandidate(int[] persons, int[] times) {
        timeForVote = times;
        timeToVote = new HashMap<>();
        candidateToVote = new HashMap<>();
        mostVoteCandidate = -1;
        
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            int who = persons[i];
            
            candidateToVote.put(who, candidateToVote.getOrDefault(who, 0) + 1);
            int votesForWho = candidateToVote.get(who);
            
            if (mostVoteCandidate == -1) mostVoteCandidate = who;
            else {
                int curMost = candidateToVote.get(mostVoteCandidate);
                if (curMost <= votesForWho) {
                    mostVoteCandidate = who;
                }
            }
            timeToVote.put(time, mostVoteCandidate);
        }
    }
    
    public int q(int t) {
        int time = binarySearch(t);
        return timeToVote.get(time);
    }
    
    public int binarySearch(int time) {
        int start = 0;
        int end = timeForVote.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (timeForVote[mid] > time) end = mid;
            else start = mid;
        }
        if (timeForVote[end] <= time) return timeForVote[end];
        return timeForVote[start];
        
    }
    
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */