package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.Report;
import com.crealytics.reporting.repositories.ReportRepository;
import com.crealytics.reporting.utils.ReportUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportService {

    private static final Logger logger = LogManager.getLogger(ReportService.class);

    @Autowired
    private ReportRepository reportRepository;

    public void parseFilesAndSaveInDB(List<File> reportFileList)  {
        List<Report> reports = new ArrayList<>();
        for(File reportFile: reportFileList){
            try {
                String month = ReportUtil.extractMonthFromReportName(reportFile.getName());
                CSVParser csvParser = getCsvParser(reportFile);
                for (CSVRecord record: csvParser) {
                    Report report = ReportUtil.buildReportFromCsvRecord(month, record);
                    reports.add(report);
                }
            } catch (Exception e) {
                logger.error("error while parsing and saving records for report: "+reportFile.getName(),e);
            }
        }
        reportRepository.saveAll(reports);
    }

    private CSVParser getCsvParser(File reportFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(reportFile.getPath()));
        return new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
    }


}
