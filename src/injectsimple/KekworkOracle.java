package injectsimple;

import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 18.04.2017.
 */
@Service("KekWorkOracle")
public class KekworkOracle implements Oracle {
    @Override
    public String getAdvice() {
        return "Drama for life";
    }
}
