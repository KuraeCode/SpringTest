package aop.last_anno_example;

import org.springframework.stereotype.Component;

/**
 * Created by artmaster on 02.06.2017.
 */
public class MyDependency {

    public void foo(int intValue) {
        System.out.println("foo(int):" + intValue);
    }

    public void bar() {
        System.out.println("bar()");
    }
}
