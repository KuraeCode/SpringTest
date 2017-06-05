package aop.firstTry;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by artmaster on 26.05.2017.
 */
public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter targer = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(targer);

        MessageWriter proxy = (MessageWriter) pf.getProxy();
        targer.writeAnotherMessage();

        System.out.println("");
        proxy.writeAnotherMessage();
    }
}
