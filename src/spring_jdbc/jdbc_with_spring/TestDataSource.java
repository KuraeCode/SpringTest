package spring_jdbc.jdbc_with_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by artmaster on 04.06.2017.
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSoruceSonfig.class);
        DriverManagerDataSource dataSoruceSonfig = (DriverManagerDataSource) context.getBean("driverManager");
        System.out.println(dataSoruceSonfig.getUrl() + dataSoruceSonfig.getUsername() + dataSoruceSonfig.getPassword());
    }
}
