/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution364 {
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.offer(nestedList);

        int totalSum = 0;
        int weightedSum = 0;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                List<NestedInteger> currentList = queue.poll();
                for (NestedInteger item : currentList) {
                    if (item.isInteger()) {
                        int value = item.getInteger();
                        totalSum += value;
                        weightedSum += value * depth;
                    } else {
                        queue.offer(item.getList());
                    }
                }
            }
        }

        return totalSum * (depth + 1) - weightedSum;
    }
}
