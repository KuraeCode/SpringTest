package lookupdemo;

/**
 * Created by artmaster on 01.05.2017.
 */
public class StandartLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }
}
