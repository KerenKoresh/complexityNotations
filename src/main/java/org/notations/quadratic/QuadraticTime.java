package org.notations.quadratic;

/**
 * <h1> Quadratic Time: O(n^2) </h1>
 * <p> The algorithm's runtime grows with the square of the input size.
 * It's <b>  common in nested loops.</b> </p>
 * <p> It describes algorithms where the running time grows quadratically with the
 * size of the input data.
 * This means that as the input size (n) increases,
 * the time required increases as the square of the input size.</p>
 *
 * <p> the examples illustrate algorithms with quadratic time complexity (O(n^2)),
 * where the running time grows quadratically with the input size.
 * Quadratic time complexity is often less efficient than linear (O(n)) or logarithmic (O(n log n) ) time complexities,
 * especially for larger datasets.</p>
 */
public class QuadraticTime {

    /**
     * <h2> Bubble Sort </h2>
     * <p> compares and swaps adjacent elements repeatedly until the entire array is sorted.
     * In the worst case, it has a time complexity of O(n^2).</p>
     * @param array integers array to sort
     */
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order.
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * <h2> Selection Sort </h2>
     * <p> repeatedly selects the minimum element from the unsorted portion of the array and
     * moves it to the sorted portion.
     * It has a time complexity of O(n^2) in the worst case.</p>
     * @param array integers array to sort
     */
    public void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the current element.
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * <h2> Insertion Sort </h2>
     * <p> builds the final sorted array one element at a time by
     * repeatedly taking the next element and inserting it
     * into the correct position.
     * In the worst case, it has a time complexity of O(n^2).</p>
     * @param array integers array to sort
     */
    public void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * <h2> Brute Force String Matching </h2>
     * <p> checks every possible substring of the text to see
     * if it matches the pattern.
     * It has a time complexity of O(n^2) in the worst case.</p>
     * @param text text to check pattern
     * @param pattern pattern to check in text
     * @return index of pattern if found, otherwise returns -1
     */
    public int bruteForceStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // Pattern found at index i in the text.
            }
        }
        return -1; // Pattern not found in the text.
    }


}
