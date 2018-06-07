package pl.gacik.testingFramewokTutorial.P6extras.SP2beforeAfter;

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



    public static void runClassTests(Object o) {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        BeforeAfter beforeAfter = new BeforeAfter(o);
        // Here you need something
        Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
            // And Here
            try {
                m.invoke(o);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            // And Here
            });
        // And Here

    }

    public static void main(String[] args) {
        runClassTests(new BeforeAfterTests());
    }

}


