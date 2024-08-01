package org.example.rest_api.repository.implementations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.rest_api.model.entity.ChatMessage;
import org.example.rest_api.repository.interfaces.IAnyRepository;
import org.example.rest_api.util.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;

@Repository
public class AnyRepository implements IAnyRepository {
    private final JdbcTemplate _jdbcTemplate;

    public AnyRepository() throws Exception {
        this._jdbcTemplate = DataSource.PrimaryDb();
    }

    @Override
    public List<ChatMessage> getAllMessage() {
        String sql = "SELECT * FROM chat_message";
        return _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChatMessage.class));
    }
}
