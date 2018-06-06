package pl.gacik.testingFramewokTutorial.P5softAssertion.exe4;

public class SoftAssert {

    public static void assertion(boolean condition, String failMessage) {
        try {
            assert condition : failMessage;
        } catch (Throwable t) {
            System.err.println(t);
            t.printStackTrace();
            System.err.println();
        }
    }

}
