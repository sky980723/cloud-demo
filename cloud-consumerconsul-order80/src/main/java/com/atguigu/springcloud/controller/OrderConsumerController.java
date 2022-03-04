package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Sky
 */
@RestController
@Slf4j
public class OrderConsumerController {

	public static final String INVOkE_URL = "http://consul-provider-payment";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "/consumer/payment/consul")
	public String paymentInfo() {
		String result = restTemplate.getForObject(INVOkE_URL + "/payment/consul", String.class);

		return result;
	}
}
