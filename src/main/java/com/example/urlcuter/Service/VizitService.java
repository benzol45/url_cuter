package com.example.urlcuter.Service;

import com.example.urlcuter.DTO.StatisticRow;

import java.time.LocalDateTime;
import java.util.List;

public interface VizitService {
    void registerVizit(LocalDateTime eventDateTime, String cutUrl, String fullUrl, String clientID);

    List<StatisticRow> getPopular(int limit);
}
