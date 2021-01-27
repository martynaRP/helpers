package com.epam.prejap.ess.helpers.objectsmethodswithindex;

import java.util.Objects;

/**
 * Objects.all-methods-to-check-INDEXes-and-related
 * <p>
 * There are three methods in {@code java.util.Objects}
 * class that are related to checking index:
 *     <ul>
 *         <li>{@code checkIndex}</li>
 *         <li>{@code checkFromToIndex}</li>
 *         <li>{@code checkFromIndexSize}</li>
 *     </ul>
 * They check if indexes or sub-range values are out of bounds. If so, they throw an {@code
 * IndexOutOfBoundException}, otherwise they return the initial index. The bounds are defined by the range from 0
 * (inclusive) to provided length (exclusive). <br>
 * Each of these methods calls a method with the same respective name from {@code jdk.internal.util.Preconditions},
 * a class with utility methods to check if state or arguments are correct. <br>
 * These methods were introduced in Java 9.
 * </p>
 *
 * @author Martyna Rucińska Pereira
 */
class ObjectsMethodsWithIndex {

    /**
     * Checks if the {@code index} is within the bounds of the range from 0 (inclusive) to length (exclusive),
     * in other words, checks if {@code index} ∈ {0, 1, ..., length - 1}.
     *
     * @param index the index
     * @param length the upper-bound (exclusive) of the range
     * @return {@code index} if the index within bounds of the range
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    static int checkIndexWithinRange(int index, int length) {
        return Objects.checkIndex(index, length);
    }

    /**
     * Checks if the sub-range from {@code fromIndex} (inclusive) to {@code toIndex} (exclusive) is within the bounds
     * of range from {@code 0} (inclusive) to {@code length} (exclusive), in other words, checks if <br>
     * {@code {fromIndex, fromIndex + 1, ..., toIndex - 1} ⊆ {0, 1, ..., length - 1}}.
     *
     * @param fromIndex the lower-bound (inclusive) of the sub-range
     * @param toIndex   the upper-bound (exclusive) of the sub-range
     * @param length    the upper-bound (exclusive) of the range
     * @return {@code fromIndex} if the sub-range within bounds of the range
     * @throws IndexOutOfBoundsException if the sub-range is out of bounds
     */
    static int checkSubrangeFromToIndexWithinRange(int fromIndex, int toIndex, int length) {
        return Objects.checkFromToIndex(fromIndex, toIndex, length);
    }

    /**
     * Checks if the sub-range from {@code fromIndex} (inclusive) to {@code fromIndex + size} (exclusive) is within
     * the bounds of range from {@code 0} (inclusive) to {@code length} (exclusive), in other words, checks if <br>
     * {@code {fromIndex, ..., fromIndex + size - 1} ⊆ {0, 1, ..., length - 1}}.
     *
     * @param fromIndex the lower-bound (inclusive) of the sub-range
     * @param size      the size of the sub-range
     * @param length    the upper-bound (exclusive) of the range
     * @return {@code fromIndex} if the sub-range within bounds of the range
     * @throws IndexOutOfBoundsException if the sub-range is out of bounds
     */
    static int checkSubrangeFromIndexSizeWithinRange(int fromIndex, int size, int length) {
        return Objects.checkFromIndexSize(fromIndex, size, length);
    }
}
