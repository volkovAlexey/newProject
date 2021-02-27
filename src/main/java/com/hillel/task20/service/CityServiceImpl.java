package com.hillel.task20.service;

import com.hillel.task20.model.City;
import com.hillel.task20.utils.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
        ) {
            resultSet = statement.executeQuery("SELECT * FROM cities");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                City city = new City(id, name);
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void addCity(City city) {
        String id = city.getId();
        String name = city.getName();
        String insert = "INSERT INTO cities (id, name) VALUES ('" + id + "', '" + name + "');";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
