package pl.gacik.testingFramewokTutorial.P6extras.SP3exceptionHandling.expectedExceptionField;


public class HandlingExceptionsTests extends TestClass {


    @Test(expectedException = IndexOutOfBoundsException.class)
    public void methodWhichThrowExpectedException() {
        System.out.println("I'm in methodWhichThrowExpectedException");
        throw new IndexOutOfBoundsException();
    }

    @Test(expectedException = IndexOutOfBoundsException.class)
    public void methodWhichThrowNotExpectedException() throws NoSuchMethodException {
        System.out.println("I'm in methodWhichThrowNotExpectedException");
        throw new NoSuchMethodException();
    }

    @Test
    public void methodWhichThrowButNoOneIsExpected() {
        System.out.println("I'm in methodWhichThrowButNoOneIsExpected");
        throw new IndexOutOfBoundsException();
    }

    @Test(expectedException = IndexOutOfBoundsException.class)
    public void methodWhichNotThrowButSomeOneIsExpected() {
        System.out.println("I'm in methodWhichNotThrowButSomeOneIsExpected");
    }

    @Test
    public void methodWhichNotThrowAndnoOneIsExpected() {
        System.out.println("I'm in methodWhichNotThrowAndNoOneIsExpected");
    }



}
