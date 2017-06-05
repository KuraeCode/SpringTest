package aop.last_anno_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artmaster on 03.06.2017.
 */
public class AspectJAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopSetting.class);
        MyBean bean = (MyBean) context.getBean("myBean");
        bean.execute();
    }
}
