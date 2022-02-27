package com.atguigu.ssringcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {

	public static final String INVOkE_URL = "http://cloud-provider-payment";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "/consumer/payment/zk")
	public String paymentInfo() {
		String result = restTemplate.getForObject(INVOkE_URL + "/payment/zk", String.class);

		return result;
	}
}
