package nextstep.di.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ConfigurationDefinition implements BeanDefinition {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationDefinition.class);

    private Method method;
    private Class<?> clazz;

    public ConfigurationDefinition(Method method, Class<?> clazz) {
        this.method = method;
        this.clazz = clazz;
    }

    //TODO DataSource 만들 때 에러 생김
    @Override
    public Object createBean(Object... parameters) {
        try {
            return method.invoke(clazz, parameters);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Class<?>> getParameterTypes() {
        return Arrays.asList(method.getParameterTypes());
    }
}
