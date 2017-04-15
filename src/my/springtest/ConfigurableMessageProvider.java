package my.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 15.04.2017.
 */
@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
