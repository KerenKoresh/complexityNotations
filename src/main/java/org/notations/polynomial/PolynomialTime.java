package org.notations.polynomial;

/**
 * <h1> Polynomial Time: O(n^k) </h1>
 * <p> Polynomial time complexity (O(n^k)) is characterized by algorithms whose
 * running time grows as a polynomial function of the input size (n),
 * where k is a constant exponent.
 * These algorithms are generally more efficient and practical for a wide range of input sizes.</p>
 *
 * <p> Polynomial time complexity is preferred for practical purposes because
 * it ensures that algorithms remain efficient even as the input size increases.
 * The higher the exponent (k), the higher the polynomial degree and the steeper the growth rate.</p>
 */
public class PolynomialTime {

    /**
     * <h2> Quadratic Time - O(n^2): Bubble Sort </h2>
     * <p> Bubble Sort is a sorting algorithm that
     * compares and swaps adjacent elements repeatedly until the entire array is sorted.
     * It has a polynomial time complexity of O(n^2) because the
     * number of comparisons and swaps is proportional to
     * the square of the input size (n).</p>
     * @param array integers array
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
     * <h2> Cubic Time - O(n^3): Matrix Multiplication </h2>
     * <p> Matrix multiplication involves three nested loops to calculate the product of two matrices.
     * It has a polynomial time complexity of O(n^3) because
     * the number of operations is proportional to the cube of the input size.</p>
     * @param A matrix 1
     * @param B matrix 2
     * @return product of the matrices
     */
    public int[][] matrixMultiplication(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int p = B[0].length;
        int[][] result = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    /**
     * <h2> Quartic Time - O(n^4): Polynomial Evaluation </h2>
     * <p> Evaluating a polynomial with coefficients using nested loops
     * to calculate each term's contribution results in a polynomial time complexity of O(n^4).
     * The number of operations grows as the fourth power of the input size.</p>
     * @param coefficients array of integers that represents the coefficients of the polynomial expression.
     * @param x value at which you want to evaluate the polynomial
     * @return value of the polynomial expression for the specified x
     */
    public int evaluatePolynomial(int[] coefficients, int x) {
        // to store the final result of evaluating the polynomial for the given x
        int result = 0;
        // length of the coefficients array,
        // which corresponds to the highest power of x in the polynomial.
        int n = coefficients.length;
        // iterates over each element of the coefficients array,
        // from the lowest-degree term to the highest-degree term.
        for (int i = 0; i < n; i++) {
           // representing the contribution of the current coefficient to the overall polynomial
            int term = coefficients[i];

            for (int j = 0; j < i; j++) {
                // representing the contribution of the current coefficient to the overall polynomial,
                // is computed and stored in the term variable.
                term *= x;
            }
            // The term is added to the result.
            // This step accumulates the contributions of all the terms in the polynomial for the given value of x.
            result += term;
        }
        // After all coefficients have been processed, the function returns the final result,
        // which is the value of the polynomial expression for the specified x.
        return result;
    }


}
