package com.example.demo.reply;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService;
    private final HttpSession session;
}
