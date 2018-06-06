package pl.gacik.testingFramewokTutorial.P2executingTestMethods.reflection.exe2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsGuide {

    public static void main(String[] args) {
//        compareFields();
//        System.out.println();
//        compareMethods();
//        System.out.println();
//        compareConstructors();

//        invokeVarietyClassMethod();
//        invokeVarietyChildClassMethod();
    }

    private static void compareMethods() {
        System.out.println("VARIETY CLASS:");
        System.out.println("    METHODS:");
        printMethods(VarietyClass.class.getMethods());
        System.out.println("    DECLARED METHODS:");
        printMethods(VarietyClass.class.getDeclaredMethods());
        System.out.println();

        System.out.println("VARIETY CHILD CLASS:");
        System.out.println("    METHODS:");
        printMethods(VarietyChildClass.class.getMethods());
        System.out.println("    DECLARED METHODS:");
        printMethods(VarietyChildClass.class.getDeclaredMethods());
        System.out.println();
    }

    private static void compareConstructors() {
        System.out.println("VARIETY CLASS:");
        System.out.println("    CONSTRUCTORS:");
        printConstructors(VarietyClass.class.getConstructors());
        System.out.println("    DECLARED CONSTRUCTORS:");
        printConstructors(VarietyClass.class.getDeclaredConstructors());
        System.out.println();

        System.out.println("VARIETY CHILD CLASS:");
        System.out.println("    CONSTRUCTORS:");
        printConstructors(VarietyChildClass.class.getConstructors());
        System.out.println("    DECLARED CONSTRUCTORS:");
        printConstructors(VarietyChildClass.class.getDeclaredConstructors());
        System.out.println();
    }


    private static void compareFields() {
        System.out.println("VARIETY CLASS:");
        System.out.println("    FIELDS:");
        printFields(VarietyClass.class.getFields());
        System.out.println("    DECLARED FIELDS:");
        printFields(VarietyClass.class.getDeclaredFields());
        System.out.println();

        System.out.println("VARIETY CHILD CLASS:");
        System.out.println("    FIELDS:");
        printFields(VarietyChildClass.class.getFields());
        System.out.println("    DECLARED FIELDS:");
        printFields(VarietyChildClass.class.getDeclaredFields());
        System.out.println();
    }


    private static void printMethods(Method[] methods) {
        for (Method method : methods) {
            System.out.println("NAME: " + method.getName());
            System.out.println("RETURN TYPE: " + method.getReturnType().getSimpleName());
        }
    }


    private static void printFields(Field[] fields) {
        for (Field field: fields) {
            System.out.println("NAME: " + field.getName());
            System.out.println("RETURN TYPE: " + field.getType().getSimpleName());
        }
    }

    private static void printConstructors(Constructor[] constructors) {
        for (Constructor constructor: constructors) {
            System.out.println("NAME: " + constructor);
        }
    }


    private static void invokeVarietyClassMethod() {
        System.out.println("VARIETY CLASS:");
        System.out.println("    INVOKING DECLARED METHODS:");
        VarietyClass varietyClass = new VarietyClass();
        for (Method method : varietyClass.getClass().getDeclaredMethods()) {
            try {
                method.invoke(varietyClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage() + " during execute method " + method.getName());
            }
        }
    }

    private static void invokeVarietyChildClassMethod() {
        System.out.println("VARIETY CHILD CLASS:");
        System.out.println("    INVOKING DECLARED METHODS:");
        VarietyChildClass varietyChildClass = new VarietyChildClass();
        for (Method method : varietyChildClass.getClass().getDeclaredMethods()) {
            try {
                method.invoke(varietyChildClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage() + " during execute method " + method.getName());
            }
        }
    }

}
