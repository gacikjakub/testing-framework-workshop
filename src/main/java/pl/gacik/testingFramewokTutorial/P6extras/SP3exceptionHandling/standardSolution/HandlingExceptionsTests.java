package pl.gacik.testingFramewokTutorial.P6extras.SP3exceptionHandling.standardSolution;



public class HandlingExceptionsTests extends TestClass {

    @Test
    public void methodWhichThrowExpectedException() {
        System.out.println("I'm in methodWhichThrowExpectedException");
        boolean wasCaught = false;
        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            wasCaught = true;
        }
        SoftAssert.assertTrue(wasCaught,"Expected exception has not been caught");
    }

}
