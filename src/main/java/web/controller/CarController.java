package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;
import web.service.CarService;


@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String Cars(@RequestParam(defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";

    }


}
