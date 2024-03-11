package com.muchiri.plainjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.muchiri.plainjdbc.domain.Customer;

@Repository
public class CustomerDao {
    /**
     * To make things more easier you can use JdbcClient instead of JdbcTemplate.
     * If not using more than one datasource, then all these are auto configured
     * for us starting from the datasource defined in the application.properties.
     */
    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer create(String name, Integer yob) throws SQLException {
        String query = """
                INSERT INTO customer (name, yob) VALUES(?, ?) RETURNING id;
                """;

        int id = jdbcTemplate.query(query, (rs, rowNum) -> Integer.valueOf(rs.getInt("id")), name, yob).stream()
                .findFirst().get();
        return new Customer(id, name, yob);
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT id, name, yob FROM customer",
                (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getInt("yob")));
    }
}
