package com.falconow.maphome.controllers;

import com.falconow.maphome.entities.Home;
import com.falconow.maphome.services.HomeService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;


@RestController
@Validated
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
    public ResponseEntity<Home> get_home(@RequestParam(name = "street") @NotBlank String street, @RequestParam(name = "home") @NotBlank String home) {
        Home result = homeService.findByStreetAndHome(street, home);
        if (result == null) {
            throw new HttpStatusCodeException(HttpStatus.NOT_FOUND) {
            };
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
