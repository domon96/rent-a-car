package com.rentacar.initDb;

import com.rentacar.model.Car;
import com.rentacar.model.CarBodyType;
import com.rentacar.model.CarStatus;
import com.rentacar.model.PaintColor;
import com.rentacar.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCarDb {

    @Bean
    CommandLineRunner carInitDataBase(CarRepository carRepository) {

        return args -> {
            carRepository.save(Car.builder()
                    .brand("Toyota")
                    .model("Avensis")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2005)
                    .color(PaintColor.BLACK)
                    .mileage(135_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(100.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Toyota")
                    .model("Avensis")
                    .type(CarBodyType.SEDAN)
                    .productionYear(2010)
                    .color(PaintColor.BLUE)
                    .mileage(90_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(130.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Toyota")
                    .model("Corolla")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2008)
                    .color(PaintColor.BLACK)
                    .mileage(110_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(110.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Seat")
                    .model("Leon")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2015)
                    .color(PaintColor.BLACK)
                    .mileage(67_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(150.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Seat")
                    .model("Leon")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2015)
                    .color(PaintColor.BLUE)
                    .mileage(80_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(140.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Seat")
                    .model("Ibiza")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2000)
                    .color(PaintColor.BLACK)
                    .mileage(200_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(70.0)
                    .build());

            carRepository.save(Car.builder()
                    .brand("Seat")
                    .model("Ibiza")
                    .type(CarBodyType.HATCHBACK)
                    .productionYear(2003)
                    .color(PaintColor.BLACK)
                    .mileage(170_000)
                    .status(CarStatus.AVAILABLE)
                    .oneDayPrice(80.0)
                    .build());
        };
    }
}
