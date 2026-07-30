import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sorting allows early pruning (optimization)
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination found
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early Pruning: Since array is sorted, if current candidate exceeds 
            // the remaining target, further numbers will also exceed it.
            if (remain - candidates[i] < 0) {
                break;
            }

            // Choose candidate
            current.add(candidates[i]);

            // Recurse with index 'i' because we can reuse the same element
            backtrack(candidates, remain - candidates[i], i, current, result);

            // Undo choice (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}