package com.hillel.task29.cotrollers;

import com.hillel.task29.models.City;
import com.hillel.task29.services.CitiesService;
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
@RequestMapping("/city")
public class CityController {

    @Autowired
    CitiesService citiesService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCities(@RequestParam(value = "cityName") String cityName, Model model) throws SQLException {
        char lastChar = cityName.charAt(cityName.length() - 1);
        List<City> cities = citiesService.getCitiesByChar(lastChar);
        model.addAttribute("cities", cities);
        return "index";
    }

}
