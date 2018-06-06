package pl.gacik.testingFramewokTutorial.P6extras.SP1softAssertionExtended.exe5;

public class SomeCrashingTests extends TestClass {

    @Test
    public void assertTrueTest() {
        SoftAssert.assertTrue(true, "Condition should be true but it is not");
        SoftAssert.assertTrue(true);
        SoftAssert.assertTrue(false, "It is always failed");
        SoftAssert.assertTrue(false);
    }

    @Test
    public void assertFalseTest() {
        SoftAssert.assertFalse(false, "Condition should be false but it is not");
        SoftAssert.assertFalse(false);
        SoftAssert.assertFalse(true, "It is always failed");
        SoftAssert.assertFalse(true);
    }


    @Test
    public void assertEqualsTest() {
        Integer a1 = 5;
        Integer a2 = new Integer(5);
        SoftAssert.assertEquals(a1,a2, "Integers Not Equal");
        SoftAssert.assertEquals(a1,a2);
        a2 = 6;
        SoftAssert.assertEquals(a1,a2, "Integers Not Equal");
        SoftAssert.assertEquals(a1,a2);

        String s1 = "MasterOfPuppets";
        String s2 = new String("MasterOfPuppets");
        SoftAssert.assertEquals(s1,s2, "Strings Not Equal");
        SoftAssert.assertEquals(s1,s2);
        s2 = "Different phrase";
        SoftAssert.assertEquals(s1,s2, "Strings Not Equal");
        SoftAssert.assertEquals(s1,s2);
    }


    @Test
    public void assertFailtest() {
      try {
          SoftAssert.fail();
      }
      catch (Throwable t) {
          t.printStackTrace();
      }
    }

}
