package com.crealytics.reporting.utils;

import com.crealytics.reporting.domain.Report;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ReportUtil {

    private static final String REPORTS_FOLDER = "reports";
    private static final String REPORT_NAME_REGEX = "\\d{4}_(\\d{2})_report\\.csv";

    public static String extractMonthFromReportName(String name) throws Exception {
        Pattern p = Pattern.compile(REPORT_NAME_REGEX);
        Matcher m = p.matcher(name);
        if (m.matches()){
           return Month.of(Integer.parseInt(m.group(1))).name();
        }
        throw new Exception("invalid name format cannot extract month number for report with name: "+name);
    }

    public static List<File> getReportingFolderFiles () {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(REPORTS_FOLDER);
        String path = url.getPath();
        List<File> validFiles = validateFileNamesFormat(new File(path).listFiles());
        return validFiles;
    }

    /*
    * @param: month, the number of month of the report
    * @param: record, csv record
    * this method is to map report data to a Report object to be saved in the DB
    * */
    public static Report buildReportFromCsvRecord(String month, CSVRecord record) throws Exception {
        String site = record.get("site");
        String requests = record.get("requests");
        String clicks = record.get("clicks");
        String impressions = record.get("impressions");
        String conversions = record.get("conversions");
        String revenue = record.get("revenue (USD)");
        Report report = new Report();
        report.setMonth(month);
        report.setClicks(Long.parseLong(clicks));
        report.setConversions(Long.parseLong(conversions));
        report.setSite(site);
        report.setRequests(Long.parseLong(requests));
        report.setRevenue(Double.parseDouble(revenue));
        report.setImpressions(Long.parseLong(impressions));
        report.setCr(MathUtil.getPercentage((float)report.getConversions(),(float)report.getImpressions()));
        report.setCtr(MathUtil.getPercentage((float)report.getClicks(),(float)report.getImpressions()));
        report.setFillRate(MathUtil.getPercentage((float)report.getImpressions(),(float)report.getRequests()));
        Double eCPM = (report.getRevenue()*1000)/(double)report.getImpressions();
        report.seteCPM(eCPM);
        return report;
    }

    private static List<File> validateFileNamesFormat(File[] files) {
        List<File> validFiles = new ArrayList<>();
        for(File file: files){
            if(file.getName().matches(REPORT_NAME_REGEX)){
                validFiles.add(file);
            }
        }
        return validFiles;
    }
}