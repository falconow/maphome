package com.falconow.maphome.services;

import com.falconow.maphome.entities.Home;

import java.util.List;

public interface HomeService {
    List<Home> getAll();
    Home findById(Long id);
    Home findByStreetAndHome(String street, String home);
}
