package my.springtest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 13.04.2017.
 */
//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Hello World";
    }
}
