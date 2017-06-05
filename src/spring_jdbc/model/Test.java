package spring_jdbc.model;

import spring_jdbc.ContactDao;
import spring_jdbc.impl.ContactDaoImpl;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by artmaster on 04.06.2017.
 */
public class Test {

    private static ContactDao contactDao = new ContactDaoImpl();

    public static void main(String[] args) {
        System.out.println("all contacts" + contactDao.findAll());
        System.out.println("Вставка контакта");
        Contact contact = new Contact();
        contact.setFirstName("Kekor");
        contact.setLastName("Kekovich");
        contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
        contactDao.insert(contact);
        System.out.println("all contacts" + contactDao.findAll());
        contactDao.delete(contact.getId());
        System.out.println("all contacts" + contactDao.findAll());
    }
}
