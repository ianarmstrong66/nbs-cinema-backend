package com.lunacinemas.configuration;

import com.lunacinemas.businesslogic.ReviewFilter;
import com.lunacinemas.model.Showing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ReviewFilter.class)
public class ShowingConfig {

    @Bean
    public Showing getShowing(){
        return new Showing();
    }
}
