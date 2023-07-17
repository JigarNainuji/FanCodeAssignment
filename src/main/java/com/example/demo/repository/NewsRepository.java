package com.example.demo.repository;

import com.example.demo.entity.News;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News,Long> {

    @Query("select n from News n where n.matchId =:matchId ")
    List<News> findAllNewsByMatchId(@Param("matchId") Integer matchId);

    @Query("select n from News n where n.tourId =:tourId ")
    List<News> findAllNewsByTourId(@Param("tourId") Integer tourId);


    @Query("select n from News n where n.sportId =:sportId ")
    List<News> findAllNewsBySportId(@Param("sportId") Integer sportId);
}
