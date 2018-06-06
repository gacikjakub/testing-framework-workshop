package pl.gacik.testingFramewokTutorial.P6extras.SP3exceptionHandling.standardSolution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

class BeforeAfter {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BeforeClass {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AfterClass {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BeforeMethod {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AfterMethod {}



    public Method getBeforeClass() {
        return beforeClass;
    }

    public Method getAfterClass() {
        return afterClass;
    }

    public Method getBeforeMethod() {
        return beforeMethod;
    }

    public Method getAfterMethod() {
        return afterMethod;
    }

    private Method beforeClass;
    private Method afterClass;
    private Method beforeMethod;
    private Method afterMethod;

    static void emptyMethod() {}

    {
        try {
            beforeClass = BeforeAfter.class.getDeclaredMethod("emptyMethod");
            afterClass = BeforeAfter.class.getDeclaredMethod("emptyMethod");
            beforeMethod = BeforeAfter.class.getDeclaredMethod("emptyMethod");
            afterMethod = BeforeAfter.class.getDeclaredMethod("emptyMethod");
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public BeforeAfter(Object o) {
        Optional<Method> beforeClass = Arrays.stream(o.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(BeforeClass.class)).findFirst();
        beforeClass.ifPresent(method -> this.beforeClass = method);
        Optional<Method> afterClass = Arrays.stream(o.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(AfterClass.class)).findFirst();
        afterClass.ifPresent(method -> this.afterClass = method);
        Optional<Method> beforeMethod = Arrays.stream(o.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(BeforeMethod.class)).findFirst();
        beforeMethod.ifPresent(method -> this.beforeMethod = method);
        Optional<Method> afterMethod = Arrays.stream(o.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(AfterMethod.class)).findFirst();
        afterMethod.ifPresent(method -> this.afterMethod = method);
    }

}
