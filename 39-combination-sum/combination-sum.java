import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    //set to keep track of all unique combinations
    private Set<List<Integer>> s= new HashSet<>();

//helper method
    private void getAllCombinations(int[] arr, int idx, int target,List<List<Integer>> ans, List<Integer> combn)
    {
        //base case 
        if(idx == arr.length || target<0)
        {
            return;
        }

        if(target == 0)
        {
            // Push combination to ans only if it's unique
            if(!s.contains(combn))
            {
                ans.add(new ArrayList<>(combn));
                s.add(new ArrayList<>(combn));
            }
            return;
        }

        //single inclusion choice
        combn.add(arr[idx]);
        getAllCombinations(arr, idx+1, target-arr[idx],ans, combn);

        // --- Multiple Inclusion Choice ---
        getAllCombinations(arr, idx, target - arr[idx], ans, combn);

        // --- Backtracking Step ---
        combn.remove(combn.size() - 1);

        // --- Exclusion Choice ---
        getAllCombinations(arr, idx + 1, target, ans, combn);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combn = new ArrayList<>();

        getAllCombinations(candidates, 0, target, ans, combn);

        return ans;
    }
}