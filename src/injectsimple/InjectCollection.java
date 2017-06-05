package injectsimple;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by artmaster on 20.04.2017.
 */
@Service("injectCollection")
public class InjectCollection {

    @Resource(name = "map")
    private Map<String, Object> map;

    @Resource(name = "list")
    private List<Object> list;

}
