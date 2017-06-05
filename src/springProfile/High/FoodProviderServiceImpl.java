package springProfile.High;

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
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Coke"));
        foodList.add(new Food("Hamburger"));
        foodList.add(new Food("French Fries"));
        return foodList;
    }
}
