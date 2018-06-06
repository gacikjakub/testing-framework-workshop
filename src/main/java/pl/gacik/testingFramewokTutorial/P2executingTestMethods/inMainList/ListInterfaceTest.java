package pl.gacik.testingFramewokTutorial.P2executingTestMethods.inMainList;

import java.util.Arrays;
import java.util.List;

public class ListInterfaceTest {
    public static void shouldGiveZeroSize(List impl) {
        // given
        List test = impl;

        // when


        // then
        assert test.size() == 0 : "non-zero size!";
    }

    public static void shouldGiveSizeOfOne(List impl) {
        // given
        List test = impl;

        // when
        test.add(new Object());

        // then
        assert test.size() == 1 : "size should be 1!";
    }

    public static void shouldGiveZeroSizeAfterAdditionAndRemoval(List impl) {
        // given
        List test = impl;

        // when
        test.add(new Object());
        test.remove(0);

        // then
        assert test.size() == 0 : "size should be again 0!";
    }

    public static void shouldReturnTrueForEmpty(List impl) {
        // given
        List test = impl;

        // when

        // then
        assert test.isEmpty() : "array not empty!";
    }

    public static void shouldReturnFalseForNonEmpty(List impl) {
        // given
        List test = impl;

        // when
        test.add(new Object());

        // then
        assert !test.isEmpty() : "array is empty!";
    }

    public static void shouldNotContainNumber(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);

        // then
        assert !test.contains(2) : "array contains number 2";
    }

    public static void shouldContainNumber(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);
        test.add(2);

        // then
        assert test.contains(2) : "array doesn't contain number 2";
    }

    public static void shouldProduceEmptyArray(List impl) {
        // given
        List test = impl;

        // when
        Object[] array = test.toArray();

        // then
        assert array.length == 0 : "array not empty";
    }

    public static void shouldProduceArrayWith3Integers(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);
        test.add(2);
        test.add(3);
        Object[] array = test.toArray();

        // then
        assert array.length == 3 : "array doesn't contain 3 elements";
    }

    public static void shouldAddElementToList(List impl) {
        // given
        List test = impl;

        // when


        // then
        assert test.add(new Object()) : "failed to add element";
    }

    public static void shouldAddTheSameElementToList(List impl) {
        // given
        List test = impl;
        Object testObj = new Object();

        // when
        test.add(testObj);

        // then
        assert test.add(testObj) : "failed to add the same element to list";
    }

    public static void shouldRemoveObjectFromList(List impl) {
        // given
        List test = impl;

        // when
        Object testObj = new Object();
        test.add(testObj);

        // then
        assert test.remove(testObj) : "tested object cannot be removed from list";
    }

    public static void shouldRemoveElementByIndex(List impl) {
        // given
        List test = impl;

        // when
        Object testObj = new Object();
        test.add(testObj);

        // then
        assert testObj.equals(test.remove(0)) : "element 0 removed from list differs from original";
    }

    public static void shouldNotRemoveObjectFromListWhenAbsent(List impl) {
        // given
        List test = impl;

        // when
        Object testObj = new Object();
        Object testObj2 = new Object();
        test.add(testObj);

        // then
        assert !test.remove(testObj2) : "second object really present in the list?";
    }

    public static void shouldNotRemoveFromWrongIndexPosition(List impl) {
        // given
        List test = impl;
        boolean thrown = false;

        // when
        test.add(new Object());
        test.add(new Object());
        try {
            test.remove(2);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "object at index 2 strangely found";
    }

    public static void shouldContainAllCollection(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);
        test.add(2);
        test.add(3);
        Integer[] elements = {1, 2, 3, 3};

        // then
        assert test.containsAll(Arrays.asList(elements)) : "list doesn't contain specified collection";
    }

    public static void shouldContainSubcollection(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);
        test.add(2);
        test.add(3);
        Integer[] elements = {1, 2};

        // then
        assert test.containsAll(Arrays.asList(elements)) : "list doesn't contain sublist";
    }

    public static void shouldNotContainCollection(List impl) {
        // given
        List test = impl;

        // when
        test.add(1);
        test.add(2);
        Integer[] elements = {1, 2, 3};

        // then
        assert !test.containsAll(Arrays.asList(elements)) : "list strangely contains a larger collection";
    }

    public static void shouldAddAllElements(List impl) {
        // given
        List test = impl;

        // when
        Integer[] elements = {1, 2, 3};

        // then
        assert test.addAll(Arrays.asList(elements)) : "failed the addAll for collection of elements";
    }

    public static void shouldContainElementsAfterAddAll(List impl) {
        // given
        List test = impl;

        // when
        Integer[] elements = {1, 2, 3};
        test.addAll(Arrays.asList(elements));

        // then
        assert test.containsAll(Arrays.asList(elements)) : "list doesn't contain added collection";
    }

    public static void shouldContainElementsAfterAddAllToNonEmptyList(List impl) {
        // given
        List test = impl;
        test.add(5);

        // when
        Integer[] elements = {1, 2, 3};
        test.addAll(Arrays.asList(elements));

        // then
        assert test.containsAll(Arrays.asList(elements)) : "list doesn't contain added collection";
    }

    public static void shouldAddElementsAtIndex(List impl) {
        // given
        List test = impl;
        test.add(1);
        test.add(2);
        test.add(5);

        // when
        Integer[] elements = {3, 4};
        test.addAll(2, Arrays.asList(elements));

        // then
        assert test.get(3).equals(4) : "insertion with addAll on position 2 failed";
    }

    public static void shouldRemoveAllSelectedElements(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));

        // when
        test.removeAll(Arrays.asList(new Integer[]{1, 3, 5}));

        // then
        assert !test.containsAll(Arrays.asList(new Integer[]{1, 3, 5})) : "list contains deleted elements";
    }

    public static void shouldContainTwoElementsAfterRemoveAll(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));

        // when
        test.removeAll(Arrays.asList(new Integer[]{1, 3, 5}));

        // then
        assert test.size() == 2 : "removeAll didn't remove 3 elements";
    }

    public static void shouldContainThreeElementsAfterRetainAllWhenAllInList(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));

        // when
        test.retainAll(Arrays.asList(new Integer[]{1, 3, 5}));

        // then
        assert test.size() == 3 : "different than 3 number of elements retained in the list";
    }

    public static void shouldContainTwoElementsAfterRetainAllWhenNotAllInList(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));

        // when
        test.retainAll(Arrays.asList(new Integer[]{1, 3, 7}));

        // then
        assert test.size() == 2 : "different than 2 number of elements retained in the list";
    }

    public static void shouldReplaceAllIntegersByFive(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));

        // when
        test.replaceAll(i -> 5);

        // then
        assert !test.containsAll(Arrays.asList(new Integer[]{1, 2, 3, 4})) : "replaceAll not applied to list implementation";
    }


    public static void shouldYieldZeroSizeAfterClear(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));

        // when
        test.clear();

        // then
        assert test.size() == 0 : "list size after clear different than zero";
    }

    public static void shouldYieldZeroSizeAfterClearOfEmptyList(List impl) {
        // given
        List test = impl;

        // when
        test.clear();

        // then
        assert test.size() == 0 : "list size after clear different than zero";
    }

    public static void shouldGiveElementFromPosition(List impl) {
        // given
        List test = impl;
        Object one = new Object();
        Object two = new Object();
        Object three = new Object();
        test.addAll(Arrays.asList(new Object[]{one, two, three}));

        // when
        Object second = test.get(1);

        // then
        assert second.equals(two) : "second element got from list different than two";
    }

    public static void shouldThrowIOBExceptionWhenListEmpty(List impl) {
        // given
        List test = impl;
        boolean thrown = false;

        // when
        try {
            Object myObj = test.get(0);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "IndexOutOfBoundsException not thrown after get from empty list";
    }

    public static void shouldThrowIOBExceptionWhenIndexNegative(List impl) {
        // given
        List test = impl;
        test.add(new Object());
        boolean thrown = false;

        // when
        try {
            Object myObj = test.get(-5);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "IndexOutOfBoundsException not thrown after get from empty list";
    }


    public static void shouldThrowIOBExceptionWhenSetOnEMptyList(List impl) {
        // given
        List test = impl;
        boolean thrown = false;

        // when
        try {
            test.set(0, 5);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "IndexOutOfBoundsException not thrown when set used on an empty list";
    }

    public static void shouldThrowIOBExceptionWhenSetWithNegativeIndex(List impl) {
        // given
        List test = impl;
        test.add(new Object());
        boolean thrown = false;

        // when
        try {
            test.set(-1, 5);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "IndexOutOfBoundsException not thrown when set used with negative index";
    }

    public static void shouldAddElementToEmptyListAtPositionZero(List impl) {
        // given
        List test = impl;

        // when
        test.add(0, 5);

        // then
        assert test.size() == 1 : "list size not equal to 1";
        assert test.get(0).equals(5) : "first element different than 5";
    }

    public static void shouldThrowIOBExceptionWhenAddElementToEmptyListAtPositionOne(List impl) {
        // given
        List test = impl;
        boolean thrown = false;

        // when
        try {
            test.add(1, 5);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        // then
        assert thrown : "IndexOutOfBoundsException not thrown on add at illegal position of empty list";
    }


    public static void shouldFindObjectAtPositionZero(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));

        // when
        int ind = test.indexOf(3);

        // then
        assert ind == 2 : "indexOf result differ from expected for element";
    }

    public static void shouldReturnMinusOneWhenNotFoundInList(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));

        // when
        int ind = test.indexOf(5);

        // then
        assert ind == -1 : "indexOf strangely found element absent in the list";
    }

    public static void shouldReturnIndexOfLastOccurenceOfANumber(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 1, 2, 3, 4}));

        // when
        int ind = test.lastIndexOf(2);

        // then
        assert ind == 3 : "index of last occurence different than expected";
    }

    public static void shouldReturnMinusOneWithLastIndexOfWhenNotInAList(List impl) {
        // given
        List test = impl;
        test.addAll(Arrays.asList(new Integer[]{1, 2, 1, 2, 3, 4}));

        // when
        int ind = test.lastIndexOf(5);

        // then
        assert ind == -1 : "index of last occurence different than -1 for element not in the list";
    }
}
