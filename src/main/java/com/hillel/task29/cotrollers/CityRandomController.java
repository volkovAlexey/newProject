package com.hillel.task29.cotrollers;

import com.hillel.task29.models.City;
import com.hillel.task29.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/randomCity")
public class CityRandomController {

    @Autowired
    CitiesService citiesService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRandomCity(Model model) {
        City randomCity = citiesService.getRandomCity();
        model.addAttribute("randomCity", randomCity);
        return "index";
    }
}
