package com.spa_pj_3_2_schedule_develop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * id
 * username
 * email
 * password
 */

@Getter
@NoArgsConstructor  // 생성자 User() {} / jpa가 프록스객체 쓸떄 생성한다
@Entity
@AllArgsConstructor // 임시
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String password;

}
