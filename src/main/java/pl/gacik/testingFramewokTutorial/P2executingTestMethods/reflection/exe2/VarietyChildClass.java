package pl.gacik.testingFramewokTutorial.P2executingTestMethods.reflection.exe2;

public class VarietyChildClass extends VarietyClass {

    private String getAnotherGoodSong() {
        return anotherGoodSong;
    }

    protected byte getMagicNumber() {
        return magicNumber;
    }

    Nested getNested() {
        return nested;
    }

    Nested nested = new Nested();


    public String anotherGoodSong = "https://www.youtube.com/watch?v=_CL6n0FJZpk";

    protected byte magicNumber = 0x45;

    public float getPi() {
        return Pi;
    }

    private float Pi = 3.14f;

    private class Nested {
        char packageChar = '#';
    }

}
