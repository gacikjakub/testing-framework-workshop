package pl.gacik.testingFramewokTutorial.P6extras.SP4dataProvider;

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
    public @interface Test {
        Class<? extends Throwable> expectedException() default DefaultEmptyException.class;
        String dataProvider() default "";
    }


    private static class DefaultEmptyException extends Exception {
        DefaultEmptyException() {
            super();
        }
    }

    public static class NoExpectedException extends Exception {
        public NoExpectedException() {
            super();
        }
        public NoExpectedException(String s) {
            super(s);
        }
    }


    public static void runClassTests(Object o) {

        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        BeforeAfter beforeAfter = new BeforeAfter(o);
        DataProvideManager dataProvideManager = new DataProvideManager(o);
        try {
            beforeAfter.getBeforeClass().invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return;
        }
        Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Test.class)).forEach(m -> {
                Class<? extends Throwable> expectedException = DefaultEmptyException.class;
                Object[][] providerParams = new Object[][] {new Object[] {}};
                try {
                    Test annotation = m.getAnnotation(Test.class);
                    if (annotation.expectedException() != DefaultEmptyException.class) {
                        expectedException = annotation.expectedException();
                    }
                    if (!annotation.dataProvider().equals("")) {
                        if (dataProvideManager.getDataProvider(annotation.dataProvider()).isPresent()) {
                            providerParams = dataProvideManager.getDataProvider(annotation.dataProvider()).get();
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                    return;
                }
                for(Object[] params: providerParams) {
                    try {
                        beforeAfter.getBeforeMethod().invoke(o);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return;
                    }
                    try {
                        m.invoke(o, params);
                        if (!expectedException.isInstance(new DefaultEmptyException())) {
                            throw new NoExpectedException();
                        }
                    } catch (InvocationTargetException e) {
                        if (!expectedException.isInstance(e.getTargetException())) {
                            e.addSuppressed(new NoExpectedException());
                            e.printStackTrace();
                        }
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                    try {
                        beforeAfter.getAfterMethod().invoke(o);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return;
                    }
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
        runClassTests(new DataProviderTests());
    }

}


