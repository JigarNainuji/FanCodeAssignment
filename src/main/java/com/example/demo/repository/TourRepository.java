package com.example.demo.repository;

import com.example.demo.entity.Tour;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour,Integer> {


    @Query("select t.id from Tour t where t.name =:tourName ")
    Integer findTourIdByTourName(@Param("tourName") String tourName);

}
