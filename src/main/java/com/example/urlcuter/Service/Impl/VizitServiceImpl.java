package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Entity.Vizit;
import com.example.urlcuter.Repository.VizitRepository;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VizitServiceImpl implements VizitService {
    private final VizitRepository vizitRepository;

    @Autowired
    public VizitServiceImpl(VizitRepository vizitRepository) {
        this.vizitRepository = vizitRepository;
    }

    @Override
    public void registerVizit(String cutUrl, String clientID) {
        Vizit vizit = new Vizit(LocalDateTime.now(), UUID.fromString(clientID),cutUrl);
        vizitRepository.addVizit(vizit);
    }

}
