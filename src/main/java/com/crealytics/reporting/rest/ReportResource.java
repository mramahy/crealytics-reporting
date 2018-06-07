package com.crealytics.reporting.rest;

import com.crealytics.reporting.dto.ReportDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportResource {

    @RequestMapping("/reports")
    public ReportDto getReports(@RequestParam("month") String month,@RequestParam("site") String site) {
        return null;
    }
}
