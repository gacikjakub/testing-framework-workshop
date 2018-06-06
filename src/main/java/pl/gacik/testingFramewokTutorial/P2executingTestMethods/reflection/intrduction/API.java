package pl.gacik.testingFramewokTutorial.P2executingTestMethods.reflection.intrduction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class API {

    // Class
    Class simpleClass = IndexOutOfBoundsException.class;
    List<Class> listOfAllClasses = new LinkedList<>();

    Class<? extends IOException> ioExceptionClass = FileNotFoundException.class;
    // Class<? extends IOException> badCasting = NullPointerException.class;


    Field field;            // in java.lang.reflect - SO SURPRISING O.O;


    Method method;        // again in java.lang.reflect ?!?!?!! - like James Artur sings - IMPOSIBLEEEEUEEEUEEE

    public API() throws NoSuchFieldException, NoSuchMethodException {
        this.field = getClass().getField("simpleClass");
        this.method = getClass().getMethod("toString");
    }

    // TUTORIAL - http://www.oracle.com/technetwork/articles/java/javareflection-1536171.html
}
