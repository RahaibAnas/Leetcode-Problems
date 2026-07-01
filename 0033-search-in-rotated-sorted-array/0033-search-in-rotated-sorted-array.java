class Solution {
    public int search(int[] arr, int tar) {
        if(arr.length == 1 && arr[0] == tar){
            return 0;
        }

        if(arr.length == 1 && arr[0] != tar){
            return -1;
        }

        int peak = findPeak(arr);
        int firstSearch = binarySearch(arr, tar,0,peak);

        if (firstSearch == -1){
            return binarySearch(arr, tar,peak+1,arr.length -1);
        }

        return firstSearch;
    }

    static int binarySearch(int[] arr, int tar, int s, int e) {
        int start = s;
        int end = e;
        if ( end > start && arr[start] < arr[end]) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == tar)
                    return mid;
                else if (arr[mid] < tar)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            return -1;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == tar)
                    return mid;
                else if (arr[mid] < tar) // {10,9',8,7,"6",5,4,3,2,1}
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            return -1;
        }

    }

    static int findPeak(int[] arr){
        int start =0;
        int end  = arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid +1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid -1]){
                return mid -1;
            }else if(arr[mid] <= arr[start] ){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }


        return -1;
    }
}