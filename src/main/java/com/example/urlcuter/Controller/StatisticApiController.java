package com.example.urlcuter.Controller;

import com.example.urlcuter.DTO.StatisticRequest;
import com.example.urlcuter.DTO.StatisticResponse;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requestStatistic")
public class StatisticApiController {
    private final VizitService vizitService;

    @Autowired
    public StatisticApiController(VizitService vizitService) {
        this.vizitService = vizitService;
    }

    @GetMapping
    @ResponseBody
    public StatisticResponse getStatistic(@RequestBody StatisticRequest statisticRequest) {
        StatisticResponse statisticResponse = vizitService.getStatistic(statisticRequest);
        //StatisticResponse statisticResponse = new StatisticResponse();
//        statisticResponse.getStatisticRows().add(new StatisticRow("g",1));
//        statisticResponse.getStatisticRows().add(new StatisticRow("y",1));
        return statisticResponse;
    }
}
