package classconf;


import my.springtest.ConfigurableMessageProvider;
import my.springtest.MessageProvider;
import my.springtest.MessageRenderer;
import my.springtest.StandartOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by artmaster on 25.05.2017.
 */
@Configuration
@PropertySource(value = "classpath:classconf/message.properties")
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("msg"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandartOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }
}
