package spring_jdbc.jdbc_with_spring;

import org.springframework.context.annotation.*;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import spring_jdbc.jdbc_with_spring.core.ContactDao;
import spring_jdbc.jdbc_with_spring.core.JdbcContactDao;


import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/**
 * Created by artmaster on 04.06.2017.
 */
@Configuration
@ComponentScan(value = "spring_jdbc.jdbc_with_spring")
//@PropertySource(value = {"classpath:spring_jdbc/jdbc_with_spring/jdbc.properties"}, ignoreResourceNotFound = true)
public class DataSoruceSonfig {

    /*@Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;*/

    /*@Bean
    public DriverManagerDataSource driverManager() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }*/

    @Bean
    @Lazy
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(H2)
                .addScript("classpath:spring_jdbc/jdbc_with_spring/schema.sql")
                .addScript("classpath:spring_jdbc/jdbc_with_spring/test-data.sql");
        return builder.build();
    }

    @Bean
    public ContactDao contactDao() {
        JdbcContactDao contactDao = new JdbcContactDao();
        contactDao.setDataSource(dataSource());
        return contactDao;
    }


}
