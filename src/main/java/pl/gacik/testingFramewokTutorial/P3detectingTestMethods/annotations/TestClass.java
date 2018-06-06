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

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}

    public static void main(String[] args) {
        runClassTests(new ListTests());
    }

    public static void runClassTests(Object o) {
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
            Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
                try {
//                    System.out.println(m.getName());
                    m.invoke(o, new ArrayList<>());                             // Still bad solution
                    m.invoke(o, new LinkedList<>());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
    }

}
