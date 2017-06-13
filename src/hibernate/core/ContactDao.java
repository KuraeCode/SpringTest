package hibernate.core;

import java.util.List;

/**
 * Created by artmaster on 13.06.2017.
 */

public interface ContactDao {

    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
