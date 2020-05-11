//lin 135
import java.util.*;
public class CoinChangeCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        recursionHelper(result, list, target, candidates, 0);
        return result;
    }

    private void recursionHelper(List<List<Integer>> result, List<Integer> list, int remainTarget, int[] candidates, int pos) {
        if (remainTarget == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (remainTarget < candidates[i]) {
                break;
            }
            // if candididates[] not includes any duplicate integers, comment out code below
            // if (i != pos && candidates[i] == candidates[i - 1 ]) {
            //     continue;
            // }
            list.add(candidates[i]);
            recursionHelper(result, list, remainTarget - candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }
    }       

    public static void main(String[] args) {
        CoinChangeCombinationSum s = new CoinChangeCombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = s.combinationSum(candidates, 7);
        System.out.println(result);
    }
}