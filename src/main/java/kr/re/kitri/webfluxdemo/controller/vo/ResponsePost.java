package kr.re.kitri.webfluxdemo.controller.vo;

import lombok.Data;

@Data
public class ResponsePost {
    private int userId;

    private String title;
    private String body;

}
