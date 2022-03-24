package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguigu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sky
 * @date 2022-03-20 22:35
 */
@RestController
@Slf4j
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping(value = "/consumer/payment/feign/timeout")
	public String paymentFeignTimeout() {
		//fegin默认等待1秒钟

		return paymentFeignService.paymentFeignTimeout();
	}
}
