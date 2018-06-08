package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.Report;
import com.crealytics.reporting.domain.enums.Month;
import com.crealytics.reporting.domain.enums.Site;
import com.crealytics.reporting.dto.ReportDto;
import com.crealytics.reporting.repositories.ReportRepository;
import com.crealytics.reporting.utils.ReportUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
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


    /*
    * reportFileList: list of report files to bel loaded to the database
    * this function loop on record of each file, parse it and convert it to report object to be saved in the DB
    * */
    public void parseFilesAndSaveInDB(List<File> reportFileList)  {
        List<Report> reports = new ArrayList<>();
        for(File reportFile: reportFileList){
            try {
                Month month = ReportUtil.extractMonthFromReportName(reportFile.getName());
                CSVParser csvParser = getCsvParser(reportFile);
                int recordNumber=1;
                for (CSVRecord record: csvParser) {
                    try {
                        Report report = ReportUtil.buildReportFromCsvRecord(month, record);
                        reports.add(report);
                        recordNumber++;
                    } catch (Exception e) {
                        logger.error("error while parsing and saving records for report: "+reportFile.getName()
                                +"record number: "+recordNumber, e);
                    }
                }
            } catch (Exception e) {
                logger.error("error while parsing and saving records for report: "+reportFile.getName(),e);
            }
        }
        reportRepository.saveAll(reports);
    }

    /*
    * create a csv parser for given file (reportFIle)
    * */
    private CSVParser getCsvParser(File reportFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(reportFile.getPath()));
        return new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
    }


    /*
    * site: ios,android or web(desktop or mobile) the site of report data required to fetch
    * month: the month of the required report data
    * */
    public List<ReportDto> fetchReportsBySiteAndMonth(String site, String month) throws Exception {
        List<Report> reports;
        Site siteEnum = getSiteEnum(site);
        Month monthEnum = getMonthEnum(month);
        ModelMapper mapper = new ModelMapper();
        Type listType = new TypeToken<List<ReportDto>>() {}.getType();
        List<ReportDto> reportDtos=null;
        if(siteEnum == null && monthEnum == null){
            reports = reportRepository.findAll();
        }else if(siteEnum != null && monthEnum == null){
            reports = reportRepository.findAllBySite(siteEnum);
        }else if(siteEnum == null){
            reports = reportRepository.findAllByMonth(monthEnum);
        }else{
            reports = reportRepository.findAllByMonthAndSite(monthEnum,siteEnum);
        }
        reportDtos = mapper.map(reports,listType);
        return reportDtos;
    }

    /*
    * get month of type enum based on string/integer month value
    * */
    private Month getMonthEnum(String month) {
        if(month == null || month.trim().isEmpty()) return null;
        if(ReportUtil.isNumeric(month)){
            return Month.of(Integer.parseInt(month));
        }else{
            return Month.of(month);
        }
    }

    /*
    * get site of type enum based on string site value
    * */
    private Site getSiteEnum(String site) throws Exception {
        if (site == null || site.trim().isEmpty()) return null;
        return Site.of(site.toLowerCase());
    }

    /*
    * used for testing purposes
    * */
    public List<Report> findAllReports(){
        return reportRepository.findAll();
    }
}
