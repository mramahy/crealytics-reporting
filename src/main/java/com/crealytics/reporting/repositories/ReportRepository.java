package com.crealytics.reporting.repositories;

import com.crealytics.reporting.domain.Report;
import com.crealytics.reporting.domain.enums.Month;
import com.crealytics.reporting.domain.enums.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{


    List<Report> findAllBySite(Site site);

    List<Report> findAllByMonth(Month month);

    List<Report> findAllByMonthAndSite(Month month, Site site);
}
