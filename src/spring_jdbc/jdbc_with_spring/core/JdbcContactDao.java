package spring_jdbc.jdbc_with_spring.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artmaster on 05.06.2017.
 */
@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

    private static final Log LOG = LogFactory.getLog(JdbcContactDao.class);
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SelectAllContact selectAllContact;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;

    @Autowired
    public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = jdbcTemplate;
        selectAllContact = new SelectAllContact(dataSource);
        selectContactByFirstName = new SelectContactByFirstName(dataSource);
        updateContact = new UpdateContact(dataSource);
    }

    @Override
    public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id = :contactId";

        Map<String, Object> namedParametrs = new HashMap<>();
        namedParametrs.put("contactId", id);
        return jdbcTemplate.queryForObject(sql, namedParametrs, String.class);
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContact.execute();
        /* return jdbcTemplate.query("select id, first_name, last_name, birth_date from contact", (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        });*/
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public List<Contact> findAllWithDetails() {
        String sql = "select c.id, c.first_name, c.last_name, c.birth_date, t.id as contact_tel_id, t.tel_type, t.tel_number from contact c " +
                "left join contact_tel_detail t on c.id = t.contact_id";
        return jdbcTemplate.query(sql, (resultSet -> {
            Map<Long, Contact> map = new HashMap<>();
            Contact contact = null;

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                contact = map.get(id);

                if (contact == null) {
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<>());
                    map.put(id, contact);
                }
                Long contactTelDetailId = resultSet.getLong("contact_tel_id");
                if (contactTelDetailId > 0) {
                    ContactTelDetails contactTelDetails = new ContactTelDetails();
                    contactTelDetails.setId(contactTelDetailId);
                    contactTelDetails.setContactId(id);
                    contactTelDetails.setTelType(resultSet.getString("tel_type"));
                    contactTelDetails.setTelNumber(resultSet.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetails);
                }
            }

            return new ArrayList<>(map.values());
        }));
    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        paramMap.put("id", contact.getId());

        updateContact.updateByNamedParam(paramMap);

        LOG.info("Existing contact updated with id: " + contact.getId());
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null)
            throw new BeanCreationException("Must set dataSoruce on ContactDao");
    }
}
