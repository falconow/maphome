package com.falconow.maphome.services.impl;

import com.falconow.maphome.entities.Entrance;
import com.falconow.maphome.entities.Home;
import com.falconow.maphome.repositories.HomeRepository;
import com.falconow.maphome.services.HomeService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;

    @Autowired
    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @PostConstruct
    private void init() {
        if(homeRepository.findAll().isEmpty()) {
            Home home = new Home();
            home.setStreet("Советская");
            home.setHome("59А");
            homeRepository.save(home);
        }
    }

    @Override
    public List<Home> getAll() {
        return homeRepository.findAll();
    }

    @Override
    public Home findById(Long id) {
        return homeRepository.findById(id).orElse(null);
    }
}
