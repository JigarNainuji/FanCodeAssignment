package com.example.demo.service;

import com.example.demo.entity.Match;
import com.example.demo.repository.MatchRepository;
import com.example.demo.response.Response;
import com.example.demo.responseTO.MatchDetailResponseTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

   public List<MatchDetailResponseTO> getAllMatchs()
    {
        List<Match> list =  matchRepository.findAllMatches();

        List<MatchDetailResponseTO> dataList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for(Match match:list)
        {
            dataList.add(modelMapper.map(match,MatchDetailResponseTO.class));
        }
        return dataList;

    }
}
