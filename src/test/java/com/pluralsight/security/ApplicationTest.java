package com.pluralsight.security;

import com.pluralsight.security.controller.PortfolioQueryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private PortfolioQueryController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
