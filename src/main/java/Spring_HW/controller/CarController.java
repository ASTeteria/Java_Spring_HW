package Spring_HW.controller;


import Spring_HW.Car;
import Spring_HW.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Отримання всіх автомобілів
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.of(Optional.of(cars)); // Завжди 200 OK
    }

    // Отримання за id
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return ResponseEntity.of(car); // 200 OK, якщо знайдено, або 404 Not Found, якщо немає
    }

    // Додати автомобіль
    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.of(Optional.of("Car added successfully.")); // Завжди 200 OK
    }

    // Видалити за Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            carService.deleteCar(id);
            return ResponseEntity.of(Optional.of("Car deleted successfully.")); // 200 OK
        }
        return ResponseEntity.of(Optional.empty()); // 404 Not Found
    }

   //За потужністю
    @GetMapping("/power/{value}")
    public ResponseEntity<List<Car>> getCarsByPower(@PathVariable int value) {
        List<Car> cars = carService.getCarsByPower(value);
        return ResponseEntity.of(cars.isEmpty() ? Optional.empty() : Optional.of(cars));
    }
    //За виробником
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<Car>> getCarsByProducer(@PathVariable String value) {
        List<Car> cars = carService.getCarsByProducer(value);
        return ResponseEntity.of(cars.isEmpty() ? Optional.empty() : Optional.of(cars));
    }
}