package com.example.urlcuter.DTO;

public class StatisticRow {
    private String cut_url;
    private String full_url;
    private int vizitsAll;
    private int vizitsUniq;

    public StatisticRow(String cut_url, String full_url, int vizitsAll, int vizitsUniq) {
        this.cut_url = cut_url;
        this.full_url = full_url;
        this.vizitsAll = vizitsAll;
        this.vizitsUniq = vizitsUniq;
    }

    public String getCut_url() {
        return cut_url;
    }

    public String getFull_url() {
        return full_url;
    }

    public int getVizitsAll() {
        return vizitsAll;
    }

    public int getVizitsUniq() {
        return vizitsUniq;
    }
}
