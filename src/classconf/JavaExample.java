package classconf;

import my.springtest.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artmaster on 25.05.2017.
 */
public class JavaExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer renderer = (MessageRenderer) context.getBean("messageRenderer");
        renderer.render();
    }
}
