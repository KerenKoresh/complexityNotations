package org.notations.exponential;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Exponential Time: O(2^n) </h1>
 * <p> Exponential time complexity (O(2^n)) is characterized by algorithms whose
 * running time grows exponentially with the input size (n).
 * These algorithms become increasingly inefficient as the input size increases,
 * making them impractical for large datasets. </p>
 */
public class ExponentialTime {


    /**
     * <h2> Generating All Subsets </h2>
     * <p> we use a recursive approach to generate all possible subsets of an array of integers.
     * The number of subsets generated is exponential,
     * and the code explores all possible combinations of
     * including or excluding each element in the subset.</p>
     * @param nums intgers array
     * @return all subsets
     */
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsetsRecursive(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsetsRecursive(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        // Include the current element in the subset.
        current.add(nums[index]);
        generateSubsetsRecursive(nums, index + 1, current, subsets);
        // Exclude the current element from the subset.
        current.remove(current.size() - 1);
        generateSubsetsRecursive(nums, index + 1, current, subsets);
    }


    /**
     * <h2> Solving Traveling Salesman Problem (TSP) using Brute Force </h2>
     * <p> we use a brute force approach to solve the Traveling Salesman Problem (TSP).
     * The code explores all possible permutations of cities to find the shortest tour,
     * resulting in exponential time complexity (O(2^n))
     * as the number of permutations grows exponentially with the number of cities.</p>
     * @param graph
     * @return
     */
        public int solveTSP(int[][] graph) {
            int n = graph.length;
            int[] visited = new int[n];
            for (int i = 0; i < n; i++) {
                visited[i] = 0;
            }
            visited[0] = 1;
            int minCost = TSPRecursive(graph, visited, 0, 1, n, 0);

            return minCost;
        }

        private int TSPRecursive(int[][] graph, int[] visited, int current, int count, int n, int cost) {
            if (count == n && graph[current][0] > 0) {
                return cost + graph[current][0];
            }
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && graph[current][i] > 0) {
                    visited[i] = 1;
                    int newCost = TSPRecursive(graph, visited, i, count + 1, n, cost + graph[current][i]);
                    minCost = Math.min(minCost, newCost);
                    visited[i] = 0;
                }
            }
            return minCost;
        }


}
