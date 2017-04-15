
import my.springtest.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by artmaster on 13.04.2017.
 */
public class HelloWorld {

    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-config.xml");
        ctx.refresh();
        MessageRenderer mr = ctx.getBean("messageRenderer", MessageRenderer.class);
        mr.render();
    }

}
