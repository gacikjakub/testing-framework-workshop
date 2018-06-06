package pl.gacik.testingFramewokTutorial.P3detectingTestMethods.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        runClassTests(new ListTests());
    }

    public static void runClassTests(Object o) {
       // Write detecting and executing test methods with the use of annotations.
    }

}
