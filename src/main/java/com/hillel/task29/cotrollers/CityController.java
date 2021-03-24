package com.hillel.task29.cotrollers;

import com.hillel.task29.models.City;
import com.hillel.task29.services.CitiesService;
import com.hillel.task29.services.CitiesServiceImpl;
import com.hillel.task29.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    CitiesService citiesService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/city")
    public String getCities(@RequestParam(value = "cityName") String cityName, Model model) throws SQLException {
        char lastChar = cityName.charAt(cityName.length() - 1);
        List<City> cities = citiesService.getCitiesByChar(Character.toUpperCase(lastChar));
        model.addAttribute("cities", cities);
        return "index";
    }
}
