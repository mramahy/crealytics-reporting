package com.crealytics.reporting.service;

import com.crealytics.reporting.repositories.ReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.util.AssertionErrors.fail;

@RunWith(SpringRunner.class)
public class ReportServiceTest {

    @TestConfiguration
    static class ReportServiceTestContextConfiguration {

        @Bean
        public ReportService reportService() {
            return new ReportService();
        }
    }

    @Autowired
    private ReportService reportService;

    @MockBean
    private ReportRepository reportRepository;

    @Test
    public void testDataLoaderService(){
        try{
            reportService.parseFilesAndSaveInDB("C:\\Users\\MOEL3\\workspace\\reporting\\src\\main\\resources\\reports");
            assertTrue("Service loaded successfully",true);
        }catch (Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }


    }
}
