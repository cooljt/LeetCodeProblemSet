/***
1365 Easy, use BucketSort to get O(n)
***/

class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNum = new int[nums.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) sortedNum[i] = nums[i];
        Arrays.sort(sortedNum);
        for (int i = 0; i < sortedNum.length; i++) {
            if (!index.containsKey(sortedNum[i])) index.put(sortedNum[i], i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) result[i] = index.get(nums[i]);
        return result;
    }
}