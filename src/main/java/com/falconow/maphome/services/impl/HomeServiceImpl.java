package com.falconow.maphome.services.impl;

import com.falconow.maphome.entities.Home;
import com.falconow.maphome.entities.Room;
import com.falconow.maphome.entities.RoomColor;
import com.falconow.maphome.repositories.HomeRepository;
import com.falconow.maphome.services.HomeService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Home> homeList = homeRepository.findAll();
        if (homeList.isEmpty()) {
            Home home = new Home(null, "Винокурова","3", null);
            Home home2 = new Home(null, "Советская","59А", null);
            homeRepository.save(home);
            homeRepository.save(home2);
        }

        homeList.forEach(home ->{
            if (home.getRoomList().isEmpty()) {
                List<Room> roomList = new ArrayList<>(Arrays.asList(
                        new Room(null, "1", RoomColor.RED),
                        new Room(null, "2", RoomColor.GREEN),
                        new Room(null, "3", RoomColor.YELLOW)
                ));
                home.setRoomList(roomList);
                homeRepository.save(home);
            }
        });
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
