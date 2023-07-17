package com.example.demo.service;

import com.example.demo.entity.Sport;
import com.example.demo.repository.SportRepository;
import com.example.demo.responseTO.SportDetailsResponseTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SportService {

    @Autowired
    SportRepository sportRepository;

    public List<SportDetailsResponseTO> getAllSportsToursAndMatches(){

        List<Object[]> dataList = sportRepository.getAllSportsToursAndMatches();

        List<SportDetailsResponseTO> resultDataList = new ArrayList<>();
        for(Object[] object:dataList)
        {
            SportDetailsResponseTO sportDetailsResponseTO = new SportDetailsResponseTO();
            sportDetailsResponseTO.setMatchName((String) object[0]);
            sportDetailsResponseTO.setTourName((String)object[1]);
            sportDetailsResponseTO.setSportName((String)object[2]);
            sportDetailsResponseTO.setStartTime((Date)object[3]);
            sportDetailsResponseTO.setFormate((String) object[4]);
            sportDetailsResponseTO.setMatchId((Integer) object[5]);
            resultDataList.add(sportDetailsResponseTO);
        }
        return resultDataList;
    }

}
