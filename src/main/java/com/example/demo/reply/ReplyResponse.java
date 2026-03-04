package com.example.demo.reply;

import lombok.Data;

public class ReplyResponse {

    @Data
    public static class Detail {
        private Integer id;
        private String comment;

        public Detail(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
        }
    }
}
