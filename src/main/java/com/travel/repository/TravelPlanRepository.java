package com.travel.repository;

import com.travel.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPlanRepository extends JpaRepository<TravelPlan,Integer> {

    
    
}