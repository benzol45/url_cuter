package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class VizitRepositoryImpl implements VizitRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VizitRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addVizit(Vizit vizit) {
        jdbcTemplate.update("INSERT INTO vizit(datetime, cut_url, full_url, client) VALUES (?,?,?,?)",
                vizit.getDateTimeTimestamp(),vizit.getCutUrl(),vizit.getFullUrl(),vizit.getClientID());
    }
}
