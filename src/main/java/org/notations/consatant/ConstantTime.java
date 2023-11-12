package org.notations.consatant;

import java.util.HashMap;

/**
 *<h1> Constant Time: O(1) </h1>
 *
 * <p> The algorithm's runtime is not dependent on the size of the input.
 *  It performs a constant number of operations.</p>
 *
 * <p>
 * this class contains some examples of algorithms with O(1) constant time complexity.
 * </p>
 * <p>
 * These examples illustrate that O(1) represents constant time complexity,
 * meaning that the time taken to perform these operations does not depend on the input size;
 * it remains the same regardless of the data involved.
 * </p>
 */
public class ConstantTime {

    /**
     * <h2> getElementAtIndex - Accessing an Element in an Array by Index </h2>
     * <p> In this example,
     * no matter how large the array is,
     * accessing an element by its index takes the same amount of time,
     * making it O(1) constant time complexity. </p>
     * @param array array with int elements
     * @param index index of element
     * @return element if index is not negative and
     * index < array length, otherwise returns -1 */
    public int getElementAtIndex(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        }
        return -1; // Out of bounds, but the time complexity remains O(1).
    }

    /**
     * <h2> getValueFromHashMap - Retrieving a Value from a HashMap </h2>
     * <p> When using a HashMap,
     * the time required to retrieve a value associated with a given key is constant,
     * assuming a well-distributed hash function.</p>
     * @param map to retrieve value from by key
     * @param key to retrieve its value
     * @return if key found - returns its value, otherwise returns "Key not found"
     */
    public String getValueFromHashMap(HashMap<String, String> map, String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return "Key not found"; // The time complexity is O(1).
    }

    /**
     * <h2> isEven - Determining Parity (Even or Odd) </h2>
     * <p> Checking whether a number is even or odd can be done in constant time since
     * it only requires a single arithmetic operation. </p>
     * @param number to determine if even or odd
     * @return true if even, otherwise returns false
     */
    public boolean isEven(int number) {
        return (number % 2 == 0); // Calculating the parity of a number is an O(1) operation.
    }

    /**
     * <h2> isNotNull - Checking for Null Reference </h2>
     * <p> Checking if an object reference is not null is a simple operation that
     * doesn't depend on the size of the object or the number of objects in memory. </p>
     * @param obj to check if not null
     * @return true if not null. otherwise returns false
     */
    public boolean isNotNull(Object obj) {
        return obj != null; // Determining if an object reference is not null is O(1).
    }

}
