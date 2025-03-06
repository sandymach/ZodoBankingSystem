package com.bs.zodo.controller;

import com.bs.zodo.service.DateFormaterService;
import com.bs.zodo.service.LatestDateFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date")
public class DateFormatterController {

    @Autowired
    private DateFormaterService service ;
    @Autowired
    private LatestDateFormater latestDateFormater;

    @PostMapping("/format")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> formatDates(@RequestBody List<String> dates,@RequestParam  String requiredFormat){
        return   latestDateFormater.formatDates(dates,requiredFormat);
    }
}
