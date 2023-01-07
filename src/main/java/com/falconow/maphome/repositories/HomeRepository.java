package com.falconow.maphome.repositories;

import com.falconow.maphome.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    Optional<Home> findHomeByStreetAndAndHome(String street, String home);
}
