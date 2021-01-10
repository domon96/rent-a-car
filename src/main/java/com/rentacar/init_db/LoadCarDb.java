package com.rentacar.init_db;

import com.rentacar.model.Car;
import com.rentacar.model.enums.CarBodyType;
import com.rentacar.model.enums.CarStatus;
import com.rentacar.model.enums.PaintColor;
import com.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCarDb implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        saveCar("Toyota", "Avensis", CarBodyType.HATCHBACK, 2005, PaintColor.BLACK, 135_000, 100.0);

        saveCar("Toyota", "Avensis", CarBodyType.SEDAN, 2010, PaintColor.BLUE, 90_000, 130.0);

        saveCar("Toyota", "Corolla", CarBodyType.HATCHBACK, 2008, PaintColor.BLACK, 110_000, 110.0);

        saveCar("Seat", "Leon", CarBodyType.HATCHBACK, 2015, PaintColor.BLACK, 67_000, 150.0);

        saveCar("Seat", "Leon", CarBodyType.HATCHBACK, 2015, PaintColor.BLUE, 80_000, 140.0);

        saveCar("Seat", "Ibiza", CarBodyType.HATCHBACK, 2000, PaintColor.BLACK, 200_000, 70.0);

        saveCar("Seat", "Ibiza", CarBodyType.HATCHBACK, 2003, PaintColor.BLACK, 170_000, 80.0);
    }

    private void saveCar(String brand, String model, CarBodyType type, int productionYear, PaintColor color, int mileage, double oneDayPrice) {
        carRepository.save(Car.builder()
                .brand(brand)
                .model(model)
                .type(type)
                .productionYear(productionYear)
                .color(color)
                .mileage(mileage)
                .status(CarStatus.AVAILABLE)
                .oneDayPrice(oneDayPrice)
                .build());
    }
}
