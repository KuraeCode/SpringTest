package spring_jdbc.jdbc_with_spring.core;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artmaster on 05.06.2017.
 */
public class JdbcContactDao implements ContactDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = jdbcTemplate;
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
        return jdbcTemplate.query("select id, first_name, last_name, birth_date from contact", (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        });
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

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null)
            throw new BeanCreationException("Must set dataSoruce on ContactDao");
    }
}
