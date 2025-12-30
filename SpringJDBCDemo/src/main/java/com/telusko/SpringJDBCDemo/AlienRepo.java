package com.telusko.SpringJDBCDemo;

import com.telusko.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AlienRepo {


    private JdbcTemplate templates;

    public JdbcTemplate getTemplates() {
        return templates;
    }

    @Autowired

    public void setTemplates(JdbcTemplate templates) {
        this.templates = templates;
    }

    public void save(@org.jetbrains.annotations.NotNull Alien alien) {

        String sql = "insert into alien (id,name,tech) values (?,?,?)";
        int rows = templates.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows + " row/s affected");


    }

    public List<Alien> findAll() {
        String sql = "select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {

                Alien a = new Alien();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setTech(rs.getString("tech"));

                return a;
            }
        };
        List<Alien> aliens = templates.query(sql,mapper);
        return aliens;
    }
}