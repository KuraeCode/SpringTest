package springProfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artmaster on 25.05.2017.
 */
public class JavaProfileExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.getEnvironment().setActiveProfiles("kid");
        configApplicationContext.register(JavaHighConfig.class, JavaKidConfig.class);
        configApplicationContext.refresh();
        FoodProviderService foodProviderService = configApplicationContext.getBean("foodProvider", FoodProviderService.class);

        foodProviderService.providerLunchSet().forEach(System.out::println);
    }
}
