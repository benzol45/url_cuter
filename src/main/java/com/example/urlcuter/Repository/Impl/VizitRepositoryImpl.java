package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.DTO.StatisticRow;
import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


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

    @Override
    public List<StatisticRow> getPopular(int limit) {
        //language=sql
        List<StatisticRow> statisticRowList = jdbcTemplate.query("SELECT cut_url, full_url, count(datetime) as countvizit, count(distinct client) as countuniq FROM vizit WHERE datetime>=? GROUP BY cut_url, full_url ORDER BY countvizit desc LIMIT ?",
                getRowMaperStatisticRow(), Timestamp.valueOf(LocalDateTime.now().minusMonths(1)),limit);
        return statisticRowList;
    }

    private RowMapper<StatisticRow> getRowMaperStatisticRow() {
        return (rs, rowNum) -> new StatisticRow(
                rs.getString("cut_url"),
                rs.getString("full_url"),
                rs.getInt("countvizit"),
                rs.getInt("countuniq"));
    }
}
