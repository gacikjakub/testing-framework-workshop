package pl.gacik.testingFramewokTutorial.P4ensuringIndependenceOfTests.standard;

import pl.gacik.testingFramewokTutorial.P4ensuringIndependenceOfTests.standard.TestClass.Test;

public class SomeCrashingTests  {

    @Test
    public void A() {
        new String("This one is OK");
    }

    @Test
    public void B() {
        throw new IllegalArgumentException("It is probably bad example");
    }

    @Test
    public void C() {
        new String("This one is also OK");
    }

    @Test
    public void D() {
        throw new NullPointerException("Different Exception");
    }

}
