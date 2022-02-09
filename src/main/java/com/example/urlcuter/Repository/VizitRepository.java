package com.example.urlcuter.Repository;

import com.example.urlcuter.DTO.StatisticRequest;
import com.example.urlcuter.DTO.StatisticResponse;
import com.example.urlcuter.DTO.StatisticRow;
import com.example.urlcuter.Entity.Vizit;

import java.util.List;

public interface VizitRepository {
    void addVizit(Vizit vizit);
    List<StatisticRow> getPopular(int limit);
    List<StatisticRow> getStatistic(StatisticRequest statisticRequest);
}
