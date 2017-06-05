package spring_jdbc;

import spring_jdbc.model.Contact;

import java.util.List;

/**
 * Created by artmaster on 04.06.2017.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Long contactId);
}
