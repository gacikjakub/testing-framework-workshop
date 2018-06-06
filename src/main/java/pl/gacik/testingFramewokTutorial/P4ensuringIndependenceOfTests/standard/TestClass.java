package pl.gacik.testingFramewokTutorial.P4ensuringIndependenceOfTests.standard;

import pl.gacik.testingFramewokTutorial.P3detectingTestMethods.annotations.ListTests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TestClass {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}

    public static void main(String[] args) {
        runClassTests(new SomeCrashingTests());
    }

    public static void runClassTests(Object o) {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
            System.out.println(m.getName());                // IT'S IMPORTANT
            try {
                m.invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
