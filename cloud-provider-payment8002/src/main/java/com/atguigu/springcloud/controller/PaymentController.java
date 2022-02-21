package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import com.atguigu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sky
 */
@RestController
@Slf4j
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody Payment payment) {

		int result = paymentService.create(payment);

		if (result > 0) {
			return new CommonResult(200, "插入数据库成功,serverPort = " + serverPort, result);
		} else {
			return new CommonResult(444, "插入数据库失败", null);
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);

		if (payment != null) {
			return new CommonResult(200, "查询成功,serverPort = " + serverPort, payment);
		} else {
			return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
		}
	}
}
