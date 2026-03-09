package com.example.demo.user;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @org.springframework.web.bind.annotation.GetMapping("/join-form")
    public String joinForm() {
        return "join-form";
    }

    @org.springframework.web.bind.annotation.PostMapping("/join")
    public String join(UserRequest.Join reqDTO) {
        userService.join(reqDTO);
        return "redirect:/";
    }
}
