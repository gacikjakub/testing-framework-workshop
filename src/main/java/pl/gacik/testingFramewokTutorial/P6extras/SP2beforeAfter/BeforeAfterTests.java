package pl.gacik.testingFramewokTutorial.P6extras.SP2beforeAfter;


import pl.gacik.testingFramewokTutorial.P6extras.SP2beforeAfter.BeforeAfter.*;


public class BeforeAfterTests extends TestClass {


    @BeforeClass
    public void beforeClass() {
        System.out.println("I'm in beforeClass method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I'm in afterClass method");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I'm in beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I'm in afterMethod");
    }

    @Test
    public void A() {
        System.out.println("I'm in test A");
    }

    @Test
    public void B() {
        System.out.println("I'm in test B");
    }

    @Test
    public void C() {
        System.out.println("I'm in test C");
    }



}
