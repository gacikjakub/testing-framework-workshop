package pl.gacik.testingFramewokTutorial.P7popularTestingFrameworks.compare.ownFramework;

import static pl.gacik.testingFramewokTutorial.P7popularTestingFrameworks.compare.ownFramework.TestClass.runClassTests;

public class TestRunner {

    public static void main(String[] args) {
        runClassTests(new ListTests());
    }
}
