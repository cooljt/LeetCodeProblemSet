/***
673 Medium
***/

class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int numOfLongest = 1;
        int longestLen = 1;
        int[] dpLen = new int[nums.length];
        int[] dpCount = new int[nums.length];
        dpLen[0] = 1;
        dpCount[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int tempCount = 1;
            int tempMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dpLen[j] + 1 > tempMax) {
                        tempMax = dpLen[j] + 1;
                        tempCount = dpCount[j];
                    } else if (dpLen[j] + 1 == tempMax) {
                        tempCount += dpCount[j];
                    }
                }
            }
            dpCount[i] = tempCount;
            dpLen[i] = tempMax;
            if (dpLen[i] > longestLen) {
                longestLen = dpLen[i];
                numOfLongest = dpCount[i];
            } else if (dpLen[i] == longestLen) {
                numOfLongest += dpCount[i];
            }
            
        }
        
        return numOfLongest;
    }
}