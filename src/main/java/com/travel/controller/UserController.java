package com.travel.controller;

import com.travel.entity.User;
import com.travel.service.UserService;//サービスクラス（処理）を追加
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users") //エンドポイントの設定。usersというファイルやフォルダがなくてもOK

public class UserController {

    @Autowired
    private UserService userService ;

    //ユーザー一覧取得
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //IDでユーザー取得
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id) ;
    }

    //ユーザー登録
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //ユーザー削除
    @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Integer id){
            userService.deleteUser(id);
        }
    
    @GetMapping("/")
        public String test() {
            return "UserController is working!";
        }

}
