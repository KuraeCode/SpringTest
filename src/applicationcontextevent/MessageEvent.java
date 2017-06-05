package applicationcontextevent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by artmaster on 23.05.2017.
 */
public class MessageEvent extends ApplicationEvent {

    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
