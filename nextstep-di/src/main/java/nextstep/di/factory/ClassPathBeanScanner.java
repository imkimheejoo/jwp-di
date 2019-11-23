package nextstep.di.factory;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClassPathBeanScanner {
    private static final Logger log = LoggerFactory.getLogger(ClassPathBeanScanner.class);

    private Reflections reflections;
    private List<Class> annotations;

    public ClassPathBeanScanner(List<Class> annotations, Object... basePackage) {
        this.annotations = annotations;
        this.reflections = new Reflections(basePackage);
    }
}
