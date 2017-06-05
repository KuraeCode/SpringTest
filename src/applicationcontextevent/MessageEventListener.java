package applicationcontextevent;

import org.springframework.context.ApplicationListener;

/**
 * Created by artmaster on 23.05.2017.
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println(messageEvent.getMessage());
    }
}
