package hibernate;

import hibernate.core.Contact;
import hibernate.core.ContactDao;
import hibernate.core.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDate;

/**
 * Created by artmaster on 13.06.2017.
 */
public class TestHibernate {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:hibernate/METAINF/factory-session.xml");
        context.refresh();
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        contactDao.findAllWithDetail().forEach(contact -> System.out.println(contact + "  " + contact.getContactTelDetails()));

        Contact contact = contactDao.findById(1L);

        contactDao.delete(contact);
        contactDao.findAllWithDetail().forEach(contactEach -> System.out.println(contactEach + "  " + contactEach.getContactTelDetails()));
    }
}
