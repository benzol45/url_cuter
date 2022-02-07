package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VizitRepositoryImplList implements VizitRepository {
    private static List<Vizit> vizitList = new ArrayList<>();

    @Override
    public void addVizit(Vizit vizit) {
        vizitList.add(vizit);
    }
}
