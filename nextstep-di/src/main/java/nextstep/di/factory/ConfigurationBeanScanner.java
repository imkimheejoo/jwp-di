package nextstep.di.factory;

import nextstep.annotation.Bean;
import nextstep.annotation.Configuration;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigurationBeanScanner {
    private Class<?> configurationClass;
    private Reflections reflections;

    public ConfigurationBeanScanner(Class<?> configurationClass, String packagePath) {
        this.configurationClass = configurationClass;
        this.reflections = new Reflections(packagePath);
    }

    public Map<Class<?>, BeanDefinition> scanBeanInfo() {
        Map<Class<?>, BeanDefinition> methods = new HashMap<>();
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Configuration.class);

        for (Class<?> t : typesAnnotatedWith) {
            methods.putAll(Arrays.stream(t.getMethods()).filter(m -> m.isAnnotationPresent(Bean.class))
                    .collect(Collectors.toMap(Method::getReturnType, m -> new ConfigurationDefinition(m, t))));
        }

        return methods;
    }
}
