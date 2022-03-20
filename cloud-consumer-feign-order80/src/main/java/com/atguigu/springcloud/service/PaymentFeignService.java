package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.util.CommonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Sky
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

	@GetMapping(value = "/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
