package com.epam.prejap.ess.helpers.objectsmethodswithindex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.prejap.ess.helpers.objectsmethodswithindex.ObjectsMethodsWithIndex.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ObjectsMethodsWithIndexTest {
    private static final Class<IndexOutOfBoundsException> EXCEPTION_CLASS = IndexOutOfBoundsException.class;

    @DataProvider
    public static Object[][] indexWithinBounds() {
        return new Object[][]{{0, 12}, {2, 5}, {4, 9}};
    }

    @DataProvider
    public static Object[][] negativeIndex() {
        return new Object[][]{{-1, 5}};
    }

    @DataProvider
    public static Object[][] IndexNotSmallerThanLength() {
        return new Object[][]{{4, 4}, {9, 5}, {4, -2}};
    }


    @DataProvider
    public static Object[][] subrangeWithinBoundsFromToIndex() {
        return new Object[][]{{0, 8, 8}, {3, 18, 20}};
    }

    @DataProvider
    public static Object[][] negativeFromIndexWithToIndex() {
        return new Object[][]{{-3, 2, 4}};
    }

    @DataProvider
    public static Object[][] fromIndexBiggerThatToIndex() {
        return new Object[][]{{8, 5, 9}};
    }

    @DataProvider
    public static Object[][] toIndexBiggerThanLength() {
        return new Object[][]{{4, 12, 10}, {4, 7, -4}};
    }

    @DataProvider
    public static Object[][] subrangeWithinBoundsFromIndexSize() {
        return new Object[][]{{0, 8, 8}, {5, 10, 20}};
    }

    @DataProvider
    public static Object[][] negativeFromIndexWithSize() {
        return new Object[][]{{-4, 3, 12}};
    }

    @DataProvider
    public static Object[][] negativeSize() {
        return new Object[][]{{5, -2, 10}};
    }

    @DataProvider
    public static Object[][] fromIndexPlusSizeBiggerThanLength() {
        return new Object[][]{{6, 8, 11}, {2, 7, -5}, {Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 2, 20}};
    }

    @Test(dataProvider = "indexWithinBounds")
    public void checkIndexShouldReturnIndexWhenIndexWithinBounds(int index, int length) {
        //given

        //when
        int actualIndex = checkIndexWithinRange(index, length);
        //then
        assertEquals(actualIndex, index, "Index should be equal to the initial one.");

    }

    @Test(dataProvider = "negativeIndex")
    public void checkIndexShouldThrowExceptionWhenNegativeIndex(int index, int length) {
        assertThrows(EXCEPTION_CLASS, () -> checkIndexWithinRange(index, length));
    }

    @Test(dataProvider = "IndexNotSmallerThanLength")
    public void checkIndexShouldThrowExceptionWhenIndexOutOfRange(int index, int length) {
        assertThrows(EXCEPTION_CLASS, () -> checkIndexWithinRange(index, length));
    }

    @Test(dataProvider = "subrangeWithinBoundsFromToIndex")
    public void checkFromToIndexShouldReturnFromIndexWhenSubrangeWithinBounds(int fromIndex, int toIndex, int length) {
        int actualIndex = checkSubrangeFromToIndexWithinRange(fromIndex, toIndex, length);

        assertEquals(actualIndex, fromIndex, "Index should be equal to the lower bound of the sub-range.");
    }

    @Test(dataProvider = "negativeFromIndexWithToIndex")
    public void checkFromToIndexShouldThrowExceptionWhenNegativeFromIndex(int fromIndex, int toIndex, int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromToIndexWithinRange(fromIndex, toIndex, length));
    }


    @Test(dataProvider = "fromIndexBiggerThatToIndex")
    public void checkFromToIndexShouldThrowExceptionWhenFromIndexBiggerThatToIndex(int fromIndex, int toIndex,
                                                                                   int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromToIndexWithinRange(fromIndex, toIndex, length));
    }

    @Test(dataProvider = "toIndexBiggerThanLength")
    public void checkFromToIndexShouldThrowExceptionWhenSubrangeOutOfBounds(int fromIndex, int toIndex,
                                                                                int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromToIndexWithinRange(fromIndex, toIndex, length));
    }

    @Test(dataProvider = "subrangeWithinBoundsFromIndexSize")
    public void checkFromIndexSizeShouldReturnFromIndexWhenSubrangeWithinBounds(int fromIndex, int size, int length) {
        int actualIndex = checkSubrangeFromIndexSizeWithinRange(fromIndex, size, length);

        assertEquals(actualIndex, fromIndex, "Index should be equal to the lower bound of the sub-range.");
    }

    @Test(dataProvider = "negativeFromIndexWithSize")
    public void checkFromIndexSizeShouldThrowExceptionWhenNegativeFromIndex(int fromIndex, int size, int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromIndexSizeWithinRange(fromIndex, size, length));
    }

    @Test(dataProvider = "negativeSize")
    public void checkFromIndexSizeShouldThrowExceptionWhenNegativeSize(int fromIndex, int size, int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromIndexSizeWithinRange(fromIndex, size, length));
    }

    @Test(dataProvider = "fromIndexPlusSizeBiggerThanLength")
    public void checkFromIndexSizeShouldThrowExceptionWhenSubrangeOutOfBounds(int fromIndex, int size,
                                                                                            int length) {
        assertThrows(EXCEPTION_CLASS, () ->
                checkSubrangeFromIndexSizeWithinRange(fromIndex, size, length));
    }
}
