package pl.gacik.testingFramewokTutorial.P7popularTestingFrameworks.compare.ownFramework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataProvideManager {

    private Map<String, Method> dataProvidersMap = new HashMap<>();

    private Object base;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DataProvider {
        String name();
    }

    static Object[][] noParam() {
        return new Object[][] {};
    }

    DataProvideManager(Object o) {
        this.base = o;
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        try {
            dataProvidersMap.put("", getClass().getDeclaredMethod("noParam"));
            Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(DataProvider.class)).forEach(m -> {
                DataProvider dataProvider = m.getAnnotation(DataProvider.class);
                dataProvidersMap.put(dataProvider.name(),m);
            });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return;
        }
    }

    public Optional<Object[][]> getDataProvider(String name) {
        Object[][] result = null;
        try {
            result = (Object[][]) dataProvidersMap.get(name).invoke(this.base);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

}
