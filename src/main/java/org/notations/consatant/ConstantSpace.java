package org.notations.consatant;

import java.util.HashMap;

/**
 *<h1> Constant Space: O(1) </h1>
 * <p> Algorithms with constant space complexity use a fixed amount of memory
 * regardless of the input size.
 * They typically involve only a small number of variables or data structures.</p>
 */
public class ConstantSpace {

    /**
     * <h2> Swapping Two Variables </h2>
     * <p> Swapping two variables using bitwise XOR operation in constant space </p>
     * <p> Swapping two variables without a temporary variable.</p>
     * <div> The XOR-based swapping method is efficient and does not require additional memory.
     * It's a clever use of bitwise operations to exchange values.</div>
     * @param a
     * @param b
     */
    public void swap(int a, int b) {
        a = a ^ b;       // XOR swap: a contains the result of a XOR b.
        b = a ^ b;       // XOR swap: b now contains the original value of a.
        a = a ^ b;       // XOR swap: a now contains the original value of b.
    }


    /**
     * <h2> Find Max Value </h2>
     * <p> he findMax function is a simple algorithm designed to
     * find the maximum value among two input numbers, a and b</p>
     * @param a
     * @param b
     * @return max value
     */
    public int findMax(int a, int b) {
        return (a > b) ? a : b;
    }



}
