package spring_jdbc.jdbc_with_spring.core;

import java.util.List;

/**
 * Created by artmaster on 05.06.2017.
 */
public interface ContactDao {

    String findLastNameById(Long id);

    List<Contact> findAll();

    List<Contact> findAllWithDetails();
}
