package com.falconow.maphome.controllers;

import com.falconow.maphome.entities.Home;
import com.falconow.maphome.services.HomeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

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

    @GetMapping("/home")
    public ResponseEntity<Home> get_home(@RequestParam(name = "street") String street, @RequestParam(name = "home") String home) {
        Home result = homeService.findByStreetAndHome(street, home);
        System.out.println(result);
        if (result == null) {
            throw new HttpStatusCodeException(HttpStatusCode.valueOf(404)) {
            };
        }

        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }


}
