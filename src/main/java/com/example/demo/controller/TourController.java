package com.example.demo.controller;

import com.example.demo.response.Response;
import com.example.demo.responseTO.MatchDetailResponseTO;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class TourController {

    @Autowired
    TourService tourService;

    @GetMapping("/tour/{tourName}")
    ResponseEntity getMatchesByTourName(@PathVariable String tourName) throws Exception {
        try {
            if (tourName == null || tourName.isEmpty()) {
                throw new ValidationFailureException("tourName is null or Empty!");
            }
            List<MatchDetailResponseTO> resultList = tourService.getMatchesByTourName(tourName);
            return Response.generateResponse("sucessfull", HttpStatus.OK, resultList);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
