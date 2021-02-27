package com.hillel.task20.service;

import com.hillel.task20.model.City;

import java.sql.SQLException;
import java.util.List;

public interface CityService {
    List<City> getCities() throws SQLException;

    void addCity(City city) throws SQLException;
}
