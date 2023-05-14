package com.example.ribbonDemo;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="")
public interface TestRemoteClient {
}
