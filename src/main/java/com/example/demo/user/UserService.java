package com.example.demo.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.Join reqDTO) {
        User user = User.builder()
                .username(reqDTO.getUsername())
                .password(reqDTO.getPassword())
                .email(reqDTO.getEmail())
                .postcode(reqDTO.getPostcode())
                .address(reqDTO.getAddress())
                .detailAddress(reqDTO.getDetailAddress())
                .extraAddress(reqDTO.getExtraAddress())
                .build();
        userRepository.save(user);
    }
}
