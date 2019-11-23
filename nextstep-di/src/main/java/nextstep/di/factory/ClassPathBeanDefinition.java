package nextstep.di.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClassPathBeanDefinition implements BeanDefinition {
    private static final Logger log = LoggerFactory.getLogger(ClassPathBeanDefinition.class);
    private Class<?> clazz;

    public ClassPathBeanDefinition(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object createBean(Object... parameters) {
        try {
            return clazz.getConstructor().newInstance(parameters);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Class<?>> getParameterTypes() {
        return null;
    }
}
