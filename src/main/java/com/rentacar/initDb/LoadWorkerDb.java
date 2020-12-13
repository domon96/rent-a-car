package com.rentacar.initDb;

import com.rentacar.model.Client;
import com.rentacar.model.Worker;
import com.rentacar.model.enums.JobTitle;
import com.rentacar.repository.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadWorkerDb {

    @Bean
    CommandLineRunner workerInitDataBase(WorkerRepository workerRepository) {

        return args -> {
            workerRepository.save(Worker.builder()
                    .firstName("Damian")
                    .lastName("Rydz")
                    .jobTitle(JobTitle.WORKER)
                    .login("damryd")
                    .password("damryd")
                    .build());

            workerRepository.save(Worker.builder()
                    .firstName("Maks")
                    .lastName("Nowy")
                    .jobTitle(JobTitle.MANAGER)
                    .login("maknow")
                    .password("maknow")
                    .build());
        };
    }
}
