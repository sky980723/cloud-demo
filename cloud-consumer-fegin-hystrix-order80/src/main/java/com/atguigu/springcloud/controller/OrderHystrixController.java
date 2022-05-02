package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author sky
 * @date 2022-05-03 0:02
 */
@RestController
@Slf4j
public class OrderHystrixController {

	@Resource
	PaymentHystrixService paymentHystrixService;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String PaymentInfo_ok(@PathVariable("id") Integer id) {

		return paymentHystrixService.PaymentInfo_ok(id);
	}

	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	public String PaymentInfo_timeout(@PathVariable("id") Integer id) {

		return paymentHystrixService.PaymentInfo_timeout(id);
	}

}
