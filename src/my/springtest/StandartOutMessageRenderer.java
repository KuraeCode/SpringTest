package my.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by artmaster on 13.04.2017.
 */
@Service("messageRenderer")
public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null)
            throw new RuntimeException("You must set the property messageProvider of class:" + StandartOutMessageRenderer.class.getName() );
        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
