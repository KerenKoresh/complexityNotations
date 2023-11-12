package org.notations.logarithmic;

/**
 * <h1> Logarithmic Time: O(log n) </h1>
 *
 * <p> Logarithmic time complexity, denoted as O(log n),
 * is often seen in algorithms that divide the input data
 * into smaller portions and work with one portion at a time.</p>
 * <p> The time taken by these algorithms grows slowly as the input size increases </p>
 * <p> each example has time complexity O(log n)
 * because the algorithm divides the problem into smaller parts at each step,
 * reducing the problem size logarithmically.</p>
 */
public class LogarithmicTime {

    /**
     * <h2> Binary Search </h2>
     * <p> is a commonly used algorithm in computer science and mathematics for
     * finding a specific target value within a sorted array or list.</p>
      <p> In binary search, the array is divided in half at each step,
     * and the search space is reduced logarithmically. </p>
     *<p> If the array is not sorted, you'll need to sort it first,
     *  which might have a time complexity of O(n log n) or more,
     *  depending on the sorting algorithm used </p>
     * @param sortedArray ints sorted array
     * @param key to search
     * @return key if was found, otherwise returns -1
     */
    public int binarySearch(int[] sortedArray, int key) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the midpoint.
            if (sortedArray[mid] == key) {
                return mid; // Found the key.
            }
            if (sortedArray[mid] < key) {
                left = mid + 1; // Search the right half.
            } else {
                right = mid - 1; // Search the left half.
            }
        }
        return -1; // Key not found.
    }


    /**
     * <h2> findGCD - Finding the Greatest Common Divisor (GCD) using Euclidean Algorithm </h2>
     * <p> The Euclidean algorithm for finding the GCD of two numbers
     * works by repeatedly taking the remainder,
     * and the number of iterations is proportional to the logarithm of the input values. </p>
     * <p>
     *<h3> How Euclidean Algorithm works </h3>
     * <p> 1) Given two integers, a and b, where a is greater than or equal to b. </p>
     * <p> 2) he algorithm repeatedly applies the division remainder operation (modulo operation) to find the GCD.</p>
     * <p> 3) The key observation is that the GCD of a and b is the same as the GCD of b and a % b. </p>
     * <p>
     *     4) The algorithm proceeds as follows:
     * <div> * If b is equal to 0, then the GCD is found, and it's equal to a. </div>
     * <div> * Otherwise, calculate the new values of a and b: </div>
     * <div>  - a remains the same. </div>
     * <div> - b becomes the remainder of the division a / b, which is denoted as a % b. </div>
     * </p>
     * <p> 5) The algorithm repeats these steps with the new values of a and b until b becomes 0.
     * At this point, the GCD is found, and it's equal to the current value of a.</p>
     * </p>
     * @param a int 1
     * @param b int 2
     * @return greatest common divisor
     */
    public int findGCD(int a, int b) {
        if (b == 0) {
            return a; // GCD is found, return 'a'.
        }
        // Calculate the new values of 'a' and 'b'.
        return findGCD(b, a % b);
    }

    /**
     * <h2> mergeSort - Divide and Conquer Algorithms </h2>
     * <p>Merge Sort's time complexity is O(n log n) in all cases,
     * making it one of the most efficient comparison-based sorting algorithms.
     * The divide and conquer approach allows it to sort arrays of any size with consistent performance.
     * This is achieved by dividing the problem into smaller sub-problems and
     * merging them in a way that guarantees a sorted result.</p>
     *
     * <p> <h3> How Merge Sort Algorithm works? </h3>
     * <div> 1) Divide: The input array is divided into two roughly equal halves.
     * This step continues recursively until each sub-array has only one element or is empty.
     * At this point, each sub-array is, by definition, sorted.</div>
     * <div> 2) Conquer: The individual sorted sub-arrays are merged (combined)
     * to produce new sorted sub-arrays.
     * This process continues until there is only one sorted array left,
     * which is the sorted version of the entire input array.</div>
     * <div> 3) Merge: The merging of two sub-arrays into a single sorted array is the critical step in Merge Sort.
     * This involves comparing the elements from the two sub-arrays and
     * merging them into a new sorted sub-array.</div>
     * </p>
     * @param array ints array
     * @param left
     * @param right
     */
    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves.
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves.
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves.
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        // Calculate the sizes of the two subarrays to be merged.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the two subarrays.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to the temporary arrays.
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the two subarrays back into the original array.
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left and right subarrays, if any.
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * <h2> power - Efficiently Calculating Powers (e.g., Exponentiation) </h2>
     * <p> The exponentiation algorithm divides the problem into smaller parts
     * by repeatedly dividing the exponent by 2,
     * resulting in a logarithmic number of operations.</p>
     *
     * <p> <h3> How Exponentiation works? </h3>
     * <div> 1) Base Case:
     * If the exponent is 0, the function returns 1,
     * as any number raised to the power of 0 is 1.</div>
     * <div> 2) Recursive Step:
     * The function calculates halfPower as the result of power(base, exponent / 2).
     * This is the recursive step where the problem is divided
     * into smaller subproblems by halving the exponent.</div>
     * <div> 3) Exponent Even:
     * If the exponent is even, we use the fact that base^exponent is equal to (base^(exponent/2))^2.
     * So, we square halfPower to get the result.
     * This is an optimization, as it reduces the number of multiplications needed.</div>
     * <div> 4) Exponent Odd:
     * If the exponent is odd, we take the same approach but also multiply the result by the base.
     * This accounts for the extra factor of the base.</div>
     * </p>
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        // Base case: If the exponent is 0, the result is 1.
        if (exponent == 0) {
            return 1.0;
        }

        // Calculate halfPower as the result of power(base, exponent/2).
        double halfPower = power(base, exponent / 2);

        // If the exponent is even, square halfPower to get the result.
        if (exponent % 2 == 0) {
            return halfPower * halfPower;
        }
        // If the exponent is odd, square halfPower and multiply it by the base.
        else {
            return halfPower * halfPower * base;
        }
    }



}
