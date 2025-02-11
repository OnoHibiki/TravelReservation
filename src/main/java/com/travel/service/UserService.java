package com.travel.service;

import com.travel.entity.User;
import com.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service //サービスクラスだよというアピール
public class UserService {
    
    @Autowired 
    private UserRepository userRepository ;


    //ユーザー一覧を取得
    public List<User> getAllUsers(){
        return userRepository.findAll(); //findAll()で全てを選択
    }

    //IDでユーザを取得
    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);//sqlでid検索した値が返ってくる
    }

    //ユーザ登録
    public User saveUser(User user){
        return userRepository.save(user);//sqlにデータを追加（user）
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}