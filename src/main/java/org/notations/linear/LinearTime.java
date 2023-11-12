package org.notations.linear;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Linear Time: O(n) </h1>
 * <p>  used to describe the relationship between the size of the input data (n) and the
 * time it takes for an algorithm to run.
 * In O(n) algorithms, the time required for the algorithm to complete its task
 * increases linearly with the size of the input data.</p>
 */
public class LinearTime {

    /**
     * <h2> iterateArray - Iterating Through an Array </h2>
     * <p> This algorithm iterates through an array of integers,
     * performing a constant-time operation (printing the element) for each element.
     * The time complexity is O(n) because it has to
     * visit and process each element in the array.</p>
     * @param array integers array
     */
    public void iterateArray(int[] array) {
        // Iterate through the entire array.
        for (int i = 0; i < array.length; i++) {
            // Perform an operation on each element.
            System.out.println(array[i]);
        }
    }

    /**
     * <h2> findMax - Finding the Maximum Element in an Array </h2>
     * <p> This algorithm finds the maximum element in an array by
     * iterating through it once and
     * updating the maximum value as needed.
     * It has a time complexity of O(n) because it makes
     * one pass through the entire array.</p>
     * @param array integers array
     * @return max int
     */
    public int findMax(int[] array) {
        int max = array[0];
        // Iterate through the array to find the maximum element.
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * <h2> linearSearch - Linear Search for a Target Value in an Unsorted Array </h2>
     * <p> This is the linear search algorithm,
     * which iterates through an unsorted array to find a specific target value.
     * The time complexity is O(n) in the worst case because it may have to
     * examine all elements before finding the target or confirming its absence.</p>
     * @param array integers array
     * @param target value to search
     * @return index of the target if found, otherwise returns -1
     */
    public int linearSearch(int[] array, int target) {
        // Iterate through the array to search for the target.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index of the target if found.
            }
        }
        return -1; // Return -1 to indicate that the target is not in the array.
    }

    /**
     * <h2> countOccurrences - Counting the Number of Occurrences of a Value in an Array </h2>
     * <p> This algorithm counts the number of occurrences of a specific value in an array.
     * It has a time complexity of O(n) because it
     * iterates through the entire array, checking each element.</p>
     * @param array integers array
     * @param value to count its occurrences
     * @return occurrences of value
     */
    public int countOccurrences(int[] array, int value) {
        int count = 0;
        // Iterate through the array and count occurrences of the value.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * <h2> copyArray - Copying an Array </h2>
     * <p> This algorithm creates a copy of an array by
     * iterating through the original array and copying its elements to a new array.
     * The time complexity is O(n) because it requires visiting and copying each element.</p>
     * @param original original integers array
     * @return copy of original array
     */
    public int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        // Iterate through the original array and copy its elements.
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }


}
