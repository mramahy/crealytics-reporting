package com.crealytics.reporting.rest;

import com.crealytics.reporting.dto.ReportDto;
import com.crealytics.reporting.dto.wrapper.Response;
import com.crealytics.reporting.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportResource {

    private static final Logger logger = LogManager.getLogger(ReportResource.class);

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/reports",method = RequestMethod.GET)
    public Response<List<ReportDto>> getReports(@RequestParam(value = "month", required = false) String month,
                                                @RequestParam(value = "site", required = false) String site) {
        Response<List<ReportDto>> response = new Response<>();
        try{
            List<ReportDto> reportDtoList = reportService.fetchReportsBySiteAndMonth(site, month);
            response.setCode(200);
            response.setResponse(reportDtoList);
        }catch (Exception e){
            String errorMessage = "Error occured when trying to fetch reports on month: "+month+" and for site: "+site
                    +" with error message: "+e.getMessage();
            response.setCode(500);
            response.setMessage(errorMessage);
            logger.error(errorMessage, e);
        }
        return response;
    }
}
