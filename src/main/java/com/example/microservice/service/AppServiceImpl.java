package com.example.microservice.service;

import org.springframework.stereotype.Service;
import com.example.microservice.repository.AppRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AppServiceImpl implements AppService {
    AppRepository appRepository;

    public String message(String name) {
        return appRepository.message(name);
    }
}
