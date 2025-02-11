package com.travel.service;

import com.travel.entity.TravelPlan;
import com.travel.repository.TravelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;//nullに対応する


@Service
public class TravelPlanService {
    
    @Autowired
    private TravelPlanRepository travelPlanRepository;

    //旅行プラン一覧を取得
    public List<TravelPlan> getAllTravelPlans(){
        return travelPlanRepository.findAll();
    }

    //IDで旅行プランを取得（検索）
    public Optional<TravelPlan> getTravelPlanById(Integer id){
        return travelPlanRepository.findById(id);
    }

    //旅行プランを登録
    public TravelPlan saveTravelPlan(TravelPlan travelPlan){
        return travelPlanRepository.save(travelPlan);
    }

    //旅行プランを削除
    public void deleteTravelPlan(Integer id){
        travelPlanRepository.deleteById(id);
    }

}
