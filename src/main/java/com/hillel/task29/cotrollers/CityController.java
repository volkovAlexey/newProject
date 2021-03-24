package com.hillel.task29.cotrollers;

import com.hillel.task29.models.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @RequestMapping(method = RequestMethod.GET)
    public String getCities(String cityName, Model model) {
        model.addAttribute("cityName", cityName);
        return "hello";
    }

}
