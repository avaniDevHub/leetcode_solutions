import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: full permutation formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Make a copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Make decision
            used[i] = true;
            current.add(nums[i]);

            // Recurse
            backtrack(nums, current, used, result);

            // Undo decision (Backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}