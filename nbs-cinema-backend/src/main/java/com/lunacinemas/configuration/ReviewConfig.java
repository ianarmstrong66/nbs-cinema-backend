package com.lunacinemas.configuration;

import com.lunacinemas.businesslogic.ReviewFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ReviewFilter.class)
class ReviewConfig {

    @Bean
    public boolean getSuccessful(){
        return true;
    }

    @Bean
    public String getBody(){
        return "";
    }

}
