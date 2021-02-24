/***
997 easy
***/

class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[] from = new int[N + 1];
        int[] to = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            int fromPerson = trust[i][0];
            int toPerson = trust[i][1];
            from[fromPerson]++;
            to[toPerson]++;
        }
        
        int judge = -1;
        for (int i = 1; i < to.length; i++) {
            if (to[i] == N - 1) {
                if (from[i] == 0) {
                    if (judge == -1) judge = i;
                    else return -1;
                }
            }
        }
        return judge;
    }
    
    
    
}