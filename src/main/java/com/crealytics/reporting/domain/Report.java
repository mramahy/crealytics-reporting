package com.crealytics.reporting.domain;

import com.crealytics.reporting.domain.enums.Month;
import com.crealytics.reporting.domain.enums.Site;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Month month;

    private Site site;

    private Long requests;

    private Long impressions;

    private Long clicks;

    private Long conversions;

    private Double revenue;

    private Float ctr;

    private Float cr;

    private Float fillRate;

    private Double eCPM;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
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

    public Float getCtr() {
        return ctr;
    }

    public void setCtr(Float ctr) {
        this.ctr = ctr;
    }

    public Float getCr() {
        return cr;
    }

    public void setCr(Float cr) {
        this.cr = cr;
    }

    public Float getFillRate() {
        return fillRate;
    }

    public void setFillRate(Float fillRate) {
        this.fillRate = fillRate;
    }

    public Double geteCPM() {
        return eCPM;
    }

    public void seteCPM(Double eCPM) {
        this.eCPM = eCPM;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
