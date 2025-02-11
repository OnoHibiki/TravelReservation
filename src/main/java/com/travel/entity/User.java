package com.travel.entity; //パッケージ宣言

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//データベースのPrimaryKeyを自動生成する。（AUTO_INCREMENT）
    private Integer id ;

    @Column(nullable = false)//nullを許可しない
    private String name ;//顧客名

    @Column(nullable = false, unique = true)//nullを許さず値の重複も許さない
    private String email ;//mail address

    @Column(nullable = false)
    private String password ;

    @Column(nullable = false)
    private String role ;

    // Getters and Setters
    public Integer getId(){
        return id ;
    }

    public void setId(Integer id){
        this.id = id ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public String getEmail(){
        return email ;
    }

    public void setEmail(String email){
        this.email = email ;
    }

    public String getPassword(){
        return password ;
    }

    public void setPassword(String password){
        this.password = password ;
    }

    public String getRole(){
        return role ;
    }

    public void setRole(String role){
        this.role = role ;
    }

}