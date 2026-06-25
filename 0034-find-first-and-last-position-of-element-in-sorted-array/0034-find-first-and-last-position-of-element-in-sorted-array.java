class Solution {
    public int[] searchRange(int[] arr, int tar) {
        int[] result = { -1, -1 };
        result[0] = firstnum(arr, tar);
        result[1] = lastnum(arr, tar);

        return result;
    }
    static int firstnum(int[] arr, int tar) {
        if (arr.length == 0) {
            return -1;
        }

        int result = -1;
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = arr[mid];
            if (element == tar) {
                result = mid;
                if (mid - 1 < 0) {
                    break;
                }
                end = mid - 1;
            } else if (element <= tar) {
                if (mid + 1 > arr.length - 1) {
                    break;
                }
                start = mid + 1;
            } else {
                if (mid - 1 < 0) {
                    break;
                }
                end = mid - 1;
            }
        }

        return result;
    }

    static int lastnum(int[] arr, int tar) {
        if (arr.length == 0) {
            return -1;
        }

        int result = -1;
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = arr[mid];
            if (element == tar) {
                result = mid;
                if (mid + 1 > arr.length - 1) {
                    break;
                }
                start = mid + 1;
            } else if (element <= tar) {
                if (mid + 1 > arr.length - 1) {
                    break;
                }
                start = mid + 1;
            } else {
                if (mid - 1 < 0) {
                    break;
                }
                end = mid - 1;
            }
        }

        return result;
    }
}