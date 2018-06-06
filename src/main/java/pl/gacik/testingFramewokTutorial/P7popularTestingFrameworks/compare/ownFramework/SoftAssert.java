package pl.gacik.testingFramewokTutorial.P7popularTestingFrameworks.compare.ownFramework;

public class SoftAssert {

    private static void printThrowable(Throwable t) {
        if (t!=null) {
            t.printStackTrace();
            System.err.println();
        }
    }

    public static void assertTrue(boolean condition, String failMessage) {
        try {
            assert condition : failMessage;
        } catch (Throwable t) {
           printThrowable(t);
        }
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "The specified condition is not met");
    }

    public static void assertFalse(boolean condition, String failMessage) {
        try {
            assert !condition : failMessage;
        } catch (Throwable t) {
            printThrowable(t);
        }
    }

    public static void assertFalse(boolean condition) {
        assertFalse(condition, "The specified condition is not met");
    }


    public static <T> void assertEquals(T o1, T o2, String failMessage) {
        try {
            assert o1.equals(o2) : failMessage;
        } catch (Throwable t) {
            printThrowable(t);
        }
    }

    public static <T> void assertEquals(T o1, T o2) {
        assertEquals(o1,o2,"Given objects are not equal");
    }

    public static void fail() {
        fail("Forced fail");
    }

    public static void fail(String failMessage) {
        assert false : failMessage;
    }

}
