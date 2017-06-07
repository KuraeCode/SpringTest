package spring_jdbc.jdbc_with_spring.core;

import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artmaster on 08.06.2017.
 */
public class SelectAllContact extends MappingSqlQuery<Contact> {

    private static final String SQL_SELECT_ALL_CONTACT = "select id, first_name, last_name, birth_date from contact";

    public SelectAllContact(DataSource ds) {
        super(ds, SQL_SELECT_ALL_CONTACT);
    }

    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();

        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));

        contact.setBirthDate(resultSet.getDate("birth_date"));
        return contact;
    }
}
