package com.example.urlcuter.Controller;

import com.example.urlcuter.DTO.StatisticRequest;
import com.example.urlcuter.DTO.StatisticResponse;
import com.example.urlcuter.DTO.StatisticRow;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requestStatistic")
public class StatisticApiController {

    @GetMapping
    @ResponseBody
    public StatisticResponse getStatistic(@RequestBody StatisticRequest statisticRequest) {
        //TODO заменить заглушку на реализацию
        StatisticResponse statisticResponse = new StatisticResponse();
//        statisticResponse.getStatisticRows().add(new StatisticRow("g",1));
//        statisticResponse.getStatisticRows().add(new StatisticRow("y",1));
        return statisticResponse;
    }
}
