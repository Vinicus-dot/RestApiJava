package org.example.rest_api.repository.implementations;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.rest_api.model.entity.ChatMessage;
import org.example.rest_api.repository.interfaces.IAnyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;

@Repository
public class AnyRepository implements IAnyRepository {
    private final JdbcTemplate _jdbcTemplate;

    public AnyRepository() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("SPRING_DATASOURCE_PRIMARY_URL");
        String username = dotenv.get("SPRING_DATASOURCE_PRIMARY_USERNAME");
        String password = dotenv.get("SPRING_DATASOURCE_PRIMARY_PASSWORD");
        String driverClassName = dotenv.get("SPRING_DATASOURCE_PRIMARY_DRIVER_CLASS_NAME");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        this._jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ChatMessage> getAllMessage() {
        String sql = "SELECT * FROM chat_message";
        return _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChatMessage.class));
    }
}
