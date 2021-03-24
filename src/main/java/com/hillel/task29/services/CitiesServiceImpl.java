package com.hillel.task29.services;

import com.hillel.task29.models.City;
import com.hillel.task29.services.CitiesService;
import com.hillel.task29.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitiesServiceImpl implements CitiesService {

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

    @Override
    public City getRandomCity() {
        City city = null;
        ResultSet resultSet;
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
        ) {
            resultSet = statement.executeQuery("SELECT * FROM cities ORDER BY random() LIMIT 1");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                city = new City(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> getCitiesByChar(char ch) throws SQLException {
        String regex = ch + "%'";
        List<City> cities = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
        ) {
            resultSet = statement.executeQuery("SELECT * FROM cities WHERE name LIKE '" + regex);
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
}
