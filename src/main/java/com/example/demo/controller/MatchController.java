package com.example.demo.controller;

import com.example.demo.response.Response;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/models")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/matches")
    ResponseEntity getAllMatchs()
    {

        return Response.generateResponse("sucsessfull", HttpStatus.OK,matchService.getAllMatchs());
    }
}
