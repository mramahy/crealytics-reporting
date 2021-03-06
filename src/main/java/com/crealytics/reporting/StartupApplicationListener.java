package com.crealytics.reporting;

import com.crealytics.reporting.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LogManager.getLogger(ReportService.class);

    @Value("${reports.path}")
    private String path;

    @Autowired
    ReportService reportService;

    /*
    * the listener executes the onApplicationEvent method when application is ready to start and all
    * components are loaded this method main functionality is to call the reporting service to load all report
    * files into the H2 database
    * */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.info("start loading data into database");
        reportService.parseFilesAndSaveInDB(path);
        logger.info("finished loading data into database");
    }
}
