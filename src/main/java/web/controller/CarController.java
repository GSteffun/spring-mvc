package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> listCars = new ArrayList<>();
        listCars.add(new Car("BMW", "350", "black"));
        listCars.add(new Car("FIAT", "PANDA", "black"));
        listCars.add(new Car("AUDI", "Q7", "brown"));
        listCars.add(new Car("MERCEDES", "GL-350", "grey"));
        listCars.add(new Car("KIA", "RIO", "white"));

        if (count == null) {
            model.addAttribute("listCars", listCars);
        } else {
            model.addAttribute("listCars", carService.getCars(listCars, count));
        }

        return "cars";
    }

}
