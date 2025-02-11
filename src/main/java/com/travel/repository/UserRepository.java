package com.travel.repository;


import com.travel.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
//継承すればデータベースへの CRUD 操作（Create, Read, Update, Delete）を簡単に実装できる


import org.springframework.stereotype.Repository;
//Springにデータアクセス層のクラスとして認識させる


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    //ユーザーをmailアドレスで検索するメソッド
    User findByEmail(String email);

}
