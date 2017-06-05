package springProfile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springProfile.High.FoodProviderServiceImpl;

/**
 * Created by artmaster on 25.05.2017.
 */
@Configuration
@Component
@Profile("high")
public class JavaHighConfig {

    @Bean
    public FoodProviderService foodProvider() {
        return new FoodProviderServiceImpl();
    }
}
