package injectsimple;

import org.springframework.stereotype.Component;

/**
 * Created by artmaster on 18.04.2017.
 */
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name = "John Doe";
    private int age = 35;
    private float height = 1.78f;
    private boolean programmer = true;
    private Long ageInSeconds = 1103760000L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
