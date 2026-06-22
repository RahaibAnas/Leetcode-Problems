class Solution {
    public int searchInsert(int[] arr, int tar) {
        int start = 0;
        int end = arr.length - 1;
         while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == tar){
                    return mid;
                } 
                else if (arr[mid] < tar)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

           return start;
    }
}