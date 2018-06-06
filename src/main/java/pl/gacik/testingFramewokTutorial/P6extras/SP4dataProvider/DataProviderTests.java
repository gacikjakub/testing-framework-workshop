package pl.gacik.testingFramewokTutorial.P6extras.SP4dataProvider;

import pl.gacik.testingFramewokTutorial.P6extras.SP4dataProvider.DataProvideManager.DataProvider;


public class DataProviderTests extends TestClass {

    @DataProvider(name = "3StringsPackage")
    public Object[][] stringsProvider() {
        return new Object[][] {{"Package1-String1", "Package1-String2"}, {"Package2-String1", "Package2-String2"}, {"Package3-String1", "Package3-String2"}};
    }

    @Test(dataProvider = "3StringsPackage")
    public void shouldPrintAllValues(String s1, String s2) {
        System.out.println("String1: " + s1);
        System.out.println("String2: " + s2);
    }

}
