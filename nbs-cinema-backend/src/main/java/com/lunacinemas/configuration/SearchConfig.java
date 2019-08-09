package com.lunacinemas.configuration;

import com.lunacinemas.businesslogic.FilmGrabber;
import com.lunacinemas.model.Film;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@ComponentScan(basePackageClasses = FilmGrabber.class)
public class SearchConfig {

    @Bean
    public ArrayList<Film> getSearchResults(){
        return new ArrayList<>();
    }
}
