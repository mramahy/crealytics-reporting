package com.crealytics.reporting.dto;


/*
*  Dto response for report api
* */
public class ReportDto {
    String month;
    String site;
    Long requests;
    Long impressions;
    Long clicks;
    Long conversions;
    Double revenue;
    Float CTR;
    Float CR;
    Float fillRate;
    Float eCPM;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getRequests() {
        return requests;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }

    public Long getImpressions() {
        return impressions;
    }

    public void setImpressions(Long impressions) {
        this.impressions = impressions;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getConversions() {
        return conversions;
    }

    public void setConversions(Long conversions) {
        this.conversions = conversions;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Float getCTR() {
        return CTR;
    }

    public void setCTR(Float CTR) {
        this.CTR = CTR;
    }

    public Float getCR() {
        return CR;
    }

    public void setCR(Float CR) {
        this.CR = CR;
    }

    public Float getFillRate() {
        return fillRate;
    }

    public void setFillRate(Float fillRate) {
        this.fillRate = fillRate;
    }

    public Float geteCPM() {
        return eCPM;
    }

    public void seteCPM(Float eCPM) {
        this.eCPM = eCPM;
    }
}
