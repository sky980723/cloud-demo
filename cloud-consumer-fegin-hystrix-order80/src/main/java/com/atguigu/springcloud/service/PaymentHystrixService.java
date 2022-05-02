package com.atguigu.springcloud.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sky
 * @date 2022-05-02 23:58
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentHystrixService {

	@GetMapping("/payment/hystrix/ok/{id}")
	String PaymentInfo_ok(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	String PaymentInfo_timeout(@PathVariable("id") Integer id);
}
