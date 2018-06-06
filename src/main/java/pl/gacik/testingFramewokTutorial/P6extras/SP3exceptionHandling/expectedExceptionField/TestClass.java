package pl.gacik.testingFramewokTutorial.P6extras.SP3exceptionHandling.expectedExceptionField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClass {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}

    // Refactor this so that it works properly.

    public static void runClassTests(Object o) {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        BeforeAfter beforeAfter = new BeforeAfter(o);
        try {
            beforeAfter.getBeforeClass().invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return;
        }
        Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
            try {
                beforeAfter.getBeforeMethod().invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return;
            }
            try {
                m.invoke(o);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            try {
                beforeAfter.getAfterMethod().invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return;
            }
            });
        try {
            beforeAfter.getAfterClass().invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return;
        }

    }

    public static void main(String[] args) {
        runClassTests(new HandlingExceptionsTests());
    }

}


