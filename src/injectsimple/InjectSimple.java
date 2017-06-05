package injectsimple;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 18.04.2017.
 */
@Service("injectSimple")
public class InjectSimple {

    private Oracle oracle;

    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSecond;

    @Autowired
    public InjectSimple(@Qualifier("KekWorkOracle") Oracle oracle)
    {
        this.oracle = oracle;
    }


    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSecond=" + ageInSecond +
                ", advice=" + oracle.getAdvice() +'}';
    }

}
