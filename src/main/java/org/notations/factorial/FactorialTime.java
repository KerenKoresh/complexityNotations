package org.notations.factorial;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Factorial Time: O(n!) </h1>
 * <p> describes algorithms whose running time grows as a factorial function of the input size (n).
 * This is a highly inefficient time complexity and becomes impractical for relatively small input sizes. </p>
 */
public class FactorialTime {

    /**
     * <h2> Generating All Permutations </h2>
     * <p> generates all possible permutations of an input array using a recursive approach.
     * It explores all possible orders of elements,
     * resulting in a factorial number of recursive calls and permutations.
     * This leads to O(n!) time complexity. </p>
     * @param nums integers array
     * @return all possible permutations
     */
    public List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutationsRecursive(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void generatePermutationsRecursive(int[] nums, List<Integer> current, List<List<Integer>> permutations) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                generatePermutationsRecursive(nums, current, permutations);
                current.remove(current.size() - 1);
            }
        }
    }


    /**
     * <h2> Solving the Traveling Salesman Problem (TSP) using Brute Force </h2>
     * <p> we use a brute force approach to solve the Traveling Salesman Problem (TSP)
     * by exploring all possible permutations of cities to find the shortest tour.
     * The number of permutations grows as n!,
     * making this approach impractical for a large number of cities.</p>
     * @param graph 2D array representing the weighted graph of cities.
     *              graph[i][j] contains the distance (or cost) from city i to city j.
     *              It's a square matrix where the diagonal elements are typically set to 0
     *              (as the distance from a city to itself is 0).
     * @return minimum cost
     */
        public int solveTSP(int[][] graph) {
            // assigned the number of cities in the problem, which is the size of the graph array.
            int n = graph.length;
            // is an integer array of size n that represents the order in which cities are visited.
            // Initially, it's set to [0, 1, 2, ..., n-1], where n is the number of cities.
            int[] path = new int[n];
            for (int i = 0; i < n; i++) {
                path[i] = i;
            }
            // initialized with a large value (Integer.MAX_VALUE)
            // to keep track of the minimum cost found during the search.
            int minCost = Integer.MAX_VALUE;

            // The main loop uses a brute-force approach to find the shortest tour
            // . It does this by generating all possible permutations of the path array.
            // The idea is to iterate through all possible orders
            // in which cities can be visited
            // and calculate the total cost for each permutation.
            do {
                // calculateTourCost is called to compute the total cost of the tour represented by the current permutation
                // The total cost is stored in the currentCost variable
                int currentCost = calculateTourCost(graph, path);
                // The minCost variable is updated with the minimum cost found so far.
                // This ensures that minCost eventually holds the cost of
                // the shortest tour discovered during the search.
                minCost = Math.min(minCost, currentCost);

                //The nextPermutation method is used to generate the next permutation of the path array.
                // This method efficiently generates permutations in lexicographic order.
                // If there are no more permutations to generate, the loop exits.
            } while (nextPermutation(path));

            // After exploring all possible permutations and finding the minimum cost,
            // the minCost value is returned as the solution to the TSP.
            return minCost;
        }

        private int calculateTourCost(int[][] graph, int[] path) {
            int cost = 0;
            for (int i = 0; i < path.length - 1; i++) {
                cost += graph[path[i]][path[i + 1]];
            }
            cost += graph[path[path.length - 1]][path[0]];
            return cost;
        }

        private boolean nextPermutation(int[] array) {
            int i = array.length - 2;
            while (i >= 0 && array[i] >= array[i + 1]) {
                i--;
            }
            if (i < 0) {
                return false;
            }
            int j = array.length - 1;
            while (array[j] <= array[i]) {
                j--;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
            return true;
        }


}
