package com.example.eurekademoclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zzk
 * @Dare 2023/5/12
 **/
@RestController
public class TestController {


    @GetMapping("/test/test")
    public String test(){
        return "测试请求";
    }

}
