package com.crealytics.reporting.service;

import com.crealytics.reporting.configuration.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
/*@SpringBootTest(classes = {ReportService.class})*/
@DataJpaTest
@ContextConfiguration(classes = { TestConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class ReportServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void testDataLoaderService(){
        System.out.println("done");

    }
}
