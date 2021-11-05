package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getCars(List<Car> listCars, int count) {
        return listCars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
