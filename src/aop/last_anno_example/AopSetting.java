package aop.last_anno_example;

import org.springframework.context.annotation.*;

/**
 * Created by artmaster on 03.06.2017.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop.last_anno_example")
public class AopSetting {

    @Bean("myAdvice")
    public MyAdvice myAdvice() {
        return new MyAdvice();
    }

    @Lazy
    @Bean(value = "myDependency")
    public MyDependency myDependency() {
        return new MyDependency();
    }

    @Bean
    @DependsOn(value = "myDependency")
    public MyBean myBean() {
        return new MyBean();
    }


}
