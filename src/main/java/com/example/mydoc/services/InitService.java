package com.example.mydoc.services;

import jakarta.annotation.PostConstruct;

public interface InitService {

    @PostConstruct
    void init();
}
