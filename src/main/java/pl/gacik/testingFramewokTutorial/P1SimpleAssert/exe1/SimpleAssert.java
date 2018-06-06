package pl.gacik.testingFramewokTutorial.P1SimpleAssert.exe1;

public class SimpleAssert {

    public static void assertion(boolean condition, String failMessage) {
        if (!condition) {
            throw new AssertionError(failMessage);
        }
    }

    public static void main(String[] args) {
        assertion(false, "Sth wrong");
    }

}
