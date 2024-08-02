package org.example.rest_api.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;

public class DataSource {

    static Dotenv dotenv = Dotenv.load();
    public static JdbcTemplate PrimaryDb() throws Exception
    {
        String url = GetEnvironmentVariable("SPRING_DATASOURCE_PRIMARY_URL");
        String username = GetEnvironmentVariable("SPRING_DATASOURCE_PRIMARY_USERNAME");
        String password = GetEnvironmentVariable("SPRING_DATASOURCE_PRIMARY_PASSWORD");
        String driverClassName = GetEnvironmentVariable("SPRING_DATASOURCE_PRIMARY_DRIVER_CLASS_NAME");

        return  new JdbcTemplate(new HikariDataSource(new HikariConfig(){{
            setDriverClassName(driverClassName);
            setJdbcUrl(url);
            setUsername(username);
            setPassword(password);
            setMaximumPoolSize(10);
            setMinimumIdle(2);
            setConnectionTimeout(30000);
            setIdleTimeout(600000);
        }}));
    }

    private static String GetEnvironmentVariable(String variable) throws Exception {

        if(variable.isEmpty())
            throw new Exception("GetEnvironmentVariable not accept variable empty");

        String value = dotenv.get(variable);

        if(value == null || value.isEmpty())
            throw new Exception("Enviroment Variable "+ variable + " is null or empty");

        return  value;
    }
}
