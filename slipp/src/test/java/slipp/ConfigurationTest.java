package slipp;

import nextstep.di.factory.BeanFactory2;
import nextstep.di.factory.ConfigurationBeanScanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigurationTest {
    private BeanFactory2 beanFactory;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setup() {
        String path = "slipp";
        ConfigurationBeanScanner beanScanner = new ConfigurationBeanScanner(MyConfiguration.class, "slipp");
        beanFactory = new BeanFactory2(new HashMap<>(), beanScanner.scanBeanInfo());
        beanFactory.initialize();
    }

    @Test
    public void register_simple() {
        ConfigurationBeanScanner beanScanner = new ConfigurationBeanScanner(MyConfiguration.class, "slipp");
        beanFactory = new BeanFactory2(new HashMap<>(), beanScanner.scanBeanInfo());
        beanFactory.initialize();

        assertNotNull(beanFactory.getBean(DataSource.class));
    }
}

