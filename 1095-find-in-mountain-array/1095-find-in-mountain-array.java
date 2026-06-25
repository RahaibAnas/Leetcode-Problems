/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int tar, MountainArray mountainArr) {

        int peak = peakIndexInMountainArray(mountainArr);

        int firstSearch = binarySearch(mountainArr, tar, 0, peak);

        if (firstSearch != -1) {
            return firstSearch;
        }

        return binarySearch(
                mountainArr,
                tar,
                peak + 1,
                mountainArr.length() - 1
        );
    }

    static int peakIndexInMountainArray(MountainArray arr) {

        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int binarySearch(MountainArray arr, int tar, int s, int e) {

        int start = s;
        int end = e;

        // Ascending order
        if (arr.get(start) < arr.get(end)) {

            while (start <= end) {

                int mid = start + (end - start) / 2;

                if (arr.get(mid) == tar) {
                    return mid;
                } else if (arr.get(mid) < tar) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        // Descending order
        else {

            while (start <= end) {

                int mid = start + (end - start) / 2;

                if (arr.get(mid) == tar) {
                    return mid;
                } else if (arr.get(mid) < tar) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}