package org.notations.linearithmic;

/**
 * <h1> Linearithmic Time: O(n log n) </h1>
 * <p>
 * O(n log n) time complexity, often referred to as linearithmic time complexity,
 * is a classification used in algorithm analysis.
 * It describes algorithms where the running time grows in
 * a linearithmic relationship with the input size.
 * This means the time required increases at a rate between linear (O(n)) and logarithmic (O(log n),
 * typically O(n log n).</p>
 * <p> The "log n" factor arises because the algorithms perform a logarithmic number of operations,
 * which depend on the size of the input, and
 * the "n" factor is due to the linear processing of each element within those operations.</p>
 */
public class LinearithmicTime {

    /**
     * <h2> Merge Sort </h2>
     * <p> Merge Sort is a popular sorting algorithm that uses
     * a divide-and-conquer strategy to efficiently sort an array or list of elements.
     * The key idea is to divide the input into smaller parts, recursively sort those parts,
     * and then merge them back together</p>
     *
     * <p> <h3> How Merge Sort works? </h3>
     * <div> 1) Base Case:
     * The mergeSort method first checks if the input array has 0 or 1 elements.
     * If so, it's already considered sorted, and the function
     * returns without further processing </div>
     * <div> 2) Splitting the Array:
     * The array is divided into two subarrays, left and right,
     * by calculating the middle index.</div>
     * <div> 3) Populating Subarrays:
     * The elements of the original array are copied into the left and right subarrays.</div>
     * <div> 4) Recursive Sorting:
     * The mergeSort method is called recursively on both the left and right subarrays.</div>
     * <div> 5) Merging:
     * The merge method is used to merge the two sorted subarrays (left and right)
     * back into the original array (result).</div>
     * <div> 6) Merging Process:
     * - In the merge method, the two subarrays are merged by comparing elements from each subarray,
     * and the smaller element is placed in the result array.
     * - Any remaining elements in the subarrays are copied into the result array.</div>
     * </p>
     * <p> When the mergeSort function completes,
     * the original array will be sorted in ascending order.
     * This divide-and-conquer approach ensures that the algorithm has a time complexity of O(n log n),
     * making it efficient for large datasets.</p>
     * @param array
     */
        public void mergeSort(int[] array) {
            // Check for the base case: If the array has 0 or 1 elements, it's already sorted.
            if (array.length <= 1) {
                return;
            }

            // Calculate the middle index of the array.
            int middle = array.length / 2;

            // Create two subarrays by dividing the input array in half.
            int[] left = new int[middle];
            int[] right = new int[array.length - middle];

            // Populate the left and right subarrays.
            for (int i = 0; i < middle; i++) {
                left[i] = array[i];
            }
            for (int i = middle; i < array.length; i++) {
                right[i - middle] = array[i];
            }

            // Recursively sort the left and right subarrays.
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted subarrays back into the original array.
            merge(array, left, right);
        }

        private void merge(int[] result, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;

            // Compare elements from the left and right subarrays and merge them into the result array.
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
                k++;
            }

            // Copy any remaining elements from the left and right subarrays, if any.
            while (i < left.length) {
                result[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                result[k] = right[j];
                j++;
                k++;
            }
        }

    /**
     * <h2> Quick Sort </h2>
     * <p>  works by selecting a pivot element from the array and partitioning the other elements
     * into two sub-arrays, according to whether they are less than or greater than the pivot.</p>
     * <p> <h3> How Quick Sort works </h3>
     * <div> 1) Base Case:
     * The quickSort method checks whether there is more than one element in the subarray to be sorted.
     * If not, it returns without further processing.</div>
     * <div> 2) Partitioning:
     * The partition method selects a pivot element (in this case, the last element in the subarray)
     * and rearranges the other elements into two subarrays,
     * one with elements smaller than the pivot and another with elements greater than the pivot.</div>
     * <div> 3) Recursive Sorting:
     * The quickSort method is called recursively on both the subarray of
     * elements smaller than the pivot and the
     * subarray of elements greater than the pivot.</div>
     * <div> 4)
     * Merging Partitions:
     * The pivot element is placed in its final sorted position.
     * The elements to the left of the pivot are less than the pivot,
     * and the elements to the right are greater.</div>
     * <div> 5) Recursive Calls:
     * The quickSort method is called recursively on both sides of the pivot,
     * which effectively sorts the entire array.</div>
     * </p>
     ** @param array
     * @param low
     * @param high
     */
    public void quickSort(int[] array, int low, int high) {
        // Partition the array into two subarrays and get the pivot's final position.
        int pivotIndex = partition(array, low, high);

        // Recursively sort the subarrays on both sides of the pivot.
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        // Select the pivot element (in this case, the last element).
        int pivot = array[high];
        int i = low - 1; // Index of the smaller element.

        // Iterate through the array, compare each element with the pivot, and move smaller elements to the left.
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j].
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at (i + 1), placing the pivot in its final position.
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the index of the pivot.
    }


}
