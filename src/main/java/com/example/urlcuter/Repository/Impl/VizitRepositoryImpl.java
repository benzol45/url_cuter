package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.DTO.StatisticRequest;
import com.example.urlcuter.DTO.StatisticResponse;
import com.example.urlcuter.DTO.StatisticRow;
import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<StatisticRow> getStatistic(StatisticRequest statisticRequest) {
        //language=sql
        String baseQuery = "SELECT cut_url, full_url, count(datetime) as countvizit, count(distinct client) as countuniq FROM vizit WHERE true GROUP BY cut_url, full_url ORDER BY countvizit desc";

        List<String> whereElements = new ArrayList<>();
        List<Object> argumets = new ArrayList<>();
        List<Integer> argumetsType = new ArrayList<>();
        if (statisticRequest.getCutUrlFilter()!=null) {
           whereElements.add("cut_url=?");
           argumets.add(statisticRequest.getCutUrlFilter());
            argumetsType.add(Types.VARCHAR);
        }
        if (statisticRequest.getFromDateFilter()!=null) {
            whereElements.add("datetime>=?");
            argumets.add(Timestamp.valueOf(statisticRequest.getFromDateFilter()));
            argumetsType.add(Types.TIMESTAMP);
        }
        if (statisticRequest.getToDateFilter()!=null) {
            whereElements.add("datetime<=?");
            argumets.add(Timestamp.valueOf(statisticRequest.getToDateFilter()));
            argumetsType.add(Types.TIMESTAMP);
        }
        if (whereElements.size()>0) {
            String whereBlock = whereElements.stream().collect(Collectors.joining(" AND "));
            baseQuery = baseQuery.replace(" WHERE true", " WHERE " + whereBlock);
        } else {
            baseQuery = baseQuery.replace(" WHERE true", "");
        }

        if (statisticRequest.getLimit()!=null) {
            baseQuery = baseQuery + " LIMIT ?";
            argumets.add(statisticRequest.getLimit());
            argumetsType.add(Types.INTEGER);
        }

        int[] argumetsTypeArray = new int[argumetsType.size()];
        for (int i=0;i<argumetsTypeArray.length;i++) {
            argumetsTypeArray[i]=argumetsType.get(i);
        }

        List<StatisticRow> statisticRowList = jdbcTemplate.query(baseQuery,argumets.toArray(),argumetsTypeArray, getRowMaperStatisticRow());

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
