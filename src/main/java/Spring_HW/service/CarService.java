package Spring_HW.service;


import Spring_HW.AppConfig;
import Spring_HW.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarService(AppConfig appConfig) {
        cars.addAll(appConfig.getInitialData());
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarById(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public List<Car> getCarsByPower(int power) {
        return cars.stream().filter(car -> car.getPower() == power).collect(Collectors.toList());
    }

    public List<Car> getCarsByProducer(String producer) {
        return cars.stream().filter(car -> car.getProducer().equalsIgnoreCase(producer)).collect(Collectors.toList());
    }
}