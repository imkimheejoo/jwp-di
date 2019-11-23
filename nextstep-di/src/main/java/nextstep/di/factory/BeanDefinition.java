package nextstep.di.factory;

import java.util.List;

public interface BeanDefinition {
    Object createBean(Object ...parameters);
    List<Class<?>> getParameterTypes();
}
