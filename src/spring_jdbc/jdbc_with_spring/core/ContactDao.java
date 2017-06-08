package spring_jdbc.jdbc_with_spring.core;

import java.util.List;

/**
 * Created by artmaster on 05.06.2017.
 */
public interface ContactDao {

    String findLastNameById(Long id);

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    List<Contact> findAllWithDetails();

    public void update(Contact contact);
}
