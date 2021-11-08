package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getCars(int count) {
        List<Car> listCars = new ArrayList<>();
        listCars.add(new Car("BMW", "350", "black"));
        listCars.add(new Car("FIAT", "PANDA", "black"));
        listCars.add(new Car("AUDI", "Q7", "brown"));
        listCars.add(new Car("MERCEDES", "GL-350", "grey"));
        listCars.add(new Car("KIA", "RIO", "white"));

        return count == 0 ? listCars : listCars.stream().limit(count).collect(Collectors.toList());
    }

}
