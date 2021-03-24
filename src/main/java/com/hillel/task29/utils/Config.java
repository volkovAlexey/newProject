package com.hillel.task29.utils;

import com.hillel.task29.models.City;
import com.hillel.task29.services.CitiesService;
import com.hillel.task29.services.CitiesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CitiesService citiesService() {
        return new CitiesServiceImpl();
    }
}
