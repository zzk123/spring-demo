package com.example.hystrixdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zzk
 * @Dare 2023/5/9
 **/
@RestController
public class RibbionController {


    @HystrixCommand(commandProperties = {
            //开启熔断
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_TIMEOUT_ENABLED, value = "true"),
            //最小请求数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "5"),
            //熔断5s
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000"),
            //10秒内 最少请求 5次。若百分比超过 50 则触发熔断
            @HystrixProperty(name =  HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50")
    }, fallbackMethod = "processHystrix_Get") //熔断机制
    @GetMapping("/get")
    public String get(int i){
        if(i == 0){
            throw new RuntimeException("失败了");
        }
        return "收到请求啦!!!!";
    }

    public String processHystrix_Get(int i) {
        return "熔断啦。请求挂啦！！！！！";
    }
}
