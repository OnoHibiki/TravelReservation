package com.travel.controller;

import com.travel.entity.TravelPlan;
import com.travel.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/travel-plans")

public class TravelPlanController {
    
    @Autowired
    private TravelPlanService travelPlanService ;

    //旅行プラン一覧取得
    @GetMapping
    public List<TravelPlan>getAllTravelPlans(){
        return travelPlanService.getAllTravelPlans();
    }

    //IDで旅行プラン取得
    @GetMapping("/{id}")
    public Optional<TravelPlan> getTravelPlanById(@PathVariable Integer id){
        return travelPlanService.getTravelPlanById(id);
    }

    //旅行プラン登録
    @PostMapping
    public TravelPlan saveTravelPlan(@RequestBody Map<String, Object> request) {
        String tourName = (String) request.get("tourName"); // ✅ Java側でも `tourName` に変更
        String hotel = (String) request.get("hotel");
        String destination = (String) request.get("destination");
        Integer price = ((Number) request.get("price")).intValue();
        String description = (String) request.get("description");
    
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setTourName(tourName);
        travelPlan.setHotel(hotel);
        travelPlan.setDestination(destination);
        travelPlan.setPrice(price);
        travelPlan.setDescription(description);
    
        return travelPlanService.saveTravelPlan(travelPlan);
    }

    //旅行プラン削除
    @DeleteMapping("/{id}")
    public void deleteTravelPlan(@PathVariable Integer id){
        travelPlanService.deleteTravelPlan(id);
    }

}
