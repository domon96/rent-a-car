package com.rentacar.init_db;

import com.rentacar.model.Worker;
import com.rentacar.model.enums.JobTitle;
import com.rentacar.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadWorkerDb implements CommandLineRunner {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public void run(String... args) throws Exception {
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
    }
}
