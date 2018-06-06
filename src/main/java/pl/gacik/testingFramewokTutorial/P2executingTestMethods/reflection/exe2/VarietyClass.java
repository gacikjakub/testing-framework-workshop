package pl.gacik.testingFramewokTutorial.P2executingTestMethods.reflection.exe2;

public class VarietyClass {

    public int integer = 20;

    protected Long longValue = 100L;

    boolean packagePrivate = false;

    private OwnType ownType = new OwnType();

    class OwnType {
        public String showURL() {
            return "https://www.youtube.com/watch?v=on9TXY8kYyk";
        }
    }

    public OwnType getOwnType() {
        return ownType;
    }

    protected Long getLong() {
        return longValue;
    }

    private int getInteger() {
        return integer;
    }

    boolean getPackagePrivate() {
        return packagePrivate;
    }

}
