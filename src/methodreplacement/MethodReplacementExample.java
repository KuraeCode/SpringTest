package methodreplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by artmaster on 03.05.2017.
 */
public class MethodReplacementExample {

    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:methodreplacement/app-context.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");

        ReplacementTarget standartTarget = (ReplacementTarget) ctx.getBean("standartTarget");

        displayInfo(replacementTarget);
        displayInfo(standartTarget);
    }

    private static void displayInfo(ReplacementTarget replacementTarget)
    {
        System.out.println(replacementTarget.formatMessage("Hello world"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int i = 0; i < 100000000; i++) {
            String out = replacementTarget.formatMessage("foo");
        }
        stopWatch.stop();

        System.out.println("100000000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
