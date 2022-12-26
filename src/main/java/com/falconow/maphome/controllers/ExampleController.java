package com.falconow.maphome.controllers;

import com.falconow.maphome.entities.Home;
import com.falconow.maphome.services.HomeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class ExampleController {

    private final HomeService homeService;

    @Autowired
    public ExampleController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/homes")
    public ResponseEntity<List<Home>> test() {
        List<Home> result = homeService.getAll();
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }


}
