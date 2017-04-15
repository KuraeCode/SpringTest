package my.springtest;

import org.springframework.context.annotation.Bean;

/**
 * Created by artmaster on 13.04.2017.
 */
public interface MessageRenderer {


    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();
}
