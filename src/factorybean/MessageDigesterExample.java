package factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by artmaster on 22.05.2017.
 */
public class MessageDigesterExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/factorybean/app-context-xml.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }
}
