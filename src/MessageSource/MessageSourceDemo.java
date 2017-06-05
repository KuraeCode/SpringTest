package MessageSource;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Created by artmaster on 23.05.2017.
 */
public class MessageSourceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/MessageSource/app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
       // Locale rus = new Locale("ru", "RU");

        System.out.println(ctx.getMessage("msg", null, english));
       // System.out.println(ctx.getMessage("msg", null, rus));

        System.out.println(ctx.getMessage("nameMsg", new Object[] {"Keker", "Without family"}, english));
    }
}
