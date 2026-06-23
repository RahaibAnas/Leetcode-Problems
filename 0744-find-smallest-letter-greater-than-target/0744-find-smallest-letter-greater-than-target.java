class Solution {
    public char nextGreatestLetter(char[] arr, char tar) {
        int start = 0;
        int end = arr.length - 1;
        int t = tar;
         while (start <= end) {
            int mid = start + (end - start)/2;
            int element = arr[mid];
            if (element <= t)
                start = mid +1;
            else
                end = mid - 1;

         }

         if (start != arr.length)
            return arr[start];
        else
            return arr[0];
    }
}