package com.example.demo.service;


import com.example.demo.entity.Match;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TourRepository;
import com.example.demo.responseTO.MatchDetailResponseTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableCaching
public class TourService {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    MatchRepository matchRepository;


    @Cacheable(key = "#tourName",value = "Matches")
    public List<MatchDetailResponseTO> getMatchesByTourName(String tourName) throws Exception {
        List<MatchDetailResponseTO> matchDetailResponseTOList = null;
        try {
            matchDetailResponseTOList = new ArrayList<>();
//
            List<Match> matchList = matchRepository.findAllMatchesByTourName(tourName);
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            for (Match match : matchList) {
                matchDetailResponseTOList.add(modelMapper.map(match, MatchDetailResponseTO.class));
            }

        } catch (ValidationFailureException vfe) {
            throw vfe;
        } catch (Exception ex) {
            throw ex;
        }
        return matchDetailResponseTOList;
    }
}
