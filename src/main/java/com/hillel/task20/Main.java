package com.hillel.task20;

import com.hillel.task20.model.City;
import com.hillel.task20.service.CityServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CityServiceImpl cityService = new CityServiceImpl();

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Input city: ");
            String nameCity = in.nextLine();
            City city = new City(nameCity);
            cityService.addCity(city);

            List<City> cities = cityService.getCities();
            System.out.println(cities);
        }
    }
}
