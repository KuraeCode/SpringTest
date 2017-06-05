package injectsimple;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by artmaster on 18.04.2017.
 */
public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle)
    {
        this.oracle = oracle;
    }

    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-config-anno.xml");
        ctx.refresh();
        InjectSimple ij = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(ij.toString());
    }
}
