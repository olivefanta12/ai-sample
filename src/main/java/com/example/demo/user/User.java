package com.example.demo.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // object mapping을 hibernate가 할때 디폴트 생성자를 new한다.
@Data
@Entity
@Table(name = "user_tb")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(unique = true) // pk, uk 일때 인덱스를 만들어준다.
    private String username;

    @Column(nullable = false, length = 100)
    private String password;
    private String email; // null 가능!

    // 주소 관련 필드 추가
    private String zipcode;        // 우편번호
    private String address;        // 기본 주소
    private String detailAddress;  // 상세 주소

    @CreationTimestamp
    private LocalDateTime createdAt;

    // RULE : 컬렉션은 생성자에 넣지 않는다.
    @Builder
    public User(Integer id, String username, String password, String email, String zipcode, String address, String detailAddress, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.createdAt = createdAt;
    }

}
