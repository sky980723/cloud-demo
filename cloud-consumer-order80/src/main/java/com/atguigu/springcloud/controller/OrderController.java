package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sky
 */
@RestController
@Slf4j
public class OrderController {

	//public static final String url = "http://localhost:8001";
	public static final String url = "http://cloud-payment-service";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {

		return restTemplate.postForObject(url + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

		return restTemplate.getForObject(url + "/payment/get/" + id, CommonResult.class);
	}

}
