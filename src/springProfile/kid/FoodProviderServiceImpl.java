package springProfile.kid;

import org.springframework.stereotype.Service;
import springProfile.Food;
import springProfile.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artmaster on 25.05.2017.
 */
@Service("foodProvider")
public class FoodProviderServiceImpl implements FoodProviderService {

    public FoodProviderServiceImpl() {
    }

    @Override
    public List<Food> providerLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("milk"));
        lunchSet.add(new Food("biscuit"));
        return lunchSet;
    }
}
