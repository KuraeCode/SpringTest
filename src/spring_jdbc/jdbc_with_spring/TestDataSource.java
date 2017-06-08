package spring_jdbc.jdbc_with_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_jdbc.jdbc_with_spring.core.Contact;
import spring_jdbc.jdbc_with_spring.core.ContactDao;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by artmaster on 04.06.2017.
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSoruceSonfig.class);
        ContactDao dao = context.getBean("contactDao", ContactDao.class);
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Chris");
        contact.setLastName("John");
        contact.setBirthDate(new Date(new GregorianCalendar(1977, 10, 1).getTime().getTime()));
        dao.update(contact);
        System.out.println(dao.findAll());
    }
}
