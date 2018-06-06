package pl.gacik.testingFramewokTutorial.P5softAssertion.without;


public class SomeCrashingTests extends TestClass {

    @Test
    public void A() {
        System.out.println("BEGINNING");
        assert true : "Redundant";
        System.out.println("NOW WILL BE FAIL");
        assert false : "Assert false is always failed";
        System.out.println("THIS MESSAGE IS BETWEEN ASSERTION - NOW WILL BE AGAIN PASS");
        assert true : "Redundant";
    }



}
