package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class UrlRepositoryImpl implements UrlRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UrlRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<UrlMapper> getUrlMapperByCutUrl(String cutUrl) {
        RowMapper<UrlMapper> rowMapper = (rs, rowNum) -> {
            String cutUrl1 = rs.getString("cut_url");
            String fullUrl = rs.getString("full_url");
            Timestamp timestamp = rs.getTimestamp("live_time");
            LocalDateTime dateTime = null;
            if (timestamp!=null) {
                 dateTime = timestamp.toLocalDateTime();
            }

            UrlMapper urlMapper = new UrlMapper(cutUrl1,fullUrl);
            urlMapper.setLiveTime(dateTime);
            return urlMapper;
        };

        try {
            //language=sql
            UrlMapper urlMapper = jdbcTemplate.queryForObject("SELECT url.cut_url, url.full_url, url.live_time FROM url WHERE cut_url=? LIMIT 1",rowMapper,cutUrl);
            return Optional.of(urlMapper);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existCutUrl(String cutUrl) {
        return false;
    }

    @Override
    public void addNewUrlMapper(UrlMapper urlMapper) {
        jdbcTemplate.update("INSERT INTO url (cut_url, full_url, live_time) VALUES (?,?,?)",urlMapper.getCutUrl(),urlMapper.getFullUrl(),urlMapper.getLiveTimeTimestamp());

    }
}
