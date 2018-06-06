package pl.gacik.testingFramewokTutorial.P2executingTestMethods.inMainList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListImplementationsTest {

    public static void main(String[] args) {
        runListInterfaceTests(new ArrayList());
        runListInterfaceTests(new LinkedList());
    }

    private static void runListInterfaceTests(List listImpl) {
        // size
        ListInterfaceTest.shouldGiveZeroSize(listImpl); listImpl.clear();
        ListInterfaceTest.shouldGiveSizeOfOne(listImpl); listImpl.clear();
        ListInterfaceTest.shouldGiveZeroSizeAfterAdditionAndRemoval(listImpl); listImpl.clear();

        // isEmpty
        ListInterfaceTest.shouldReturnTrueForEmpty(listImpl); listImpl.clear();
        ListInterfaceTest.shouldReturnFalseForNonEmpty(listImpl); listImpl.clear();

        // contains
        ListInterfaceTest.shouldNotContainNumber(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainNumber(listImpl); listImpl.clear();

        // toArray
        ListInterfaceTest.shouldProduceEmptyArray(listImpl); listImpl.clear();
        ListInterfaceTest.shouldProduceArrayWith3Integers(listImpl); listImpl.clear();

        // add
        ListInterfaceTest.shouldAddElementToList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldAddTheSameElementToList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldAddElementToEmptyListAtPositionZero(listImpl); listImpl.clear();
        ListInterfaceTest.shouldThrowIOBExceptionWhenAddElementToEmptyListAtPositionOne(listImpl); listImpl.clear();

        // remove
        ListInterfaceTest.shouldRemoveObjectFromList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldRemoveElementByIndex(listImpl); listImpl.clear();
        ListInterfaceTest.shouldNotRemoveObjectFromListWhenAbsent(listImpl); listImpl.clear();
        ListInterfaceTest.shouldNotRemoveFromWrongIndexPosition(listImpl); listImpl.clear();

        // containsAll
        ListInterfaceTest.shouldContainAllCollection(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainSubcollection(listImpl); listImpl.clear();
        ListInterfaceTest.shouldNotContainCollection(listImpl); listImpl.clear();

        // addAll
        ListInterfaceTest.shouldAddAllElements(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainElementsAfterAddAll(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainElementsAfterAddAllToNonEmptyList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldAddElementsAtIndex(listImpl); listImpl.clear();

        // removeAll
        ListInterfaceTest.shouldRemoveAllSelectedElements(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainTwoElementsAfterRemoveAll(listImpl); listImpl.clear();

        // retainAll
        ListInterfaceTest.shouldContainThreeElementsAfterRetainAllWhenAllInList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldContainTwoElementsAfterRetainAllWhenNotAllInList(listImpl); listImpl.clear();

        // replaceAll
        ListInterfaceTest.shouldReplaceAllIntegersByFive(listImpl); listImpl.clear();

        // clear
        ListInterfaceTest.shouldYieldZeroSizeAfterClear(listImpl); listImpl.clear();
        ListInterfaceTest.shouldYieldZeroSizeAfterClearOfEmptyList(listImpl); listImpl.clear();

        // get
        ListInterfaceTest.shouldGiveElementFromPosition(listImpl); listImpl.clear();
        ListInterfaceTest.shouldThrowIOBExceptionWhenListEmpty(listImpl); listImpl.clear();
        ListInterfaceTest.shouldThrowIOBExceptionWhenIndexNegative(listImpl); listImpl.clear();

        // set
        ListInterfaceTest.shouldThrowIOBExceptionWhenSetOnEMptyList(listImpl); listImpl.clear();
        ListInterfaceTest.shouldThrowIOBExceptionWhenSetWithNegativeIndex(listImpl); listImpl.clear();

        // indexOf
        ListInterfaceTest.shouldFindObjectAtPositionZero(listImpl); listImpl.clear();
        ListInterfaceTest.shouldReturnMinusOneWhenNotFoundInList(listImpl); listImpl.clear();

        // lastIndexOf
        ListInterfaceTest.shouldReturnIndexOfLastOccurenceOfANumber(listImpl); listImpl.clear();
        ListInterfaceTest.shouldReturnMinusOneWithLastIndexOfWhenNotInAList(listImpl); listImpl.clear();
    }
}