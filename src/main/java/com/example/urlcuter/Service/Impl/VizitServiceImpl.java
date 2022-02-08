package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.DTO.StatisticRow;
import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VizitServiceImpl implements VizitService {
    private final VizitRepository vizitRepository;

    @Autowired
    public VizitServiceImpl(VizitRepository vizitRepository) {
        this.vizitRepository = vizitRepository;
    }

    @Override
    public void registerVizit(LocalDateTime eventDateTime, String cutUrl, String fullUrl, String clientID) {
        Vizit vizit = new Vizit(eventDateTime,cutUrl,fullUrl,UUID.fromString(clientID));
        vizitRepository.addVizit(vizit);
    }

    @Override
    public List<StatisticRow> getPopular(int limit) {
        return vizitRepository.getPopular(limit);
    }

}
