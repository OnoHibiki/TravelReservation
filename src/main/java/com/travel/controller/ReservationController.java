package com.travel.controller;
import com.travel.entity.Reservation;
import com.travel.entity.User;
import com.travel.entity.TravelPlan;
import com.travel.service.ReservationService;
import com.travel.service.UserService;
import com.travel.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;  

    @Autowired
    private TravelPlanService travelPlanService; 

    // 予約一覧取得
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // IDで予約取得
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    // 予約登録（修正済み）
    @PostMapping
    public Reservation saveReservation(@RequestBody Map<String, Object> request) {
        try {
            // 型変換の修正
            Integer userId = ((Number) request.get("userId")).intValue();
            Integer travelPlanId = ((Number) request.get("travelPlanId")).intValue();
            String reservedDate = (String) request.get("reservedDate");
            String paymentStatus = (String) request.get("paymentStatus");

            // ユーザーと旅行プランのデータを取得
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId));

            TravelPlan travelPlan = travelPlanService.getTravelPlanById(travelPlanId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Travel Plan not found with id: " + travelPlanId));

            // Reservation オブジェクトを作成
            Reservation reservation = new Reservation();
            reservation.setUser(user);
            reservation.setTravelPlan(travelPlan);
            reservation.setReservedDate(LocalDate.parse(reservedDate));
            reservation.setPaymentStatus(paymentStatus);

            return reservationService.saveReservation(reservation);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request data", e);
        }
    }

    // 予約削除
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }
}
