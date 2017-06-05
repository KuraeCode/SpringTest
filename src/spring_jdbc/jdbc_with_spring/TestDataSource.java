package spring_jdbc.jdbc_with_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_jdbc.jdbc_with_spring.core.ContactDao;

import javax.sql.DataSource;

/**
 * Created by artmaster on 04.06.2017.
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSoruceSonfig.class);
        ContactDao dao = context.getBean("contactDao", ContactDao.class);
        System.out.println(dao.findAllWithDetails());
    }
}
