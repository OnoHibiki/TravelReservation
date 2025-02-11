package com.travel.service;

import com.travel.entity.Reservation;
import com.travel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;//nullに対応する


@Service
public class ReservationService {
    
        @Autowired
        private ReservationRepository reservationRepository ; //インスタンスの作成

        //予約一覧を取得
        public List<Reservation> getAllReservations(){
            return reservationRepository.findAll();
        }

        //IDで予約を取得
        public Optional<Reservation> getReservationById(Integer id){
            return reservationRepository.findById(id);
        } 

        //予約を登録
        public Reservation saveReservation(Reservation reservation){
            return reservationRepository.save(reservation);
        }

        public void deleteReservation(Integer id){
            reservationRepository.deleteById(id);
        }



}
