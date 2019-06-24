package com.example.demo;

import com.example.demo.domain.Journal;
import com.example.demo.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    InitializingBean saveData(JournalRepository repo) {
        return () -> {
            repo.save(new Journal("자바공부", "Java의 정속", "05/27/2019"));
            repo.save(new Journal("JPA", "자바 ORM 표준 JPA", "05/29/2019"));
            repo.save(new Journal("Spring Boot", "Spring boot", "06/03/2019"));
            repo.save(new Journal("회사 프로젝트 분석", "wiegand 처리", "06/24/2019"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
