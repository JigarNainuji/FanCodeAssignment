package com.example.demo.repository;

import com.example.demo.entity.Match;
import com.example.demo.entity.Sport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportRepository extends CrudRepository<Sport,Integer> {

    @Query(value = "select m.name,t.name,s.name,m.startTime,m.format, m.id from Match m left join m.tour t left join t.sport s")
    List<Object[]> getAllSportsToursAndMatches();
}
