import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        // Edge case: if k is the total length
        if (k == arr.length) {
            for (int ele : arr) {
                res.add(ele);
            }
            return res; // Fixed: return early
        }

        // Step 1: Binary Search to find insertion point of x
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Fixed: used '+' instead of '-'
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // At this point, 'right' points to the first element >= x
        // Set left to right - 1 so (left, right) forms a window around x
        left = right - 1;

        // Step 2: Expand outwards to pick k elements
        while (k > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                // Tie-breaker: preferred smaller element on left
                left--;
            } else {
                right++;
            }
            k--;
        }

        // Step 3: Collect elements strictly between (left, right)
        for (int j = left + 1; j < right; j++) {
            res.add(arr[j]);
        }

        return res;
    }
}