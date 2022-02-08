package com.example.urlcuter.DTO;

import java.util.ArrayList;
import java.util.List;

public class StatisticResponse {
    private List<StatisticRow> statisticRows = new ArrayList<>();

    public List<StatisticRow> getStatisticRows() {
        return statisticRows;
    }
}
