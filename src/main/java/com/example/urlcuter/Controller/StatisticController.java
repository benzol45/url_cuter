package com.example.urlcuter.Controller;

import com.example.urlcuter.DTO.StatisticRequest;
import com.example.urlcuter.DTO.StatisticResponse;
import com.example.urlcuter.DTO.StatisticRow;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requestStatistic")
public class StatisticController {

    @GetMapping
    @ResponseBody
    public StatisticResponse getStatistic(@RequestBody StatisticRequest statisticRequest) {
        StatisticResponse statisticResponse = new StatisticResponse();
        statisticResponse.getStatisticRows().add(new StatisticRow("g",1));
        statisticResponse.getStatisticRows().add(new StatisticRow("y",1));
        return statisticResponse;
    }
}
