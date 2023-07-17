package com.example.demo.controller;

import com.example.demo.entity.Sport;
import com.example.demo.response.Response;
import com.example.demo.responseTO.SportDetailsResponseTO;
import com.example.demo.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/models")
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping("/sports")
    ResponseEntity getAllSportsToursAndMatches()
    {
        List<SportDetailsResponseTO> list = sportService.getAllSportsToursAndMatches();
        return Response.generateResponse("sucsesfull", HttpStatus.OK,list);
    }

}
