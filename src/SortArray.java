/***

912 Medium, I used quicksort

***/


class SortArray {
    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        quickSort(start, end, nums);
        return nums;
    }
    
    public void quickSort(int start, int end, int[] nums) {
        if (start >= end) {return;}
        int index = findPivot(start, end, nums);
        quickSort(start, index - 1, nums);
        quickSort(index + 1, end, nums);
    }
    
    public int findPivot(int start, int end, int[] nums) {
        int pivot = nums[start];
        
        int left = start + 1;
        int right = end;
        
        while (left <= right) {
            if (nums[left] > pivot) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        
        nums[start] = nums[right];
        nums[right] = pivot;
        return right;
    }
    
}