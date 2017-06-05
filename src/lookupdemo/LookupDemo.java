package lookupdemo;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by artmaster on 02.05.2017.
 */
public class LookupDemo {
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lookupdemo/app-context-xml.xml");
        ctx.refresh();

        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean standartBean = (DemoBean) ctx.getBean("standartLookupBean");

        displayInfo(abstractBean);
        displayInfo(standartBean);


    }

    public static void displayInfo(DemoBean bean)
    {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper Instance the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("lookupDemo");

        for (int i = 0; i < 100000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
