package anotherconfstyle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by artmaster on 17.05.2017.
 */
public class SimpleBeanWithInterface {

    private String name;
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private int age = Integer.MAX_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myInit() {
        System.out.println("My Init");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + SimpleBeanWithInterface.class);
        }

    }

    @Override
    public String toString() {
        return "SimpleBeanWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:anotherconfstyle/META-INF/app-context-xml.xml");
        ctx.refresh();

        SimpleBeanWithInterface simpleBeanWithInterface = getBean("simpleBean1", ctx);
        SimpleBeanWithInterface simpleBeanWithInterface1 = getBean("simpleBean2", ctx);
        SimpleBeanWithInterface simpleBeanWithInterface2 = getBean("simpleBean3", ctx);

    }

    private static SimpleBeanWithInterface getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBeanWithInterface bean =
                    (SimpleBeanWithInterface) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean conf: " + ex.getMessage());
            return null;
        }
    }
}