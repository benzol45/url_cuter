package com.example.urlcuter.DTO;

public class StatisticRow {
    private String url;
    private int vizits;

    public StatisticRow(String url, int vizits) {
        this.url = url;
        this.vizits = vizits;
    }

    public String getUrl() {
        return url;
    }

    public int getVizits() {
        return vizits;
    }
}
