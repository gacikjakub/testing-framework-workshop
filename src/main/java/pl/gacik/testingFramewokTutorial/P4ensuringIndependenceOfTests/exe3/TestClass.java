package pl.gacik.testingFramewokTutorial.P4ensuringIndependenceOfTests.exe3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClass {



    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}

    public static void runClassTests(Object o) {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
            System.out.println(m.getName());
            try {
                m.invoke(o);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        runClassTests(new SomeCrashingTests());
    }

}
