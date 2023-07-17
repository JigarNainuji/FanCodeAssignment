package com.example.demo.repository;

import com.example.demo.entity.Match;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MatchRepository extends CrudRepository<Match, Integer> {

    @Query("select m from Match m")
    List<Match> findAllMatches();

//    @Query("select m from Match m where m.tourId =:tourId")
    @Query("select m from Match m left join m.tour t where t.name =:tourName ")
    List<Match> findAllMatchesByTourName(@Param("tourName") String tourName);

}
