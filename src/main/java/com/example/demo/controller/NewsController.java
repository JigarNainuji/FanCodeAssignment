package com.example.demo.controller;

import com.example.demo.requestTO.NewsRequestTO;
import com.example.demo.response.Response;
import com.example.demo.responseTO.MatchDetailResponseTO;
import com.example.demo.responseTO.NewsResponseTO;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("/createNewsByMatchId")
    ResponseEntity createNewsByMatchId(@RequestBody NewsRequestTO newsRequestTO) throws Exception
    {
        try {
            if (newsRequestTO == null ) {
                throw new ValidationFailureException("requestTO is null!");
            }
            NewsResponseTO news = newsService.createNewsByMatchId(newsRequestTO);
            return Response.generateResponse("News sucessfully saved", HttpStatus.OK, news);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/createNewsByTourId")
    ResponseEntity createNewsByTourId(@RequestBody NewsRequestTO newsRequestTO) throws Exception
    {
        try {
            if (newsRequestTO == null ) {
                throw new ValidationFailureException("requestTO is null!");
            }
            NewsResponseTO news = newsService.createNewsByTourId(newsRequestTO);
            return Response.generateResponse("News sucessfully saved", HttpStatus.OK, news);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/getNewsByMatchId/{matchId}")
    ResponseEntity getNewsByMatchId(@PathVariable Integer matchId) throws Exception
    {
        try {
            List<NewsResponseTO> newsResponseTOList = newsService.getNewsByMatchId(matchId);
            return Response.generateResponse("sucessful", HttpStatus.OK, newsResponseTOList);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/getNewsByTourId/{tourId}")
    ResponseEntity getNewsByTourId(@PathVariable Integer tourId) throws Exception
    {
        try {
            List<NewsResponseTO> newsResponseTOList = newsService.getNewsByTourId(tourId);
            return Response.generateResponse(" sucessful", HttpStatus.OK, newsResponseTOList);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/getNewsBySportId/{sportId}")
    ResponseEntity getNewsBySportId(@PathVariable Integer sportId) throws Exception
    {
        try {
            List<NewsResponseTO> newsResponseTOList = newsService.getNewsBySportId(sportId);
            return Response.generateResponse("sucessfull", HttpStatus.OK, newsResponseTOList);
        } catch (ValidationFailureException vfe) {
            return Response.generateResponse(vfe.getMessage(), HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
