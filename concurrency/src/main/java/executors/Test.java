//package executors;
//
//public class Test {
//}
//    /**
//     Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed level
//
//
//     Example A: {{1,1},2,{1,1}}
//
//
//     () 2 () -> weight = 2
//     / \ /\
//     1 1 1 1 -> weight = 1
//
//     2 * 2 + (1*1 + 1*1 + 1*1+ 1*1) = 8
//
//     * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
//
//     Example B: {{{6},4},1}
//     (), 1 -> weight = 3
//     |
//     (), 4 -> weight = 2
//     |
//     6 -> weight = 1
//     Example C: {{1,2},3,{4,{6}, 5}}
//     Step1: find the max depth => 3
//     Step2:
//
//
//     () 3 ()         -> weight = 3 (depth of tree = 3)
//     / \  / \ \
//     1 2  4 (), 5    -> weight = 2
//     |
//     6      -> weight = 1
//
//     depth: 3
//
//     level1: [3]
//     level2: [ 3,4, 5]
//     level3 : 6
//
//     sl3 * (elv-dep + 1)
//
//     (3 * 3) + (1 + 2 + 4 + 5) * 2 + ( 6 * 1  ) = 9 + 24  + 6 =  39
//
//     */
//
//// {{1,2},3,{4,{6}, 5} }
//
//// {}
//
//
//    public int reverseDepthSum (List<NestedInteger> input)
//    {
//        Map<Integer, Integer> levelVsSum = new HashMap<>();
//        for(NestedInteger in: input) {
//            helper(in, 1, levelVsSum);
//        }
//
//        int maxDepth = levelVsSum.size();
//
//        int ans = 0;
//
//        for(int i= 1; i<maxDepth; i++) {
//            int multiplier = maxDepth - i + 1;
//            ans += (levelVsSum.getOrDefault(i, 0) * multiplier);
//        }
//
//        return ans;
//    }
//
//    public void helper(NestedIntege input, int level, Map<Integer, Integer> levelVsSum) {
//        if(input.isInteger()) {
//            int val = levelVsSum.getOrDefault(level, 0);
//            val +=input.getInteger();
//            levelVsSum.put(level, val);
//            return;
//        }
//
//        for(NestedInteger nestedInteger : input.getList()) {
//            helper(nestedInteger, level+1, levelVsSum);
//        }
//
//    }
//
//
//
///**
// * This is the interface that represents nested lists.
// * You should not implement it, or speculate about its implementation.
// */
//public interface NestedInteger
//{
//    /** @return true if this NestedInteger holds a single integer, rather than a nested list */
//    boolean isInteger();
//
//    /** @return the single integer that this NestedInteger holds, if it holds a single integer
//     * Return null if this NestedInteger holds a nested list */
//    Integer getInteger();
//
//    /** @return the nested list that this NestedInteger holds, if it holds a nested list
//     * Return null if this NestedInteger holds a single integer */
//    List<NestedInteger> getList();
//}