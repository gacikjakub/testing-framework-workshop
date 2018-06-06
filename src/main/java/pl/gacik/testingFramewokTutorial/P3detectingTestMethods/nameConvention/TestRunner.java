package pl.gacik.testingFramewokTutorial.P3detectingTestMethods.nameConvention;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestRunner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for( Method method: ListTests.class.getDeclaredMethods()) {
            if (!method.getName().equals("main") && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())
                    && (method.getName().toLowerCase().startsWith("test") || method.getName().toLowerCase().endsWith("test"))) {
//                System.out.println(method.getName());
                ListTests.setUpArrayList();
                method.invoke(null);
                ListTests.setUpLinkedList();
                method.invoke(null);
            }
        }
    }
}
