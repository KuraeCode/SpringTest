package spring_jdbc.jdbc_with_spring.core;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by artmaster on 05.06.2017.
 */
public class JdbcContactDao implements ContactDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        MySQLErrorCodesTranslator errorCodesTranslator = new MySQLErrorCodesTranslator();

        errorCodesTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(errorCodesTranslator);

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findLastNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name from contact where id=?", new Object[]{id}, String.class);
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null)
            throw new BeanCreationException("Must set dataSoruce on ContactDao");
    }
}
