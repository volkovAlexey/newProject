package com.hillel.task29.services;

import com.hillel.task29.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CitiesService {
    List<City> getCities() throws SQLException;

    List<City> getCitiesByChar(char ch) throws SQLException;

    void addCity(City city) throws SQLException;

    City getRandomCity();
}
