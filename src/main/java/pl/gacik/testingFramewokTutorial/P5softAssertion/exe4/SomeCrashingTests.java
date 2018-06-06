package pl.gacik.testingFramewokTutorial.P5softAssertion.exe4;

public class SomeCrashingTests extends TestClass {

    @Test
    public void A() {
        System.out.println("BEGINNING");
        SoftAssert.assertion(true, "Redundant");
        System.out.println("NOW WILL BE FAIL");
        SoftAssert.assertion(false, "Assert false is always failed");
        System.out.println("THIS MESSAGE IS BETWEEN ASSERTION - NOW WILL BE AGAIN PASS");
        SoftAssert.assertion(true, "Redundant");
    }



}
