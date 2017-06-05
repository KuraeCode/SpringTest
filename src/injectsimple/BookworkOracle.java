package injectsimple;

import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 18.04.2017.
 */
@Service("bookworkmoracleservice")
public class BookworkOracle implements Oracle {
    @Override
    public String getAdvice() {
        return "kek is fucking shit";
    }
}
